package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SmsResource extends BaseEntity {
	private Integer id;
	private Integer sp_id;
	private String sp_name;
	private String sms_code;
	private String sms_name;
	private Integer sms_fee;
	private String channelid;
	private String gateway_code;
	private String gateway_name;
	private String feecode_id;
	private String feecode_name;
	private String feecode_code;
	private String access_url;
	private String create_name;	
	private Integer dtype;
	private String dtag;

	public Integer getDtype() {
		return dtype;
	}
	public void setDtype(Integer dtype) {
		this.dtype = dtype;
	}
	public String getDtag() {
		return dtag;
	}
	public void setDtag(String dtag) {
		this.dtag = dtag;
	}
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
	}
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}
	public Integer getSms_fee() {
		return sms_fee;
	}
	public void setSms_fee(Integer sms_fee) {
		this.sms_fee = sms_fee;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSms_code() {
		return sms_code;
	}
	public void setSms_code(String sms_code) {
		this.sms_code = sms_code;
	}
	public String getSms_name() {
		return sms_name;
	}
	public void setSms_name(String sms_name) {
		this.sms_name = sms_name;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getGateway_code() {
		return gateway_code;
	}
	public void setGateway_code(String gateway_code) {
		this.gateway_code = gateway_code;
	}
	public String getGateway_name() {
		return gateway_name;
	}
	public void setGateway_name(String gateway_name) {
		this.gateway_name = gateway_name;
	}
	public String getFeecode_id() {
		return feecode_id;
	}
	public void setFeecode_id(String feecode_id) {
		this.feecode_id = feecode_id;
	}
	public String getFeecode_name() {
		return feecode_name;
	}
	public void setFeecode_name(String feecode_name) {
		this.feecode_name = feecode_name;
	}
	public String getFeecode_code() {
		return feecode_code;
	}
	public void setFeecode_code(String feecode_code) {
		this.feecode_code = feecode_code;
	}
	public String getAccess_url() {
		return access_url;
	}
	public void setAccess_url(String access_url) {
		this.access_url = access_url;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	
	
	
}
