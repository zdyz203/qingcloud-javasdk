package com.qingcloud.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.qingcloud.exception.QingException;

public class QingUtil {
	
	/**
	 * 返回&name=data的形式
	 * @param name
	 * @param data
	 * @return
	 */
	public static String packageData(String name,Object data){
		if(null == name || "".equals(name)){
			return "";
		}
		if(null == data || "".equals(data.toString())){
			return "";
		}
		return "&"+name+"="+data.toString();
	}
	
	/**
	 * 返回&name=data(URLEncoder)的形式
	 * @param name
	 * @param data
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String packageDataEncode(String name,Object data) throws UnsupportedEncodingException{
		if(null == name || "".equals(name)){
			return "";
		}
		if(null == data || "".equals(data.toString())){
			return "";
		}
		return "&"+name+"="+URLEncoder.encode(data.toString(),"UTF-8");
	}
	
	/**
	 * map排序并返回&name=data(URLEncoder)的形式
	 * @param name
	 * @param data
	 * @return
	 * @throws QingException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String packageDataEncode(Map<String,Object> mapData) throws QingException{
		StringBuffer stringData = new StringBuffer();
		try {
			TreeMap<String, Object> treemap = new TreeMap<String, Object>(mapData);
			for(Map.Entry<String, Object> entry : treemap.entrySet()){
				stringData.append(packageDataEncode(entry.getKey(),entry.getValue()));
			}
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
			throw new QingException(uee.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new QingException(e.getMessage());
		}
		return stringData.toString();
	}
	
	/**
	 * map排序并返回&name=data的形式
	 * @param name
	 * @param data
	 * @return
	 */
	public static String packageDataByList(Map<String,Object> mapData){
		StringBuffer stringData = new StringBuffer();
		//排序map
		TreeMap<String, Object> treemap = new TreeMap<String, Object>(mapData);
		for(Map.Entry<String, Object> entry : treemap.entrySet()){
			stringData.append(packageData(entry.getKey(),entry.getValue()));
		}
		return stringData.toString();
	}
//	
//	public static Map<String,Object> getClassMap(Class objClass) throws IllegalArgumentException, IllegalAccessException{
//		Map<String,Object> map = new HashMap<String, Object>();
//		Field[] fields = objClass.getDeclaredFields();
//		for(Field field : fields){
//			Object obj = field.get(objClass);
//			if(null != obj && obj.getClass().isArray()){
//				Object[] objArray = (Object[])obj;
//				int j = 1;
//				for (int i = 0; i < objArray.length; i++){
//					if(null != objArray[i] && !"".equals((objArray[i]))){
//						map.put(field.getName()+"."+j, objArray[i]);
//						j++;
//					}
//				}
//			}else{
//				if(null != obj && !"".endsWith(obj.toString())){
//					map.put(field.getName(), obj.toString());
//				}
//			}
//		}
//		return map;
//	}
	
	/**
	 * 
	 * @param params
	 * @param accessPrivateKey
	 * @return
	 * @throws QingException
	 */
	public static String sha1Data(String params,String accessPrivateKey,String signMethod) throws QingException{
		String signParams = "GET\n/iaas/\n"+params;
		byte[] rawHmac = null;
		try {
			SecretKeySpec signingKey = new SecretKeySpec(accessPrivateKey.getBytes(), signMethod);
			Mac mac = Mac.getInstance(signMethod);
			mac.init(signingKey);  
	        rawHmac = mac.doFinal(signParams.getBytes());  
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
			throw new QingException(nsae.getMessage());
		} catch (InvalidKeyException ike) {
			ike.printStackTrace();
			throw new QingException(ike.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new QingException(e.getMessage());
		}
		return params+"&signature="+new String(com.qingcloud.util.Base64.encode(rawHmac));
	}
	
}
