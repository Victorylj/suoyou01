package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SpCompany extends BaseEntity {
	private Integer sp_id;
	private String sp_name;
	private String sp_address;
	private String create_name;
	
	private Integer sp_gsstatus;
	private String sp_thecontact;
	private String sp_contactmobile;
	private String sp_contactqq;
	private String sp_selectaddress;
	
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
	public String getSp_address() {
		return sp_address;
	}
	public void setSp_address(String sp_address) {
		this.sp_address = sp_address;
	}
	
	
	public Integer getSp_gsstatus() {
		return sp_gsstatus;
	}
	public void setSp_gsstatus(Integer sp_gsstatus) {
		this.sp_gsstatus = sp_gsstatus;
	}
	public String getSp_thecontact() {
		return sp_thecontact;
	}
	public void setSp_thecontact(String sp_thecontact) {
		this.sp_thecontact = sp_thecontact;
	}
	public String getSp_contactmobile() {
		return sp_contactmobile;
	}
	public void setSp_contactmobile(String sp_contactmobile) {
		this.sp_contactmobile = sp_contactmobile;
	}
	public String getSp_contactqq() {
		return sp_contactqq;
	}
	public void setSp_contactqq(String sp_contactqq) {
		this.sp_contactqq = sp_contactqq;
	}
	public String getSp_selectaddress() {
		return sp_selectaddress;
	}
	public void setSp_selectaddress(String sp_selectaddress) {
		this.sp_selectaddress = sp_selectaddress;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	@Override
	public String toString() {
		return "SpCompany [sp_id=" + sp_id + ", sp_name=" + sp_name
				+ ", sp_address=" + sp_address + ", getSp_id()=" + getSp_id()
				+ ", getSp_name()=" + getSp_name() + ", getSp_address()="
				+ getSp_address() + ", getRemarks()=" + getRemarks()
				+ ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
