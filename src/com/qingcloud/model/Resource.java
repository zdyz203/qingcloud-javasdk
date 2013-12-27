package com.qingcloud.model;
/**
 * 资源
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class Resource {
	/**
	 * 资源id
	 */
	private String resource_id;
	/**
	 * 资源名称
	 */
	private String resource_name;
	/**
	 * 资源类型
	 */
	private String resource_type;
	
	public String getResource_id() {
		return resource_id;
	}
	public void setResource_id(String resourceId) {
		resource_id = resourceId;
	}
	public String getResource_name() {
		return resource_name;
	}
	public void setResource_name(String resourceName) {
		resource_name = resourceName;
	}
	public String getResource_type() {
		return resource_type;
	}
	public void setResource_type(String resourceType) {
		resource_type = resourceType;
	}
	
}
