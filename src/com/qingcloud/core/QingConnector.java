package com.qingcloud.core;

import com.alibaba.fastjson.JSON;
import com.qingcloud.httpserver.HttpService;
import com.qingcloud.model.request.PublicRequest;
import com.qingcloud.model.response.PublicResponse;

public class QingConnector {
	/**
	 * 构造函数
	 */
	public QingConnector(){
		
	}
	
	//主机接口
	public PublicResponse DescribeInstances(PublicRequest publicRequest){
		HttpService hs = new HttpService();
		String requestString = publicRequest.toString();
		String result = hs.seedSMS(requestString);
		PublicResponse publicResponse = JSON.parseObject(result,PublicResponse.class);
		return publicResponse;
	}
	
	public PublicResponse RunInstances(){return null;}
	public PublicResponse TerminateInstances(){return null;}
	public PublicResponse StartInstances(){return null;}
	public PublicResponse StopInstances(){return null;}
	public PublicResponse RestartInstances(){return null;}
	public PublicResponse ResetInstances(){return null;}
	public PublicResponse ResizeInstances(){return null;}
	public PublicResponse ModifyInstanceAttributes(){return null;}
	
}
