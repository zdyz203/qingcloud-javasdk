package com.qingcloud.model;
/**
 * 该功能仅对 Linux 主机有效。
 * 青云官方提供的 Linux 映像是不允许使用密码来 SSH 登录的， 
 * 只接受 SSH 公钥/私钥验证身份。
 * 您可以新建一个 SSH 密钥，并立刻下载其私钥。 
 * 请保管好私钥，因为青云是不保存私钥的。
 * @author cuiyutong
 * @version v1.0.1
 *
 */
public class KeyPair {
	/**
	 * 密钥ID
	 */
	private String keypair_id;
	/**
	 * SSH密钥加密算法，有效值为 ssh-rsa 和 ssh-dss
	 */
	private String encrypt_method;
	/**
	 * SSH密钥名称
	 */
	private String keypair_name;
	/**
	 * SSH密钥描述
	 */
	private String description;
	/**
	 * SSH密钥公钥
	 */
	private String pub_key;
	/**
	 * SSH密钥加载的主机ID列表只有在请求参数中 verbose=1 时才会返回此信息。
	 */
	private String[] instance_ids;
	
	
	public String getKeypair_id() {
		return keypair_id;
	}
	public void setKeypair_id(String keypairId) {
		keypair_id = keypairId;
	}
	public String getEncrypt_method() {
		return encrypt_method;
	}
	public void setEncrypt_method(String encryptMethod) {
		encrypt_method = encryptMethod;
	}
	public String getKeypair_name() {
		return keypair_name;
	}
	public void setKeypair_name(String keypairName) {
		keypair_name = keypairName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPub_key() {
		return pub_key;
	}
	public void setPub_key(String pubKey) {
		pub_key = pubKey;
	}
	public String[] getInstance_ids() {
		return instance_ids;
	}
	public void setInstance_ids(String[] instanceIds) {
		instance_ids = instanceIds;
	}
	
}
