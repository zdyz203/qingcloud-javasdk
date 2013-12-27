package com.qingcloud.model;

import java.sql.Timestamp;

/**
 * 通过青云的SDN（软件定义网络）技术，您可以快速地搭建您专属的私有云环境。 
 * 相比于基础网络而言，这个网络可以提供100%的安全隔离，而且有丰富的工具帮助您进行自动化管理。 
 * 要使用青云网络，请创建一个路由器 ( 路由器相关 API 可参见 路由器 )， 
 * 然后再创建一个或多个私有网络并连接到这个路由器， 最后创建主机并加入到这些私有网络即可。
 * 私有网络用于主机之间互联，它类似物理世界中使用交换机（L2 Switch）组成的局域网。 
 * 私有网络之间是100%隔离的。
 * 青云私有网络有两种类型
 * 受管私有网络： 可以使用青云路由器来配置和管理其网络，使网络搭建更方便快捷。
 * 自管私有网络： 需要您自行配置和管理网络，适用于对底层网络有特殊需求的用户。
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class Vxnet {
	/**
	 * 私有网络 ID
	 */
	private String vxnet_id;
	/**
	 * 私有网络类型，分为 1 - 受管私有网络，0 - 自管私有网络。
	 */
	private String vxnet_type;
	/**
	 * 私有网络名称
	 */
	private String vxnet_name;
	/**
	 * 创建时间
	 */
	private Timestamp create_time;
	/**
	 * 私有网络的描述
	 */
	private String description;
	/**
	 * 已加入此私有网络的主机ID列表。只有在请求参数中 verbose=1 才会返回此项。
	 */
	private String[] instance_ids;
	/**
	 * 与此私有网络相连的路由器信息，数据格式为:
	 */
	private Router router;
	
	public String getVxnet_id() {
		return vxnet_id;
	}
	public void setVxnet_id(String vxnetId) {
		vxnet_id = vxnetId;
	}
	public String getVxnet_type() {
		return vxnet_type;
	}
	public void setVxnet_type(String vxnetType) {
		vxnet_type = vxnetType;
	}
	public String getVxnet_name() {
		return vxnet_name;
	}
	public void setVxnet_name(String vxnetName) {
		vxnet_name = vxnetName;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp createTime) {
		create_time = createTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String[] getInstance_ids() {
		return instance_ids;
	}
	public void setInstance_ids(String[] instanceIds) {
		instance_ids = instanceIds;
	}
	public Router getRouter() {
		return router;
	}
	public void setRouter(Router router) {
		this.router = router;
	}
}
