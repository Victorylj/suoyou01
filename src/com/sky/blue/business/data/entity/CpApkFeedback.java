package com.sky.blue.business.data.entity;

import com.sky.blue.business.beans.BaseEntity;

public class CpApkFeedback extends BaseEntity{
	private Integer id;
	private String channel; //渠道
	private String packages; //包名
	private String version; //版本
	private String imsi;
	private String imei;
	private String Email; //邮件
	private String text; //反馈意见
	private String savetime; //更新时间
	
	public Integer getId() {
		return id;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSavetime() {
		return savetime;
	}
	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
