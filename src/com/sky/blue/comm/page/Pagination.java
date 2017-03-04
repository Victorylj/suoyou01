package com.sky.blue.comm.page;



import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;



/**
 * ***********************************
 * 
 * @author sandy
 * @project operating_cyb
 * @date 2013-9-13 上午10:16:16 
 * ***********************************
 */
public class Pagination<T> extends TagSupport {
	private static final long serialVersionUID = 1L;

	private PageResult<T> pageResult;//分页对象

	public int doStartTag() throws JspException {
		if (ObjectUtils.isEmpty(pageResult) || pageResult.getTotalCount() < 1) {
			printPage("");
			return SKIP_BODY;
		}
		int pageId = pageResult.getPageId();
		// 拼写要输出到页面的HTML文本
		StringBuilder sb = new StringBuilder("<div class='page right' item='pagination' ");
		sb.append(" size='");
		sb.append(pageResult.getPageSize());
		sb.append("'>");

		sb.append("<span>共<label>");
		sb.append(pageResult.getTotalCount());
		sb.append("</label>条&nbsp;</span>");
		if (pageResult.getPrev() > 0) {
			sb.append("<a flag='page' href='javascript:;' pageId='");
			sb.append(1);
			sb.append("'>首页</a>");
			sb.append("<a flag='page' href='javascript:;' pageId='");
			sb.append(pageResult.getPrev());
			sb.append("'>上一页</a>");
		}
		int range_s = pageId - 5;
		int range_e = pageId + 4;
		if (range_s < 1) {
			range_e = range_e - range_s;
			range_s = 1;
		}
		if (range_e > pageResult.getMaxPageId()) {
			range_e = pageResult.getMaxPageId();
		}
		for (int i = range_s; i <= range_e; i++) {//后置
			if (i == pageId) {
				sb.append("<a flag='page' href='javascript:;' class='current'>");
			} else {
				sb.append("<a flag='page' href='javascript:;'>");
			}
			sb.append(i);
			sb.append("</a>");
		}

		if (pageResult.getNext() <= pageResult.getMaxPageId()) {
			sb.append("<a flag='page' href='javascript:;' pageId='");
			sb.append(pageResult.getNext());
			sb.append("'>下一页</a>");
			sb.append("<a flag='page' href='javascript:;' pageId='");
			sb.append(pageResult.getMaxPageId());
			sb.append("'>尾页</a>");
		}
		sb.append("<span>&nbsp;共<label item='maxPageId'>");
		sb.append(pageResult.getMaxPageId());
		sb.append("页</label></span>");
		sb.append("<span class='page_info'>到第<input class='c_input_text' type='text' id='pageId' name='pageId'>页 <input class='btn_submit' name='' type='button' act='gotoPage' value='确 定'></span>");
		sb.append("</div>");
		// 把生成的HTML输出到响应中
		printPage(sb.toString());
		return SKIP_BODY; // 本标签主体为空,所以直接跳过主体
	}

	private void printPage(String sb) throws JspException {
		try {
			pageContext.getOut().println(sb);
		} catch (IOException e) {
			throw new JspException(e);
		}
	}
	public PageResult<T> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult<T> pageResult) {
		this.pageResult = pageResult;
	}
}