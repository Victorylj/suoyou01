package com.sky.blue.business.logon.entity;

import com.sky.blue.business.beans.BaseEntity;

public class Module extends BaseEntity {
	private Integer module_id;
	private String module_name;
	private String module_path;
	private String module_url;
	private String parent_name;
	private Integer parent_id;
	private Integer is_leaf;
	private Integer display_order;
	private Integer p_id;
	
	
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public Integer getModule_id() {
		return module_id;
	}
	public void setModule_id(Integer module_id) {
		this.module_id = module_id;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	public String getModule_path() {
		return module_path;
	}
	public void setModule_path(String module_path) {
		this.module_path = module_path;
	}
	public String getModule_url() {
		return module_url;
	}
	public void setModule_url(String module_url) {
		this.module_url = module_url;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getIs_leaf() {
		return is_leaf;
	}
	public void setIs_leaf(Integer is_leaf) {
		this.is_leaf = is_leaf;
	}
	public Integer getDisplay_order() {
		return display_order;
	}
	public void setDisplay_order(Integer display_order) {
		this.display_order = display_order;
	}
	@Override
	public String toString() {
		return "Module [module_id=" + module_id + ", module_name="
				+ module_name + ", module_path=" + module_path
				+ ", module_url=" + module_url + ", parent_name=" + parent_name
				+ ", parent_id=" + parent_id + ", is_leaf=" + is_leaf
				+ ", display_order=" + display_order + "]";
	}
	
	
	
	
}
