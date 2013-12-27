package com.qingcloud.model;

import java.sql.Timestamp;


/**
 * 青云为您提供一种随时获取的、弹性的计算能力， 这种计算能力的体现就是主机 (Instance)。
 * 主机就是一台配置好了的服务器， 它有您期望的硬件配置、操作系统和网络配置。
 * 通常情况下， 您的请求可以在10秒到60秒的时间之内完成，所以您完全可以动态地、按需使用计算能力。
 * @author cuiyutong 
 * @version v1.0.1
 */
public class Instance {
	/**
	 * 主机ID
	 */
	private String instance_id;
	/**
	 * 主机名称
	 */
	private String instance_name;
	/**
	 * 主机描述
	 */
	private String description;
	/**
	 * 主机类型, 
	 * small_b	1核	1G	小型B
	 * small_c	1核	2G	小型C
	 * medium_a	2核	2G	中型A
	 * medium_b	2核	4G	中型B
	 * medium_c	2核	8G	中型C
	 * large_a	4核	4G	大型A
	 * large_b	4核	8G	大型B
	 * large_c	4核	16G	大型C
	 */
	private String instance_type;
	/**
	 * 主机CPU核心数目。
	 */
	private Integer vcpus_current;
	/**
	 * 主机内存大小, 单位为MB。
	 */
	private Integer memory_current;
	/**
	 * 主机状态, 有效值为pending, running, stopped, suspended, terminated, ceased。
	 * pending： 等待被创建
	 * running： 运行中
	 * stopped： 已关机
	 * suspended： 由于欠费, 已被暂停使用
	 * terminated： 已被删除, 但处于此状态的主机在2小时之内仍可以被恢复为 running 状态
	 * ceased： 已被彻底删除, 处于此状态的主机无法恢复
	 */
	private String status;
	/**
	 * 主机过渡状态, 
	 * 有效值为creating, starting, stopping, restarting, suspending, resuming, terminating, recovering, resetting。
	 * creating： 创建中, 由 pending 状态变成 running 状态
	 * starting： 启动中, 由 stopped 状态变成 running 状态
	 * stopping： 关闭中, 由 running 状态变成 stopped 状态
	 * restarting： 重启中
	 * suspending： 欠费暂停中, 由 running/stopped 状态变成 suspended 状态
	 * resuming： 恢复中, 由 suspended 状态变成 running 状态
	 * terminating： 删除中, 由 running/stopped/suspended 状态变成 terminated 状态
	 * recovering： 恢复中, 由 terminated 状态变成 running 状态
	 * resetting： 操作系统重置中
	 */
	private String transition_status;
	/**
	 * 主机创建时间, 为UTC时间
	 */
	private Timestamp create_time;
	/**
	 * 主机最近一次状态变更时间, 为UTC时间
	 */
	private Timestamp status_time;
	/**
	 * 主机的模板信息。
	 * processor_type： 支持的处理器类型, 有效值为 64bit 和 32bit
	 * platform： 模板平台, 有效值为 linux 和 windows
	 * os_family： 模板操作系统平台, 有效值为 windows, centos, ubuntu, debian, fedora等
	 * image_size： 模板大小
	 * image_name： 模板名称
	 * provider： 模板提供方, 有效值为 系统模板( system ), 自有模板 ( self )
	 */
	private Image image;
	
	
	/**
	 * 主机的模板ID。
	 */
	private String image_id;
	/**
	 * 私有网络中针对该主机的 DHCP 配置。
	 */
	private String private_ip;
	/**
	 * 私有网络中针对该主机的 DHCP 配置。
	 */
	private RouterStatics dhcp_options;

	
	/**
	 * 主机加入的私有网络信息。
	 * vxnet_id： 私有网络ID
	 * vxnet_name： 私有网络名称
	 * vxnet_type： 私有网络类型, 1 为受管私有网络, 0 为自管私有网络。
	 * nic_id： 主机加入私有网络的网卡ID
	 * private_ip： 主机位于私有网络中的私有地址
	 */
	private Vxnet vxnets;
	/**
	 * 主机的防火墙信息。
	 * security_group_id： 防火墙ID
	 * is_default： 是否为默认防火墙, 1 为是, 0 为不是。
	 * 只有在请求参数中 verbose=1 时才会返回此信息。
	 */
	private SecurityGroup security_group;
	/**
	 * 主机上挂载的硬盘ID
	 * 只有在请求参数中 verbose=1 时才会返回此信息。
	 */
	private String volume_ids;
	/**
	 * 主机上加载的SSH密钥ID
	 * 只有在请求参数中 verbose=1 时才会返回此信息。
	 */
	private String keypair_ids;
	
	public String getInstance_id() {
		return instance_id;
	}
	public void setInstance_id(String instanceId) {
		instance_id = instanceId;
	}
	public String getInstance_name() {
		return instance_name;
	}
	public void setInstance_name(String instanceName) {
		instance_name = instanceName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstance_type() {
		return instance_type;
	}
	public void setInstance_type(String instanceType) {
		instance_type = instanceType;
	}
	public Integer getVcpus_current() {
		return vcpus_current;
	}
	public void setVcpus_current(Integer vcpusCurrent) {
		vcpus_current = vcpusCurrent;
	}
	public Integer getMemory_current() {
		return memory_current;
	}
	public void setMemory_current(Integer memoryCurrent) {
		memory_current = memoryCurrent;
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
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Vxnet getVxnets() {
		return vxnets;
	}
	public void setVxnets(Vxnet vxnets) {
		this.vxnets = vxnets;
	}
	public SecurityGroup getSecurity_group() {
		return security_group;
	}
	public void setSecurity_group(SecurityGroup securityGroup) {
		security_group = securityGroup;
	}
	public String getVolume_ids() {
		return volume_ids;
	}
	public void setVolume_ids(String volumeIds) {
		volume_ids = volumeIds;
	}
	public String getKeypair_ids() {
		return keypair_ids;
	}
	public void setKeypair_ids(String keypairIds) {
		keypair_ids = keypairIds;
	}
	public String getImage_id() {
		return image_id;
	}
	public void setImage_id(String imageId) {
		image_id = imageId;
	}
	public String getPrivate_ip() {
		return private_ip;
	}
	public void setPrivate_ip(String privateIp) {
		private_ip = privateIp;
	}
	public RouterStatics getDhcp_options() {
		return dhcp_options;
	}
	public void setDhcp_options(RouterStatics dhcpOptions) {
		dhcp_options = dhcpOptions;
	}
}
