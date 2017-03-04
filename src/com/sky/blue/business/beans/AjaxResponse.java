/**
 * 
 */
package com.sky.blue.business.beans;

/**ajax 返回信息的实体类
 * ***********************************
 * @author sandy
 * @project operating_cyb
 * @create_date 2013年8月22日 下午3:03:46
 * ***********************************
 */
public class AjaxResponse<T> {
	private String msg;//返回到页面的信息	
	private Integer errorCode;//状态码
	private T result;//可以放入的实体类/list/map 等
	
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the code
	 */
	public Integer getErrorCode() {
		return errorCode;
	}
	/**
	 * @param code the code to set
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the t
	 */
	public T getResult() {
		return result;
	}
	/**
	 * @param t the t to set
	 */
	public void setResult(T result) {
		this.result = result;
	}
	
}
