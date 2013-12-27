package com.qingcloud.model;

import java.sql.Timestamp;

/**
 * 路由器的规则
 * @author cuiyutong
 * @version v1.0.1
 */
public class RouterStatics {
	/**
	 * 规则id
	 */
	private String router_static_id;
	/**
	 * 规则类型。支持的规则类型有： “1”: 端口转发规则； “2”: VPN规则； “3”: DHCP选项； “4”：GRE隧道。
	 */
	private String static_type;
	/**
	 * 当规则类型为端口转发规则时(static_type=1)，val1表示源端口。
	 * 当规则类型为VPN规则时(static_type=2)，val1表示VPN类型，目前只支持”openvpn”, 默认值也为”openvpn”。
	 * 当规则类型为DHCP选项时(static_type=3)，val1表示DHCP主机ID。
	 */
	private String val1;
	/**
	 * 当规则类型为端口转发规则时(static_type=1)，val2表示目标IP。
	 * 当规则类型为VPN规则时(static_type=2)，val2表示VPN服务端口号，默认为1194。
	 * 当规则类型为DHCP选项时(static_type=3)，val2表示DHCP配置内容，
	 * 格式为key1=value1;key2=value2，例如：”domain-name-servers=8.8.8.8”。
	 */
	private String val2;
	/**
	 * 当规则类型为端口转发规则时(static_type=1)，val3表示目标端口号。
	 * 当规则类型为VPN规则时(static_type=2)，val3表示VPN协议，默认为”udp”。
	 */
	private String val3;
	/**
	 * 当规则类型为端口转发规则时(static_type=1)，val4表示端口转发协议，默认为”tcp”，目前支持”tcp”和”udp”两种协议。
	 * 当规则类型为VPN规则时(static_type=2)，val4表示VPN客户端的网络地址段，
	 * 目前支持10.255.x.0/24，x的范围是[0-255]，默认为自动分配。
	 */
	private String val4;
	/**
	 * 路由id
	 */
	private String router_id;
	/**
	 * 私有网络id
	 */
	private String vxnet_id;
	/**
	 * 创建时间
	 */
	private Timestamp create_time;
	
	public String getRouter_static_id() {
		return router_static_id;
	}
	public void setRouter_static_id(String routerStaticId) {
		router_static_id = routerStaticId;
	}
	public String getStatic_type() {
		return static_type;
	}
	public void setStatic_type(String staticType) {
		static_type = staticType;
	}
	public String getVal1() {
		return val1;
	}
	public void setVal1(String val1) {
		this.val1 = val1;
	}
	public String getVal2() {
		return val2;
	}
	public void setVal2(String val2) {
		this.val2 = val2;
	}
	public String getVal3() {
		return val3;
	}
	public void setVal3(String val3) {
		this.val3 = val3;
	}
	public String getVal4() {
		return val4;
	}
	public void setVal4(String val4) {
		this.val4 = val4;
	}
	public String getRouter_id() {
		return router_id;
	}
	public void setRouter_id(String routerId) {
		router_id = routerId;
	}
	public String getVxnet_id() {
		return vxnet_id;
	}
	public void setVxnet_id(String vxnetId) {
		vxnet_id = vxnetId;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp createTime) {
		create_time = createTime;
	}
}
