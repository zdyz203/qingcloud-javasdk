package com.qingcloud.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import com.qingcloud.model.Eip;
import com.qingcloud.model.Image;
import com.qingcloud.model.response.PublicResponse;
import com.qingcloud.util.QingUtil;

public class HttpService {
	
	public String seedSMS(String params)
	{
		StringBuffer document = new StringBuffer();		
		try{	
			URL url = new URL("https://api.qingcloud.com/iaas/?action=DescribeInstances"+params);
			URLConnection conn = url.openConnection();		    
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;  
			while ((line = reader.readLine()) != null)	
				document.append(line + " ");		 
			reader.close();	
		}catch(MalformedURLException e) {
			e.printStackTrace(); 
		}catch(IOException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return document.toString().trim();
	}
	
	public static void main(String[] args) throws NoSuchFieldException, Exception {
		Eip e = new Eip();
//		e.setStatusn("11111");
//		e.setEips0n("22222");
//		String[] aa = {"44444","55555"};
//		e.setInstances(aa);
//		Image im = new Image();
//		im.setImageid("im1");
//		im.setImagename("imaname");
//		e.setIm(im);
//		Map<String,Object> maps = e.generateData();
//		String es = QingUtil.packageDataByList(maps);
//		System.out.println(es);
		
//		String jsonString = JSON.toJSONString(e);
		
//		String jsonStrings = JSON.toJSONString(e);
//		System.out.println(jsonStrings);
//		Eip esss = JSON.parseObject(jsonStrings,Eip.class);
//		System.out.println(esss.getEips0n());
//		System.out.println(esss.getStatusn());
//		System.out.println(esss.getInstances().length);
//		System.out.println(esss.getIm().getImageid());
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("b", "222");
//		map.put("a", "111");
//		map.put("s", "111");
//		map.put("c", "111");
//		map.put("x", "111");
//		//默认是按顺序排序的
//		String jsonString3 = JSON.toJSONString(map);
//		System.out.println(jsonString);
//		System.out.println(jsonString3);
		
	//	String parame =  QingUtil.packageDataByList(e.getData());
	//	String parameed = QingUtil.packageDataEncode(e.getData());
		//System.out.println(parame);
		//System.out.println(parameed);
//		HttpService service = new HttpService();
//		PublicResponse pr = JSON.parseObject(service.seedSMS("","",""),PublicResponse.class);
//		System.out.println(pr.getRet_code());
//		System.out.println(pr.getMessage());
		
	}
}
