package com.sky.blue.business.complaint.entity;

import com.sky.blue.business.beans.BaseEntity;

public class ComplaintStat extends BaseEntity {
	private String cp_id;
	private String cp_name;
	private String ch_name;
	private int allinit;
	private int succusers;
	private int allusers;
	private int cusers;
	private String rate;
	private String dater;
	private Integer tag;
	private Integer vtag;
	
	
	
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}


	public Integer getVtag() {
		return vtag;
	}
	public void setVtag(Integer vtag) {
		this.vtag = vtag;
	}
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public String getCp_id() {
		return cp_id;
	}
	public void setCp_id(String cp_id) {
		this.cp_id = cp_id;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public int getAllinit() {
		return allinit;
	}
	public void setAllinit(int allinit) {
		this.allinit = allinit;
	}
	public int getSuccusers() {
		return succusers;
	}
	public void setSuccusers(int succusers) {
		this.succusers = succusers;
	}
	public int getAllusers() {
		return allusers;
	}
	public void setAllusers(int allusers) {
		this.allusers = allusers;
	}
	public int getCusers() {
		return cusers;
	}
	public void setCusers(int cusers) {
		this.cusers = cusers;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}
	
	
}
