package com.qingcloud.core;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.qingcloud.exception.QingException;
import com.qingcloud.httpserver.HttpService;
import com.qingcloud.model.request.PublicRequest;
import com.qingcloud.model.response.PublicResponse;
import com.qingcloud.model.trans.Trans;
import com.qingcloud.util.QingUtil;

public class QingConnector {
	
	private String qingUrl;
	private String accessKeyid;
	private String accessPrivateKey;
	
	public QingConnector(String qingUrl,String accessKeyid,String accessPrivateKey){
		if(null == qingUrl || "".equals(qingUrl) || qingUrl.endsWith("/")){
			this.qingUrl = qingUrl;
		}else{
			this.qingUrl = qingUrl.substring(0,qingUrl.length()-1);
		}
		this.accessKeyid = accessKeyid;
		this.accessPrivateKey = accessPrivateKey;
	}
	
	//主机接口
	public PublicResponse doTrans(PublicRequest publicRequest,String trans){
		PublicResponse publicResponse = new PublicResponse();
		try {
			String accessParams = "access_key_id="+this.accessKeyid+"&action="+trans+QingUtil.packageDataEncode(publicRequest.generateData());
			String params = QingUtil.sha1Data(accessParams,this.accessPrivateKey,publicRequest.getSignature_method());
			System.out.println("发送："+this.qingUrl+"?"+params);
			String result = HttpService.sendService(this.qingUrl+"?"+params);
			System.out.println("接收："+result);
			publicResponse = JSON.parseObject(result,PublicResponse.class,Feature.AllowISO8601DateFormat);
		} catch (QingException qe) {
			qe.printStackTrace();
			publicResponse.setRet_code("100001");//api默认错误码
			publicResponse.setMessage(qe.getMessage());
			return publicResponse;
		} catch (NoSuchFieldException nsfe) {
			publicResponse.setRet_code("100001");//api默认错误码
			publicResponse.setMessage(nsfe.getMessage());
			return publicResponse;
		} catch (Exception e) {
			e.printStackTrace();
			publicResponse.setRet_code("100001");//api默认错误码
			publicResponse.setMessage(e.getMessage());
			return publicResponse;
		}
		return publicResponse;
	}
}
