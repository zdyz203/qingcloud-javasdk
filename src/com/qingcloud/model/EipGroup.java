package com.qingcloud.model;
/**
 * 公网ip分组信息
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class EipGroup {
	/**
	 * 公网ip分组id
	 */
	private String eip_group_id;
	/**
	 * 公网ip分组名称
	 */
	private String eip_group_name;
	public String getEip_group_id() {
		return eip_group_id;
	}
	public void setEip_group_id(String eipGroupId) {
		eip_group_id = eipGroupId;
	}
	public String getEip_group_name() {
		return eip_group_name;
	}
	public void setEip_group_name(String eipGroupName) {
		eip_group_name = eipGroupName;
	}
	
}
