package com.sky.blue.comm.page;

/**
 * 
 */

import java.io.Serializable;

/**
 * ***********************************
 * @author sandy
 * @project aider
 * @create_date 2013-8-15 上午10:37:27
 * ***********************************
 */
@SuppressWarnings("serial")
public class Limit implements Serializable{
	
	private int size;
	private int pageId;
	private int offset;
	
	private Limit(int pageId, int size) {
		this.pageId = pageId;
		this.size = size;
	}
	
	private Limit() {
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the pageId
	 */
	public int getPageId() {
		return pageId;
	}

	/**
	 * @param pageId the pageId to set
	 */
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	
	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * 用于 页面&DB分页
	 * @param pageId
	 * @param pageSize
	 * @return
	 */
	public static Limit buildLimit(int pageId, int pageSize) {
		if (pageId <= 0)
			pageId = 1;
		if (pageSize <= 0)
			pageSize = 12;// 默认12
		Limit limit = new Limit();
		limit.pageId = pageId;
		limit.size = pageSize;

		int offset = (pageId - 1) * pageSize;
		limit.offset = offset;
		return limit;
	}
}