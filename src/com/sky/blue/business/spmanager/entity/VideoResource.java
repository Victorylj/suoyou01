package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class VideoResource extends BaseEntity {
	private Integer id;
	private Integer sp_id;
	private String sp_name;
	private String video_code;
	private String video_name;
	private String channelid;
	private String gateway_code;
	private String gateway_name;
	private String feecode_id;
	private String feecode_name;
	private String feecode_code;
	private String access_url;
	private String create_name;
	
	
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVideo_code() {
		return video_code;
	}
	public void setVideo_code(String video_code) {
		this.video_code = video_code;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
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
