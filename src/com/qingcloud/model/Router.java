package com.qingcloud.model;

import java.sql.Timestamp;


/**
 * 通过青云的SDN（软件定义网络）技术，您可以快速地搭建您专属的私有云环境。 
 * 相比于基础网络而言，这个网络可以提供100%的安全隔离，而且有丰富的工具帮助您进行自动化管理。
 *  要使用青云网络，请创建一个路由器，然后再创建一个或多个私有网络 ( 私有网络相关 API 可参见 私有网络 ) 
 *  并连接到这个路由器， 最后创建主机并加入到这些私有网络即可。
 *  青云路由器用于 受管私有网络 之间互联，并提供三项附加服务： DHCP 服务、端口转发、VPN 隧道服务。
 *  如果您还希望路由器能接入互联网， 请捆绑一个公网 IP 给该路由器即可。
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class Router {
	/**
	 * 路由器ID
	 */
	private String router_id;
	/**
	 * 路由器名称
	 */
	private String router_name;
	/**
	 * 路由器描述
	 */
	private String description;
	/**
	 * 路由器类型，目前有效值为 1.
	 */
	private Integer router_type;
	/**
	 * 路由器内网IP.
	 */
	private String private_ip;
	/**
	 * 路由器规则是否已更新，1为已更新，0为还未更新。
	 */
	private Integer is_applied;
	/**
	 * 路由器状态，有效值为pending, active, poweroffed, suspended, deleted, ceased。
	 * pending： 等待被创建
	 * active： 运行状态
	 * poweroffed： 关闭状态
	 * suspended： 由于欠费，已被暂停使用
	 * deleted： 已被删除，被删除的路由器不可以被恢复
	 * ceased： 已被彻底删除
	 */
	private String status;
	/**
	 * 路由器过渡状态，有效值为creating, updating, suspending, resuming，poweroffing，poweroning，deleting，。
	 * creating： 创建中，由 pending 状态变成 active 状态
	 * updating： 更新路由器规则中
	 * suspending： 欠费暂停中，由 active/poweroffed 状态变成 suspended 状态
	 * resuming： 恢复中，由 suspended 状态变成 active 状态
	 * poweroffing： 关闭中，由 active 状态变成 poweroffed 状态
	 * poweroning： 开启中，由 poweroffed 状态变成 active 状态
	 * deleting： 删除中，由 active/poweroffed/suspended 状态变成 deleted 状态
	 */
	private String transition_status;
	/**
	 * 路由器创建时间，为UTC时间
	 */
	private Timestamp create_time;
	/**
	 * 路由器最近一次状态变更时间，为UTC时间
	 */
	private Timestamp status_time;
	/**
	 * 路由器的防火墙ID
	 */
	private String security_group_id;
	/**
	 * 路由器的公网IP信息
	 * eip_id： 公网IP的ID
	 * eip_name： 公网IP名称
	 * eip_addr： 公网IP地址
	 */
	private Eip eip;
	/**
	 * 路由器连接的私有网络信息
	 * vxnet_id： 私有网络ID
	 * nic_id： 网卡ID
	 * 只有在请求参数中 verbose=1 时才会返回此信息。
	 */
	private Vxnet[] vxnets;
	
	public String getRouter_id() {
		return router_id;
	}
	public void setRouter_id(String routerId) {
		router_id = routerId;
	}
	public String getRouter_name() {
		return router_name;
	}
	public void setRouter_name(String routerName) {
		router_name = routerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getRouter_type() {
		return router_type;
	}
	public void setRouter_type(Integer routerType) {
		router_type = routerType;
	}
	public String getPrivate_ip() {
		return private_ip;
	}
	public void setPrivate_ip(String privateIp) {
		private_ip = privateIp;
	}
	public Integer getIs_applied() {
		return is_applied;
	}
	public void setIs_applied(Integer isApplied) {
		is_applied = isApplied;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransition_status() {
		return transition_status;
	}
	public void setTransition_status(String transitionStatus) {
		transition_status = transitionStatus;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp createTime) {
		create_time = createTime;
	}
	public Timestamp getStatus_time() {
		return status_time;
	}
	public void setStatus_time(Timestamp statusTime) {
		status_time = statusTime;
	}
	public String getSecurity_group_id() {
		return security_group_id;
	}
	public void setSecurity_group_id(String securityGroupId) {
		security_group_id = securityGroupId;
	}
	public Eip getEip() {
		return eip;
	}
	public void setEip(Eip eip) {
		this.eip = eip;
	}
	public Vxnet[] getVxnets() {
		return vxnets;
	}
	public void setVxnets(Vxnet[] vxnets) {
		this.vxnets = vxnets;
	}
}
