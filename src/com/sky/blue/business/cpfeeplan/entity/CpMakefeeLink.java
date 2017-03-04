package com.sky.blue.business.cpfeeplan.entity;

import com.sky.blue.business.beans.BaseEntity;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;

public class CpMakefeeLink extends BaseEntity {
	private Integer link_id;
	private String feemeasure_name;
	private Integer feemeasure_id;
	private Integer feemeasure_item_id;

	private Integer feecode_id;
	private Integer command_id;
	private String create_name;
	public Integer getFeecode_id() {
		return feecode_id;
	}
	public void setFeecode_id(Integer feecode_id) {
		this.feecode_id = feecode_id;
	}
	public Integer getCommand_id() {
		return command_id;
	}
	public void setCommand_id(Integer command_id) {
		this.command_id = command_id;
	}
	private Integer cp_item_id;
	private String cp_item_name;
	private Integer province;
	private String province_name;
	private CpMakefeeItem[] makeFeeItem;
	
	public Integer getFeemeasure_item_id() {
		return feemeasure_item_id;
	}
	public void setFeemeasure_item_id(Integer feemeasure_item_id) {
		this.feemeasure_item_id = feemeasure_item_id;
	}
	public String getFeemeasure_name() {
		return feemeasure_name;
	}
	public void setFeemeasure_name(String feemeasure_name) {
		this.feemeasure_name = feemeasure_name;
	}
	public String getCp_item_name() {
		return cp_item_name;
	}
	public void setCp_item_name(String cp_item_name) {
		this.cp_item_name = cp_item_name;
	}

	
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public CpMakefeeItem[] getMakeFeeItem() {
		return makeFeeItem;
	}
	public void setMakeFeeItem(CpMakefeeItem[] makeFeeItem) {
		this.makeFeeItem = makeFeeItem;
	}
	private Integer cp_item_count;
	public Integer getLink_id() {
		return link_id;
	}
	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}
	public Integer getFeemeasure_id() {
		return feemeasure_id;
	}
	public void setFeemeasure_id(Integer feemeasure_id) {
		this.feemeasure_id = feemeasure_id;
	}
	public Integer getCp_item_id() {
		return cp_item_id;
	}
	public void setCp_item_id(Integer cp_item_id) {
		this.cp_item_id = cp_item_id;
	}
	public Integer getCp_item_count() {
		return cp_item_count;
	}
	public void setCp_item_count(Integer cp_item_count) {
		this.cp_item_count = cp_item_count;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	
	
	
}
