package com.qingcloud.model;
/**
 * 
 * @author THINK
 *
 */
public class SecurityGroupRules {
	/**
	 * 防火墙ID
	 */
	private String security_group_id;
	/**
	 * 防火墙规则ID
	 */
	private String security_group_rule_id;
	/**
	 * 防火墙规则名称
	 */
	private String security_group_rule_name;
	/**
	 * 防火墙规则优先级。优先级由高到低的范围是 0 到 100，值越大优先级越低。
	 */
	private Integer priority;
	/**
	 * 协议
	 */
	private String protocol;
	/**
	 * 操作，accept 表示接受，drop 表示拒绝。
	 */
	private String action;
	/**
	 * 如果协议为 tcp 或 udp，此值表示起始端口。
	 * 如果协议为 icmp，此值表示 ICMP 类型。 
	 * ICMP 类型及代码 
	 */
	private String val1;
	/**
	 * 如果协议为 tcp 或 udp，此值表示结束端口。
	 * 如果协议为 icmp，此值表示 ICMP 代码。
	 */
	private String val2;
	/**
	 * 源IP
	 */
	private String val3;
	/**
	 * 方向，0 表示下行，1 表示上行。默认为 0。
	 */
	private String direction;
	
	public String getSecurity_group_id() {
		return security_group_id;
	}
	public void setSecurity_group_id(String securityGroupId) {
		security_group_id = securityGroupId;
	}
	public String getSecurity_group_rule_id() {
		return security_group_rule_id;
	}
	public void setSecurity_group_rule_id(String securityGroupRuleId) {
		security_group_rule_id = securityGroupRuleId;
	}
	public String getSecurity_group_rule_name() {
		return security_group_rule_name;
	}
	public void setSecurity_group_rule_name(String securityGroupRuleName) {
		security_group_rule_name = securityGroupRuleName;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
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
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
