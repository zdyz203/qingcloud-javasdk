package com.qingcloud.model.response;

import com.qingcloud.model.Instance;

/**
 * 公共响应体
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class PublicResponse {
	/**
	 * 响应动作
	 */
	private String action;
	/**
	 * 响应动作
	 */
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 执行成功与否，0 表示成功，其他值则为错误代码
	 */
	private String ret_code;
	/**
	 * 数量
	 */
	private Integer total_count;
	/**
	 * 主机数据列表
	 */
	private Instance[] instance_set;
	
	
	
	
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getRet_code() {
		return ret_code;
	}
	public void setRet_code(String retCode) {
		ret_code = retCode;
	}
	public Integer getTotal_count() {
		return total_count;
	}
	public void setTotal_count(Integer totalCount) {
		total_count = totalCount;
	}
	public Instance[] getInstance_set() {
		return instance_set;
	}
	public void setInstance_set(Instance[] instanceSet) {
		instance_set = instanceSet;
	}
}
