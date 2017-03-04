package com.sky.blue.comm.page;

/**
 * 
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * ***********************************
 * @author sandy
 * @project biz-cyb-common
 * @create_date 2013年8月26日 上午11:20:44
 * ***********************************
 */
public class PageResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int pageId;// 当前list页pageId
	private int maxPageId;// list的最大pageId
	private int pageSize;// 每个页面显示多少条内容
	private long totalCount;// 一共多少条内容
	private List<T> list = new ArrayList<T>();// list页要显示的内容

	public static final PageResult<Object> EMPTH_PAGE_RESULT = new PageResult<Object>();// 空对象

	private PageResult() {

	}

	public PageResult(Limit limit, long totalCount, List<T> list) {
		this(limit.getPageId(), limit.getSize(), totalCount, list);
	}

	public PageResult(int pageId, int pageSize, long totalCount, List<T> list) {
		if (pageId <= 0)
			pageId = 1;
		if (pageSize <= 0)
			pageSize = 12;// 默认pageSize为12
		int tmpMaxPageId = (int) (totalCount / pageSize);
		if (totalCount == 0) {// 当totalCount=0时，maxPageId=1
			this.maxPageId = 1;
		} else if (totalCount % pageSize == 0) {
			this.maxPageId = tmpMaxPageId;
		} else {
			this.maxPageId = tmpMaxPageId + 1;
		}
		this.pageId = pageId;
		// 如果输入pageId>maxPageId，则pageId取maxPageId
		if (pageId > maxPageId)
			this.pageId = maxPageId;
		if (maxPageId <= 0)
			maxPageId = 1;

		this.pageSize = pageSize;
		this.list = list;
		this.totalCount = totalCount;
	}

	public int getNext() {
		// return pageId+1>maxPageId?pageId:pageId+1;
		return pageId + 1;
	}

	public int getPrev() {
		// return pageId-1<1?pageId:pageId-1;
		return pageId - 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getMaxPageId() {
		return maxPageId;
	}

	public void setMaxPageId(int maxPageId) {
		this.maxPageId = maxPageId;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
