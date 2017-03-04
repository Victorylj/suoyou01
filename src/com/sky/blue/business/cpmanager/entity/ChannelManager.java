package com.sky.blue.business.cpmanager.entity;

import com.sky.blue.business.beans.BaseEntity;

public class ChannelManager extends BaseEntity {
	private Integer m_id;
	private String m_name;
	private Integer show_type;
	
	
	public Integer getShow_type() {
		return show_type;
	}
	public void setShow_type(Integer show_type) {
		this.show_type = show_type;
	}
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	
}
