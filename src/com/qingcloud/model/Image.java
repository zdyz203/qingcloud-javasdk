package com.qingcloud.model;

import java.sql.Timestamp;

/**
 * 映像 (Image) 是带有操作系统的主机模板。 
 * 青云官方会提供主流的 Linux、Windows 模板，
 * 并根据上游厂商更新版本时及时制作新模板。 
 * 用户也可以在将自己名下的主机制作成模板，以备后用。
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class Image {
	/**
	 * 映像ID
	 */
	private String image_id;
	/**
	 * 映像名称
	 */
	private String image_name;
	/**
	 * 映像描述
	 */
	private String description;
	/**
	 * 映像空间大小，单位为 GB
	 */
	private Integer size;
	/**
	 * 映像支持的处理器类型，有效值为 64bit 和 32bit
	 */
	private String processor_type;
	/**
	 * 映像操作系统平台，有效值为 linux 和 windows
	 */
	private String platform;
	/**
	 * 映像操作系统发行版，有效值为 centos，ubuntu，debian，fedora 和 windows 等
	 */
	private String os_family;
	/**
	 * 映像的可见范围，有效值为 public 和 private
	 */
	private String visibility;
	/**
	 * 映像提供者，有效值为 system 和 self
	 * system: 映像提供者为青云系统self: 映像提供者为用户自己
	 */
	private String provider;
	/**
	 * 映像提供者ID
	 */
	private String owner;
	/**
	 * 运行该映像的推荐主机配置
	 */
	private String recommended_type;
	/**
	 * 映像状态，有效值为pending, available, deprecated, suspended, deleted, ceased.
	 * pending： 等待被创建
	 * available： 可用状态，此时可以基于该映像创建主机。
	 * deprecated： 已被弃用，此时不再可以基于该映像创建新的主机，但不影响已有主机的正常使用。
	 * suspended： 由于欠费，已被暂停使用
	 * deleted： 已被删除，但处于此状态的映像在2小时之内仍可以被恢复为 available 状态
	 * ceased： 已被彻底删除，处于此状态的映像无法恢复
	 *  
	 */
	private String status;
	/**
	 * 映像过渡状态，有效值为creating, suspending，resuming，deleting，recovering。
	 * creating： 创建中，由 pending 状态变成 available 状态
	 * suspending： 欠费暂停中，由 available 状态变成 suspended 状态
	 * resuming： 恢复中，由 suspended 状态变成 available 状态
	 * deleting： 删除中，由 available/suspended 状态变成 deleted 状态
	 * recovering： 恢复中，由 deleted 状态变成 available 状态
	 */
	private String transition_status;
	/**
	 * 映像创建时间，为UTC时间
	 */
	private Timestamp create_time;
	/**
	 * 映像最近一次状态变更时间，为UTC时间
	 */
	private Timestamp status_time;
	
	/**
	 * 映像ID
	 */
	public String getImage_id() {
		return image_id;
	}
	/**
	 * 映像ID
	 */
	public void setImage_id(String imageId) {
		image_id = imageId;
	}
	
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String imageName) {
		image_name = imageName;
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
	public String getProcessor_type() {
		return processor_type;
	}
	public void setProcessor_type(String processorType) {
		processor_type = processorType;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getOs_family() {
		return os_family;
	}
	public void setOs_family(String osFamily) {
		os_family = osFamily;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRecommended_type() {
		return recommended_type;
	}
	public void setRecommended_type(String recommendedType) {
		recommended_type = recommendedType;
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
}
