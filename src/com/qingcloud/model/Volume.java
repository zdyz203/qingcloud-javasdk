package com.qingcloud.model;

import java.sql.Timestamp;


/**
 * 硬盘 (Volume) 为主机提供块存储设备，它独立于主机的生命周期而存在， 
 * 可以被连接到任意运行中的主机上。注意，硬盘附加到主机上后，
 *  您还需要登陆到您的主机的操作系统中去加载该硬盘。
 *  当然， 也可以从主机上卸载硬盘、并转至其他主机。 
 *  注意，请先在您的主机的操作系统中卸载硬盘，然后再在青云系统中卸载。
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class Volume {
	/**
	 * 硬盘ID
	 */
	private String volume_id;
	/**
	 * 硬盘名称
	 */
	private String volume_name;
	/**
	 * 硬盘描述
	 */
	private String description;
	/**
	 * 硬盘空间大小，单位为 GB
	 */
	private Integer size;
	/**
	 * 硬盘状态，有效值为pending, available, in-use, suspended, deleted, ceased。
	 * pending： 等待被创建
	 * available： 可用状态，此时硬盘可以加载到主机上。
	 * in-use： 使用中，此时硬盘已经加载到主机上。
	 * suspended： 由于欠费，已被暂停使用
	 * deleted： 已被删除，但处于此状态的硬盘在2小时之内仍可以被恢复为 available 状态
	 * ceased： 已被彻底删除，处于此状态的硬盘无法恢复
	 */
	private String status;
	/**
	 * 硬盘过渡状态，有效值为creating, attaching, detaching, suspending，resuming，deleting，recovering。
	 * creating： 创建中，由 pending 状态变成 available 状态
	 * attaching： 加载到主机中，由 available 状态变成 in-use 状态
	 * detaching： 从主机卸载中，由 in-use 状态变成 available 状态
	 * suspending： 欠费暂停中，由 available/in-use 状态变成 suspended 状态
	 * resuming： 恢复中，由 suspended 状态变成 available 状态
	 * deleting： 删除中，由 available/in-use/suspended 状态变成 deleted 状态
	 * recovering： 恢复中，由 deleted 状态变成 available 状态
	 */
	private String transition_status;
	/**
	 * 硬盘创建时间，为UTC时间
	 */
	private Timestamp create_time;
	/**
	 * 硬盘最近一次状态变更时间，为UTC时间
	 */
	private Timestamp status_time;
	/**
	 * 硬盘加载的主机信息.
	 * instance_id： 主机ID
	 * instance_name： 主机名称
	 */
	private Instance instance;
	
	public String getVolume_id() {
		return volume_id;
	}
	public void setVolume_id(String volumeId) {
		volume_id = volumeId;
	}
	public String getVolume_name() {
		return volume_name;
	}
	public void setVolume_name(String volumeName) {
		volume_name = volumeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
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
	public Instance getInstance() {
		return instance;
	}
	public void setInstance(Instance instance) {
		this.instance = instance;
	}
}
