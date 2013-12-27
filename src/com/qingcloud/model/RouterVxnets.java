package com.qingcloud.model;

import java.sql.Timestamp;

/**
 * 路由器管理的私有网络列表
 * @author cuiyutong
 * @version v1.0.1
 */
public class RouterVxnets {
	/**
	 * 路由id
	 */
	private String router_id;
	/**
	 * 私有网络管理地址
	 */
	private String manager_ip;
	/**
	 * 私有网络的id
	 */
	private String vxnet_id;
	/**
	 * 私有网络 DHCP 地址范围
	 */
	private String ip_network;
	/**
	 * 私有网络 DHCP 起始地址
	 */
	private String dyn_ip_start;
	/**
	 * 私有网络 DHCP 终止地址
	 */
	private String dyn_ip_end;
	/**
	 * 私有网络开启的功能，有效值为 1，表示开启 DHCP 地址分配功能。
	 */
	private String features;
	/**
	 * 私有网络连接路由器的创建时间，为UTC时间
	 */
	private Timestamp create_time;
	
	
	public String getRouter_id() {
		return router_id;
	}
	public void setRouter_id(String routerId) {
		router_id = routerId;
	}
	public String getManager_ip() {
		return manager_ip;
	}
	public void setManager_ip(String managerIp) {
		manager_ip = managerIp;
	}
	public String getVxnet_id() {
		return vxnet_id;
	}
	public void setVxnet_id(String vxnetId) {
		vxnet_id = vxnetId;
	}
	public String getIp_network() {
		return ip_network;
	}
	public void setIp_network(String ipNetwork) {
		ip_network = ipNetwork;
	}
	public String getDyn_ip_start() {
		return dyn_ip_start;
	}
	public void setDyn_ip_start(String dynIpStart) {
		dyn_ip_start = dynIpStart;
	}
	public String getDyn_ip_end() {
		return dyn_ip_end;
	}
	public void setDyn_ip_end(String dynIpEnd) {
		dyn_ip_end = dynIpEnd;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp createTime) {
		create_time = createTime;
	}
}
