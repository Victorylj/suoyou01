package com.sky.blue.comm;

/**
 * 
 */

/**
 * ***********************************
 * @author sandy
 * @project operating_cyb
 * @create_date 2013年8月22日 下午3:16:44
 * ***********************************
 */
public enum AjaxResponseStatus {
	SUCCESS(0), FAIL(-1), NETERROR(1);
	
	
	private Integer status;

	private AjaxResponseStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

}
