package com.sky.blue.business.cpfeeplan.entity;

public class CpFeemeasureItem extends CpFeemeasure {
	private Integer feemeasure_item_id;

	private Integer cp_item_id;
	private Integer item_status;
	
	private String ref_items;
	public Integer getFeemeasure_item_id() {
		return feemeasure_item_id;
	}

	public void setFeemeasure_item_id(Integer feemeasure_item_id) {
		this.feemeasure_item_id = feemeasure_item_id;
	}

	
	public String getRef_items() {
		return ref_items;
	}

	public void setRef_items(String ref_items) {
		this.ref_items = ref_items;
	}

	public Integer getCp_item_id() {
		return cp_item_id;
	}

	public void setCp_item_id(Integer cp_item_id) {
		this.cp_item_id = cp_item_id;
	}

	public Integer getItem_status() {
		return item_status;
	}

	public void setItem_status(Integer item_status) {
		this.item_status = item_status;
	}

	@Override
	public String toString() {
		return "CpFeemeasureItem [feemeasure_item_id=" + feemeasure_item_id
				+ ", getFeeplan_name()=" + getFeeplan_name()
				+ ", getFeemeasure_province_name()="
				+ getFeemeasure_province_name()
				+ ", getFeemeasure_city_name()=" + getFeemeasure_city_name()
				+ ", getFeemeasure_id()=" + getFeemeasure_id()
				+ ", getFeeplan_id()=" + getFeeplan_id()
				+ ", getFeemeasure_name()=" + getFeemeasure_name()
				+ ", getFeemeasure_op()=" + getFeemeasure_op()
				+ ", getFeemeasure_is_pop()=" + getFeemeasure_is_pop()
				+ ", getFeemeasure_fee()=" + getFeemeasure_fee()
				+ ", getFeemeasure_province()=" + getFeemeasure_province()
				+ ", getFeemeasure_city()=" + getFeemeasure_city()
				+ ", getArrayIds()=" + getArrayIds() + ", getRemarks()="
				+ getRemarks() + ", getCreate_time()=" + getCreate_time()
				+ ", getUpdate_time()=" + getUpdate_time()
				+ ", getCreate_name()=" + getCreate_name()
				+ ", getUpdate_name()=" + getUpdate_name() + "]";
	}
	
}
