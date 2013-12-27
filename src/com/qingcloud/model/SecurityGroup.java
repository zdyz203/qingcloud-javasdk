package com.qingcloud.model;

import java.sql.Timestamp;


/**
 * 为了加强位于基础网络 vxnet-0 中的主机或路由器的安全性， 
 * 可以在主机或路由器之前放置一个防火墙 (Security Group)。 
 * 青云系统为每个用户提供了一个缺省防火墙（ID 之后带有星标），
 * 当然， 您也可以新建更多的防火墙。
 * 初始状态下，每个防火墙都不包含任何规则， 即，任何端口都是封闭的，您需要建立规则以打开相应的端口。
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class SecurityGroup {
	/**
	 * 防火墙ID
	 */
	private String security_group_id;
	/**
	 * 防火墙名称
	 */
	private String security_group_name;
	/**
	 * 防火墙描述
	 */
	private String description;
	/**
	 * 是否已更新规则，1为已更新，0为还未更新。
	 * 当你修改防火墙的规则后，要“更新规则”才会生效
	 */
	private Integer is_applied;
	/**
	 * 是否是系统默认防火墙，1为是，0为不是
	 */
	private Integer is_default;
	/**
	 * 应用了此防火墙的资源列表，每项资源数据格式为
	 * @see Resource
	 */
	private Resource[] resources;
	/**
	 * 防火墙创建时间，为UTC时间
	 */
	private Timestamp create_time;
	public String getSecurity_group_id() {
		return security_group_id;
	}
	public void setSecurity_group_id(String securityGroupId) {
		security_group_id = securityGroupId;
	}
	public String getSecurity_group_name() {
		return security_group_name;
	}
	public void setSecurity_group_name(String securityGroupName) {
		security_group_name = securityGroupName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIs_applied() {
		return is_applied;
	}
	public void setIs_applied(Integer isApplied) {
		is_applied = isApplied;
	}
	public Integer getIs_default() {
		return is_default;
	}
	public void setIs_default(Integer isDefault) {
		is_default = isDefault;
	}
	public Resource[] getResources() {
		return resources;
	}
	public void setResources(Resource[] resources) {
		this.resources = resources;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp createTime) {
		create_time = createTime;
	}
}
