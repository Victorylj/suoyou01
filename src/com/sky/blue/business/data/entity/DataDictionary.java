package com.sky.blue.business.data.entity;

import com.sky.blue.business.beans.BaseEntity;

public class DataDictionary extends BaseEntity{
	private Integer id;
	private Integer code;
	private Integer swtichs;
	private Integer time;
	private Integer daymaxdata;
	private Integer monthmaxdata;
	private Integer paydata;
	private Integer appf_id;
	private String cpids;
	private Integer isall;
	public DataDictionary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataDictionary(Integer id, Integer code, Integer swtichs,
			Integer time, Integer daymaxdata, Integer monthmaxdata,
			Integer paydata, Integer appf_id, String cpids) {
		super();
		this.id = id;
		this.code = code;
		this.swtichs = swtichs;
		this.time = time;
		this.daymaxdata = daymaxdata;
		this.monthmaxdata = monthmaxdata;
		this.paydata = paydata;
		this.appf_id = appf_id;
		this.cpids = cpids;
	}
	
	
	public Integer getIsall() {
		return isall;
	}
	public void setIsall(Integer isall) {
		this.isall = isall;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getSwtichs() {
		return swtichs;
	}
	public void setSwtichs(Integer swtichs) {
		this.swtichs = swtichs;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getDaymaxdata() {
		return daymaxdata;
	}
	public void setDaymaxdata(Integer daymaxdata) {
		this.daymaxdata = daymaxdata;
	}
	public Integer getMonthmaxdata() {
		return monthmaxdata;
	}
	public void setMonthmaxdata(Integer monthmaxdata) {
		this.monthmaxdata = monthmaxdata;
	}
	public Integer getPaydata() {
		return paydata;
	}
	public void setPaydata(Integer paydata) {
		this.paydata = paydata;
	}
	public Integer getAppf_id() {
		return appf_id;
	}
	public void setAppf_id(Integer appf_id) {
		this.appf_id = appf_id;
	}
	public String getCpids() {
		return cpids;
	}
	public void setCpids(String cpids) {
		this.cpids = cpids;
	}
	
	
	
	
}
