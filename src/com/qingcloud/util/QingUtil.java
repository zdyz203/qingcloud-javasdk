package com.qingcloud.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
	 * 返回&name=data的形式
	 * @param name
	 * @param data
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String packageDataUrlencode(String name,Object data) throws UnsupportedEncodingException{
		if(null == name || "".equals(name)){
			return "";
		}
		if(null == data || "".equals(data.toString())){
			return "";
		}
		return "&"+name+"="+URLEncoder.encode(data.toString(),"UTF-8");
	}
	
	/**
	 * map排序并返回&name=data(url)的形式
	 * @param name
	 * @param data
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String packageDataEncode(Map<String,Object> mapData) throws UnsupportedEncodingException{
		StringBuffer stringData = new StringBuffer();
		//排序map
		TreeMap<String, Object> treemap = new TreeMap<String, Object>(mapData);
		for(Map.Entry<String, Object> entry : treemap.entrySet()){
			stringData.append(packageDataUrlencode(entry.getKey(),entry.getValue()));
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
	
	public static Map<String,Object> getClassMap(Class objClass) throws IllegalArgumentException, IllegalAccessException{
		Map<String,Object> map = new HashMap<String, Object>();
		Field[] fields = objClass.getDeclaredFields();
		for(Field field : fields){
			Object obj = field.get(objClass);
			if(null != obj && obj.getClass().isArray()){
				Object[] objArray = (Object[])obj;
				int j = 1;
				for (int i = 0; i < objArray.length; i++){
					if(null != objArray[i] && !"".equals((objArray[i]))){
						map.put(field.getName()+"."+j, objArray[i]);
						j++;
					}
				}
			}else{
				if(null != obj && !"".endsWith(obj.toString())){
					map.put(field.getName(), obj.toString());
				}
			}
		}
		return map;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
	}
}
