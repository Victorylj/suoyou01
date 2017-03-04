package com.sky.blue.business.cpmanager.entity;


public class SearchBean{
	private Integer id;
	private String name;
	private Integer pid;
	private String code;
	private String num;
	private String searchText = "";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Override
	public String toString() {
		//return "<div id='"+id+"' class='span' style='padding:5px;'  >"+name+"</div>";
		return "<div id='"+id+"' title='"+ code +"' yys='"+num+"' class='span' style='padding:5px;'  >"+name+"</div>";
		//return "<option value='"+id+"'>"+name+"</option>";
		//onmousemove='mydivmousemove(this)' onmouseout='mydivmouseout(this)' onclick='mydivclick(this)'
	}
	
	public String toStringCode() {
		return "<div id='"+num+"' title='"+ code +"' yys='"+id+"' class='span' style='padding:5px;'  >"+name+"</div>";
	}
}
