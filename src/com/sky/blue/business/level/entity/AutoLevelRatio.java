package com.sky.blue.business.level.entity;

import com.sky.blue.business.beans.BaseEntity;

public class AutoLevelRatio extends BaseEntity{
	private Integer id;
	private Integer level;
	private Integer ratio;
	private String create_time;
	private String create_name;
	public AutoLevelRatio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AutoLevelRatio(Integer id, Integer level, Integer ratio,
			String create_time, String create_name) {
		super();
		this.id = id;
		this.level = level;
		this.ratio = ratio;
		this.create_time = create_time;
		this.create_name = create_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getRatio() {
		return ratio;
	}
	public void setRatio(Integer ratio) {
		this.ratio = ratio;
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
