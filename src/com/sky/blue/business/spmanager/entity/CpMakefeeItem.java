package com.sky.blue.business.spmanager.entity;

import java.util.Arrays;


public class CpMakefeeItem extends SpCommand {
	
	private Integer cp_item_id;
	private String cp_item_code;
	private String cp_item_name;

	//private Integer sp_id;
	//private String sp_name;
	//private Integer feecode_id;
	//private String feecode_name;
	//private String feecode_code;
	private Integer feecode_fee;
	//private String feecode_number;
	private Integer feecode_op;
	private String item_status;
	private String item_stat;
	//private String command_status;
	//private String command;
	//private String command_fee;

	private String citys[];
	private String hide_city;
	private Integer is_second;
	private String second_port;
	private String second_info;
	private Integer second_type;
	private String replay_start_str;
	private String replay_end_str;
	private String replay_str;
	private Integer is_filter;
	private String filter_port;
	private String filter_info;
	private String network_role;
	private Integer sms_delay_time;
	private Integer use_priority;
	private Integer open_province_id;
	private String open_province_name;
	private Integer item_count;
	private String province[];
	private String openProvinceStr;
	private Integer fees;
	private String create_name;
	
	public Integer getCp_item_id() {
		return cp_item_id;
	}
	public void setCp_item_id(Integer cp_item_id) {
		this.cp_item_id = cp_item_id;
	}
	public String getCp_item_code() {
		return cp_item_code;
	}
	public void setCp_item_code(String cp_item_code) {
		this.cp_item_code = cp_item_code;
	}
	public String getCp_item_name() {
		return cp_item_name;
	}
	public void setCp_item_name(String cp_item_name) {
		this.cp_item_name = cp_item_name;
	}
	public Integer getFeecode_fee() {
		return feecode_fee;
	}
	public void setFeecode_fee(Integer feecode_fee) {
		this.feecode_fee = feecode_fee;
	}
	public Integer getFeecode_op() {
		return feecode_op;
	}
	public void setFeecode_op(Integer feecode_op) {
		this.feecode_op = feecode_op;
	}
	public String getItem_status() {
		return item_status;
	}
	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}
	public String getItem_stat() {
		return item_stat;
	}
	public void setItem_stat(String item_stat) {
		this.item_stat = item_stat;
	}
	public String[] getCitys() {
		return citys;
	}
	public void setCitys(String[] citys) {
		this.citys = citys;
	}
	public String getHide_city() {
		return hide_city;
	}
	public void setHide_city(String hide_city) {
		this.hide_city = hide_city;
	}
	public Integer getIs_second() {
		return is_second;
	}
	public void setIs_second(Integer is_second) {
		this.is_second = is_second;
	}
	public String getSecond_port() {
		return second_port;
	}
	public void setSecond_port(String second_port) {
		this.second_port = second_port;
	}
	public String getSecond_info() {
		return second_info;
	}
	public void setSecond_info(String second_info) {
		this.second_info = second_info;
	}
	public Integer getSecond_type() {
		return second_type;
	}
	public void setSecond_type(Integer second_type) {
		this.second_type = second_type;
	}
	public String getReplay_start_str() {
		return replay_start_str;
	}
	public void setReplay_start_str(String replay_start_str) {
		this.replay_start_str = replay_start_str;
	}
	public String getReplay_end_str() {
		return replay_end_str;
	}
	public void setReplay_end_str(String replay_end_str) {
		this.replay_end_str = replay_end_str;
	}
	public String getReplay_str() {
		return replay_str;
	}
	public void setReplay_str(String replay_str) {
		this.replay_str = replay_str;
	}
	public Integer getIs_filter() {
		return is_filter;
	}
	public void setIs_filter(Integer is_filter) {
		this.is_filter = is_filter;
	}
	public String getFilter_port() {
		return filter_port;
	}
	public void setFilter_port(String filter_port) {
		this.filter_port = filter_port;
	}
	public String getFilter_info() {
		return filter_info;
	}
	public void setFilter_info(String filter_info) {
		this.filter_info = filter_info;
	}
	public String getNetwork_role() {
		return network_role;
	}
	public void setNetwork_role(String network_role) {
		this.network_role = network_role;
	}
	public Integer getSms_delay_time() {
		return sms_delay_time;
	}
	public void setSms_delay_time(Integer sms_delay_time) {
		this.sms_delay_time = sms_delay_time;
	}
	public Integer getUse_priority() {
		return use_priority;
	}
	public void setUse_priority(Integer use_priority) {
		this.use_priority = use_priority;
	}
	public Integer getOpen_province_id() {
		return open_province_id;
	}
	public void setOpen_province_id(Integer open_province_id) {
		this.open_province_id = open_province_id;
	}
	public String getOpen_province_name() {
		return open_province_name;
	}
	public void setOpen_province_name(String open_province_name) {
		this.open_province_name = open_province_name;
	}
	public Integer getItem_count() {
		return item_count;
	}
	public void setItem_count(Integer item_count) {
		this.item_count = item_count;
	}
	public String[] getProvince() {
		return province;
	}
	public void setProvince(String[] province) {
		this.province = province;
	}
	public String getOpenProvinceStr() {
		return openProvinceStr;
	}
	public void setOpenProvinceStr(String openProvinceStr) {
		this.openProvinceStr = openProvinceStr;
	}
	
	
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	
	public Integer getFees() {
		return fees;
	}
	public void setFees(Integer fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "CpMakefeeItem [cp_item_id=" + cp_item_id + ", cp_item_code="
				+ cp_item_code + ", cp_item_name=" + cp_item_name
				+ ", feecode_fee=" + feecode_fee + ", feecode_op=" + feecode_op
				+ ", item_status=" + item_status + ", item_stat=" + item_stat
				+ ", citys=" + Arrays.toString(citys) + ", hide_city="
				+ hide_city + ", is_second=" + is_second + ", second_port="
				+ second_port + ", second_info=" + second_info
				+ ", second_type=" + second_type + ", replay_start_str="
				+ replay_start_str + ", replay_end_str=" + replay_end_str
				+ ", replay_str=" + replay_str + ", is_filter=" + is_filter
				+ ", filter_port=" + filter_port + ", filter_info="
				+ filter_info + ", network_role=" + network_role
				+ ", sms_delay_time=" + sms_delay_time + ", use_priority="
				+ use_priority + ", open_province_id=" + open_province_id
				+ ", open_province_name=" + open_province_name
				+ ", item_count=" + item_count + ", province="
				+ Arrays.toString(province) + ", openProvinceStr="
				+ openProvinceStr + ", getCommand_fee()=" + getCommand_fee()
				+ ", getSp_id()=" + getSp_id() + ", getSp_name()="
				+ getSp_name() + ", getFeecode_name()=" + getFeecode_name()
				+ ", getFeecode_code()=" + getFeecode_code()
				+ ", getFeecode_number()=" + getFeecode_number()
				+ ", getCommand_id()=" + getCommand_id() + ", getFeecode_id()="
				+ getFeecode_id() + ", getCommand()=" + getCommand()
				+ ", getCommand_length()=" + getCommand_length()
				+ ", getCommand_type()=" + getCommand_type()
				+ ", getSynchronous_command()=" + getSynchronous_command()
				+ ", getSynchronous_port()=" + getSynchronous_port()
				+ ", getCommand_status()=" + getCommand_status() + "]";
	}

	
}
