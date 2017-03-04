package com.sky.blue.business.spmanager.entity;

import java.util.Arrays;

import com.sky.blue.business.beans.BaseEntity;

public class SpInterfaceParam extends BaseEntity {
	
	private Integer sp_id;
	private String sp_tag;
	private String sp_name;
	private Integer id;
	private String linkid;
	private String 	spnumber;
	private String command;
	private String mobile;
	private String status_str;
	private String succ_status;
	private String ip_str;
	private String province;
	private String pro_encoder;
	private String ret_str;
	private String timestr;
	private String url;
	private String ip_port;
	private String create_name;
	private String cparams;
	
	
	public String getCparams() {
		return cparams;
	}
	public void setCparams(String cparams) {
		this.cparams = cparams;
	}
	public String getSp_tag() {
		return sp_tag;
	}
	public void setSp_tag(String sp_tag) {
		this.sp_tag = sp_tag;
	}
	public String getStatus_str() {
		return status_str;
	}
	public void setStatus_str(String status_str) {
		this.status_str = status_str;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	public String getIp_port() {
		return ip_port;
	}
	public void setIp_port(String ip_port) {
		this.ip_port = ip_port;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkid() {
		return linkid;
	}
	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}
	public String getSpnumber() {
		return spnumber;
	}
	public void setSpnumber(String spnumber) {
		this.spnumber = spnumber;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSucc_status() {
		return succ_status;
	}
	public void setSucc_status(String succ_status) {
		this.succ_status = succ_status;
	}
	public String getIp_str() {
		return ip_str;
	}
	public void setIp_str(String ip_str) {
		this.ip_str = ip_str;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPro_encoder() {
		return pro_encoder;
	}
	public void setPro_encoder(String pro_encoder) {
		this.pro_encoder = pro_encoder;
	}
	public String getRet_str() {
		return ret_str;
	}
	public void setRet_str(String ret_str) {
		this.ret_str = ret_str;
	}
	public String getTimestr() {
		return timestr;
	}
	public void setTimestr(String timestr) {
		this.timestr = timestr;
	}
	
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	@Override
	public String toString() {
		return "SpInterfaceParam [sp_id=" + sp_id + ", id=" + id + ", linkid="
				+ linkid + ", spnumber=" + spnumber + ", command=" + command
				+ ", mobile=" + mobile + ", succ_status=" + succ_status
				+ ", ip_str=" + ip_str + ", province=" + province
				+ ", pro_encoder=" + pro_encoder + ", ret_str=" + ret_str
				+ ", timestr=" + timestr + ", getIds()="
				+ Arrays.toString(getIds()) + ", getArrayIds()="
				+ getArrayIds() + ", getRemarks()=" + getRemarks()
				+ ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name()
				+ ", getStart_time()=" + getStart_time() + ", getEnd_time()="
				+ getEnd_time() + "]";
	}

	
	
}
