package com.sky.blue.business.stat.entity;

import com.sky.blue.business.beans.BaseEntity;

public class CallStat extends BaseEntity {
	private Integer cp_id;
	private String ccp_id;
	private String cp_name;
	
	private Integer m_id;
	private Integer m_name;
	private Integer show_type;
	private Integer appfee_id;
	private Integer fail_calls;
	private Integer fail_users;
	private Integer succ_calls;
	private Integer succ_users;
	private Integer all_calls;
	private Integer all_users;
	private Integer smsNum;
	private Integer initnum;
	private Integer smsReportNum;
	private Integer product_id;
	private String product_name;
	
	private Integer nofeeinitnum;
	private Integer data_init;
	private Integer data_fee;
	private Integer data_div;
	private Integer data_ret;
	private Integer province_id;
	private String province_name;
	private String packager;
	private String dater;
	private Integer calls;
	private String rate;
	
	private String tag;
	private String protype;
	private Integer cmds;
	private Integer fees;
	private String ch_name;
	
	
	
	public String getProtype() {
		return protype;
	}
	public void setProtype(String protype) {
		this.protype = protype;
	}
	public Integer getNofeeinitnum() {
		return nofeeinitnum;
	}
	public void setNofeeinitnum(Integer nofeeinitnum) {
		this.nofeeinitnum = nofeeinitnum;
	}
	public String getCcp_id() {
		return ccp_id;
	}
	public void setCcp_id(String ccp_id) {
		this.ccp_id = ccp_id;
	}
	public Integer getProvince_id() {
		return province_id;
	}
	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}
	public Integer getCmds() {
		return cmds;
	}
	public void setCmds(Integer cmds) {
		this.cmds = cmds;
	}
	public Integer getSmsReportNum() {
		return smsReportNum;
	}
	public void setSmsReportNum(Integer smsReportNum) {
		this.smsReportNum = smsReportNum;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public Integer getSmsNum() {
		return smsNum;
	}
	public void setSmsNum(Integer smsNum) {
		this.smsNum = smsNum;
	}
	private String op;
 
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getPackager() {
		return packager;
	}
	public void setPackager(String packager) {
		this.packager = packager;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public Integer getInitnum() {
		return initnum;
	}
	public void setInitnum(Integer initnum) {
		this.initnum = initnum;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public Integer getM_name() {
		return m_name;
	}
	public void setM_name(Integer m_name) {
		this.m_name = m_name;
	}
	public Integer getShow_type() {
		return show_type;
	}
	public void setShow_type(Integer show_type) {
		this.show_type = show_type;
	}
	public Integer getData_init() {
		return data_init;
	}
	public void setData_init(Integer data_init) {
		this.data_init = data_init;
	}
	public Integer getData_fee() {
		return data_fee;
	}
	public void setData_fee(Integer data_fee) {
		this.data_fee = data_fee;
	}
	public Integer getData_div() {
		return data_div;
	}
	public void setData_div(Integer data_div) {
		this.data_div = data_div;
	}
	public Integer getData_ret() {
		return data_ret;
	}
	public void setData_ret(Integer data_ret) {
		this.data_ret = data_ret;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getDater() {
		return dater;
	}
	public void setDater(String dater) {
		this.dater = dater;
	}
	public Integer getCalls() {
		return calls;
	}
	public void setCalls(Integer calls) {
		this.calls = calls;
	}
	public Integer getCp_id() {
		return cp_id;
	}
	public void setCp_id(Integer cp_id) {
		this.cp_id = cp_id;
	}
	public Integer getAppfee_id() {
		return appfee_id;
	}
	public void setAppfee_id(Integer appfee_id) {
		this.appfee_id = appfee_id;
	}
	public Integer getFail_calls() {
		return fail_calls;
	}
	public void setFail_calls(Integer fail_calls) {
		this.fail_calls = fail_calls;
	}
	public Integer getFail_users() {
		return fail_users;
	}
	public void setFail_users(Integer fail_users) {
		this.fail_users = fail_users;
	}
	public Integer getSucc_calls() {
		return succ_calls;
	}
	public void setSucc_calls(Integer succ_calls) {
		this.succ_calls = succ_calls;
	}
	public Integer getSucc_users() {
		return succ_users;
	}
	public void setSucc_users(Integer succ_users) {
		this.succ_users = succ_users;
	}
	public Integer getAll_calls() {
		return all_calls;
	}
	public void setAll_calls(Integer all_calls) {
		this.all_calls = all_calls;
	}
	public Integer getAll_users() {
		return all_users;
	}
	public void setAll_users(Integer all_users) {
		this.all_users = all_users;
	}
	public Integer getFees() {
		return fees;
	}
	public void setFees(Integer fees) {
		this.fees = fees;
	}
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}

}
