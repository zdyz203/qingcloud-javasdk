package com.qingcloud.model.request;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.qingcloud.util.QingUtil;

/**
 * 公共请求体
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class PublicRequest {
	/**
	 * 主机的id列表
	 */
	private String[] instances;
	/**
	 * 映像id列表
	 */
	private String[] image_id;
	/**
	 * 区域id
	 */
	private String zone;
	/**
	 * 
	 */
	private String time_stamp;
	/**
	 * 
	 */
	private String signature_method;
	/**
	 * 
	 */
	private String signature_version;
	
	public String getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(String timeStamp) {
		time_stamp = timeStamp;
	}

	public String getSignature_method() {
		return signature_method;
	}

	public void setSignature_method(String signatureMethod) {
		signature_method = signatureMethod;
	}

	public String getSignature_version() {
		return signature_version;
	}

	public void setSignature_version(String signatureVersion) {
		signature_version = signatureVersion;
	}
	
	public String[] getInstances() {
		return instances;
	}

	public void setInstances(String[] instances) {
		this.instances = instances;
	}

	public String[] getImage_id() {
		return image_id;
	}

	public void setImage_id(String[] imageId) {
		image_id = imageId;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public Map<String,Object> generateData() throws Exception, NoSuchFieldException{
		Map<String,Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields){
			Object obj = field.get(this);
			if(null != obj && obj.getClass().isArray()){
				String[] objArray = (String[]) obj;
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
	
	public static void main(String[] args) throws NoSuchFieldException, Exception {
		PublicRequest pr = new PublicRequest();
		pr.setImage_id(new String[]{"im1","im2"});
		pr.setInstances(new String[]{"im1","im2"});
		pr.setZone("1");
		System.out.println(QingUtil.sha1Data(QingUtil.packageDataEncode(pr.generateData()),"tPDFuwrXLDEwdnhENhoS1hJYgzuTafm7Luxl2ywe","HmacSHA1"));
	}
}
