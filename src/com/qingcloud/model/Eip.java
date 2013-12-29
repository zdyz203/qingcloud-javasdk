package com.qingcloud.model;

import java.sql.Timestamp;

/**
 * 公网 IP 地址
 * 是在互联网上合法的静态 IP 地址。
 *  在青云系统中，公网 IP 地址与您的账户而非特定的资源（主机或路由器）关联， 
 *  您可以将申请到的公网 IP 地址分配到任意位于基础网络 vxnet-0 中的主机或路由器， 
 *  并随时可以解绑、再分配到其他主机或路由器，如此可以快速替换您的对外主机或路由器。
 * @author cuiyutong 2013-12-25
 * @version v1.0.1
 */
public class Eip{
	
	/**
	 * 公网IP唯一标识ID
	 */
	private String eip_id;
	/**
	 * 公网IP名称
	 */
	private String eip_name;
	/**
	 * 公网IP描述
	 */
	private String description;
	/**
	 * 带宽，以 Mbps 为单位
	 */
	private Integer bandwidth;
	/**
	 * 公网IP状态，有效值为pending, available, associated, suspended，released, ceased。
	 * pending： 等待被创建
	 * available： 可用状态，此时可以被绑定到资源上。
	 * associated： 绑定状态
	 * suspended： 由于欠费，已被暂停使用
	 * released： 已被释放会资源池，此时公网IP不可被恢复。
	 * ceased： 已被彻底释放
	 */
	private String status;
	/**
	 * 公网IP过渡状态，有效值为 associating, dissociating, suspending, resuming, releasing。
	 * associating： 绑定到资源中，由 available 状态变成 associated 状态
	 * dissociating： 启动中，由 associated 状态变成 available 状态
	 * suspending： 欠费暂停中，由 available/associated 状态变成 suspended 状态
	 * resuming： 恢复中，由 suspended 状态变成 available 状态
	 * releasing： 删除中，由 available/associated/suspended 状态变成 released 状态
	 */
	private String transition_status;
	/**
	 * 备案号
	 */
	private String icp_codes;
	/**
	 * 公网IP创建时间，为UTC时间
	 */
	private Timestamp create_time;
	/**
	 * 公网IP最近一次状态变更时间，为UTC时间
	 */
	private String status_time;
	/**
	 * 若已分配到主机/路由器，则表示所分配的主机/路由器信息
	 */
	private Resource resource;
	/**
	 * 若已分配到主机/路由器，则表示所分配的主机/路由器信息
	 */
	private EipGroup eip_group;
	/**
	 * 公网IP地址
	 */
	private String eip_addr;
	
	public String getEip_id() {
		return eip_id;
	}
	public void setEip_id(String eipId) {
		eip_id = eipId;
	}
	public String getEip_name() {
		return eip_name;
	}
	public void setEip_name(String eipName) {
		eip_name = eipName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(Integer bandwidth) {
		this.bandwidth = bandwidth;
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
	public String getIcp_codes() {
		return icp_codes;
	}
	public void setIcp_codes(String icpCodes) {
		icp_codes = icpCodes;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp createTime) {
		create_time = createTime;
	}
	public String getStatus_time() {
		return status_time;
	}
	public void setStatus_time(String statusTime) {
		status_time = statusTime;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public EipGroup getEip_group() {
		return eip_group;
	}
	public void setEip_group(EipGroup eipGroup) {
		eip_group = eipGroup;
	}
	public String getEip_addr() {
		return eip_addr;
	}
	public void setEip_addr(String eipAddr) {
		eip_addr = eipAddr;
	}
}
