package com.sky.blue.business.cpcontrol.entity;

/**
 * Created by xiaoji on 2015/1/26.
 */
public class TaskType {
    public int id;
    public int cp_id;
    public int product_id;
    public String tag;
    public String cp_name;
    public String product_code;
    public String product_name;
    public int isPop;
    public int isLoading;
    public int isTht;
    /*private int parentId;
    private String state = "closed";*/
    public TaskType(){

    }


    public int getCp_id() {
		return cp_id;
	}


	public void setCp_id(int cp_id) {
		this.cp_id = cp_id;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


	public String getCp_name() {
		return cp_name;
	}


	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}


	public String getProduct_code() {
		return product_code;
	}


	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public int getIsPop() {
		return isPop;
	}


	public void setIsPop(int isPop) {
		this.isPop = isPop;
	}


	public int getIsLoading() {
		return isLoading;
	}


	public void setIsLoading(int isLoading) {
		this.isLoading = isLoading;
	}


	public int getIsTht() {
		return isTht;
	}


	public void setIsTht(int isTht) {
		this.isTht = isTht;
	}


	/*public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}*/

   
}
