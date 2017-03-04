package com.sky.blue.business.level.entity;

import com.sky.blue.business.beans.BaseEntity;

public class AutoCmdLevel extends BaseEntity{
	private Integer id;
	private Integer op;
	private String feecode_number;
	private String command;
	private Integer level;
	private Integer limit_num;
	private Integer call_num;
	private Integer deal_type;
	private Integer status;
	private String create_time;
	private String create_name;
	public AutoCmdLevel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AutoCmdLevel [id=" + id + ", feecode_number=" + feecode_number
				+ ", command=" + command + ", level=" + level + ", limit_num="
				+ limit_num + ", call_num=" + call_num + ", deal_type="
				+ deal_type + ", status=" + status + ", create_time="
				+ create_time + ", create_name=" + create_name + "]";
	}
	
	
	public Integer getOp() {
		return op;
	}
	public void setOp(Integer op) {
		this.op = op;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFeecode_number() {
		return feecode_number;
	}
	public void setFeecode_number(String feecode_number) {
		this.feecode_number = feecode_number;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getLimit_num() {
		return limit_num;
	}
	public void setLimit_num(Integer limit_num) {
		this.limit_num = limit_num;
	}
	public Integer getCall_num() {
		return call_num;
	}
	public void setCall_num(Integer call_num) {
		this.call_num = call_num;
	}
	public Integer getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(Integer deal_type) {
		this.deal_type = deal_type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	
}
