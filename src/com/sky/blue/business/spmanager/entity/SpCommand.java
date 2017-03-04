package com.sky.blue.business.spmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class SpCommand extends BaseEntity {
	private Integer command_id;
	private Integer sp_id;
	private String sp_name;
	private String feecode_name;
	private String feecode_code;
	private String feecode_number;
	private Integer feecode_id;
	private String command;
	private Integer command_length;
	private Integer command_type;
	private String command_status;
	private Integer command_fee;
	private Float command_share;
	private Integer feecode_op;
	private String create_name;
	private String feecodes;
	//同步指令
	private String synchronous_command;
	//同步端口
	private String synchronous_port;
	//同步条数
	private Integer synchro_num=1;
	//正向|所有
	private int positive_statu;
	
	public Integer getFeecode_op() {
		return feecode_op;
	}
	public void setFeecode_op(Integer feecode_op) {
		this.feecode_op = feecode_op;
	}
	public Integer getCommand_fee() {
		return command_fee;
	}
	public void setCommand_fee(Integer command_fee) {
		this.command_fee = command_fee;
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
	public String getFeecode_number() {
		return feecode_number;
	}
	public void setFeecode_number(String feecode_number) {
		this.feecode_number = feecode_number;
	}
	
	public Integer getCommand_id() {
		return command_id;
	}
	public void setCommand_id(Integer command_id) {
		this.command_id = command_id;
	}
	public Integer getFeecode_id() {
		return feecode_id;
	}
	public void setFeecode_id(Integer feecode_id) {
		this.feecode_id = feecode_id;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Integer getCommand_length() {
		return command_length;
	}
	public void setCommand_length(Integer command_length) {
		this.command_length = command_length;
	}
	public Integer getCommand_type() {
		return command_type;
	}
	public void setCommand_type(Integer command_type) {
		this.command_type = command_type;
	}
	public String getCommand_status() {
		return command_status;
	}
	public void setCommand_status(String command_status) {
		this.command_status = command_status;
	}
	
	

	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	public Float getCommand_share() {
		return command_share;
	}
	public void setCommand_share(Float command_share) {
		this.command_share = command_share;
	}
	
	public String getSynchronous_command() {
		return synchronous_command;
	}
	public void setSynchronous_command(String synchronous_command) {
		this.synchronous_command = synchronous_command;
	}
	public String getSynchronous_port() {
		return synchronous_port;
	}
	public void setSynchronous_port(String synchronous_port) {
		this.synchronous_port = synchronous_port;
	}
	
	public int getPositive_statu() {
		return positive_statu;
	}
	public void setPositive_statu(int positive_statu) {
		this.positive_statu = positive_statu;
	}
	
	
	public Integer getSynchro_num() {
		return synchro_num;
	}
	public void setSynchro_num(Integer synchro_num) {
		this.synchro_num = synchro_num;
	}
	public String getFeecodes() {
		return feecodes;
	}
	public void setFeecodes(String feecodes) {
		this.feecodes = feecodes;
	}
	@Override
	public String toString() {
		return "SpCommand [command_id=" + command_id + ", feecode_id="
				+ feecode_id + ", command=" + command + ", command_length="
				+ command_length + ", command_type=" + command_type
				+ ", command_status=" + command_status + ", positive_statu=" + positive_statu + ", getArrayIds()="
				+ getArrayIds() + ", getRemarks()=" + getRemarks()
				+ ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	
	
}
