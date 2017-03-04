package com.sky.blue.business.cpcontrol.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sky.blue.business.cpcontrol.service.PlatSetService;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.stat.entity.Caitsat;
import com.sky.blue.comm.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: acgplat Module ID: 011 Comments: 渠道设置管理 JDK version used: JDK1.7
 * Namespace: controller Author：xiaobo Create Date：2016年9月14日 15:03:29 Modified
 * By： wp Modified Date: <修改日期，格式:YYYY-MM-DD> Why & What is modified
 * <修改原因描述> Version: <版本号>
 */
@Controller
public class PlatController extends BaseController {
	@Autowired
	private PlatSetService platSetService;

	/**
	 * 渠道控制list页面
	 * 
	 * @param request
	 * @param page
	 *            当前页
	 * @param rows
	 *            页大小
	 * @return
	 */
	@RequestMapping("/getTreeGridjson")
	public String listBlackChenelInfo(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageId, ModelMap map) throws Exception {
		request.setCharacterEncoding("utf-8");
		String cp_id = request.getParameter("cp_id");
		String product_id = request.getParameter("product_id");
		String cp_name = request.getParameter("cp_name");
		String product_name = request.getParameter("product_name");
		map.put("cp_id", cp_id);
		map.put("cp_name", cp_name);
		map.put("product_id", product_id);
		map.put("product_name", product_name);

		PageHelper.startPage(pageId, 10);
		List<Map<String, Object>> ls = platSetService.getTaskTypeInfo(map);

		PageInfo page = null;
		if (ls.size() != 0 && ls != null) {
			page = new PageInfo(ls);
		}
		request.setAttribute("page", page);
		request.setAttribute("pageId", pageId);
		request.setAttribute("searchObj", map);
		return "cpcontrol/cplistGrid";
	}

	/**
	 * 渠道控制list页面 13
	 * 
	 * @param request
	 * @param page
	 *            当前页
	 * @param rows
	 *            页大小
	 * @return
	 */
	@RequestMapping("/getThtlist")
	public String getThtlist(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageId, ModelMap map) throws Exception {
		String cp_id = request.getParameter("cp_id");
		String product_id = request.getParameter("product_id");
		String cp_name = request.getParameter("cp_name");
		String product_name = request.getParameter("product_name");
		String product_codev = request.getParameter("product_codev");
		String product_code = request.getParameter("product_code");
		String tag = request.getParameter("tag");
		String ccp_id = request.getParameter("ccp_id");
		if (tag == null) {
			tag = "2";
		}
		map.put("cp_id", cp_id);
		map.put("cp_name", cp_name);
		map.put("product_id", product_id);
		map.put("product_name", product_name);
		map.put("product_codev", product_codev);
		map.put("product_code", product_code);
		map.put("ccp_id", ccp_id);
		map.put("tag", tag);
		System.out.println("================================>" + tag);
		PageHelper.startPage(pageId, 10);
		List<Map<String, Object>> ls = platSetService.getThtlist(map);

		PageInfo page = null;
		if (ls.size() != 0 && ls != null) {
			page = new PageInfo(ls);
		}
		request.setAttribute("page", page);
		request.setAttribute("pageId", pageId);
		request.setAttribute("searchObj", map);
		return "cpcontrol/listThtinfo";
	}

	/**
	 * @Title: saveInsubsat @Description: 保存或修改渠道控制参数 @param @param
	 * request @param @param pageId @param @param
	 * modelMap @param @return @param @throws Exception 设定文件 @return String
	 * 返回类型 @throws
	 */
	@RequestMapping("/saveInsubsat")
	public String saveInsubsat(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {
		String[] isPop = request.getParameterValues("isPopinput");
		String[] isLoading = request.getParameterValues("isLoadinginput");
		// String[] isTht = request.getParameterValues("isThtinput");
		String[] id = request.getParameterValues("id");
		for (int i = 0; i < id.length; i++) {
			modelMap.put("id", id[i]);
			modelMap.put("isPop", isPop[i]);
			modelMap.put("isLoading", isLoading[i]);
			// modelMap.put("isTht",isTht[i]);
			platSetService.saveOrupdateSubstate(modelMap);
		}
		return "redirect:/getTreeGridjson.do?pageId=" + pageId;
	}

	/*
	 * 根据tag批量修改13
	 */
	@RequestMapping("/conThtpl")
	public String conThtpl(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {
		String[] isTht = request.getParameterValues("sub_id");
		int tag = Integer.parseInt(request.getParameter("tag"));
		tag = tag == 1 ? 0 : 1;
		modelMap.put("ids", isTht);
		modelMap.put("tag", tag);
		platSetService.updateSubtht(modelMap);
		return "redirect:/getThtlist.do?pageId=" + pageId + "&tag=2";
	}

	/*
	 * 根据tag批量修改13
	 */
	@RequestMapping("/changgeTht")
	public String changgeTht(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {
		String isTht = request.getParameter("sub_id");
		int tag = Integer.parseInt(request.getParameter("tag"));
		modelMap.put("id", isTht);
		modelMap.put("tag", tag);
		platSetService.changgeTht(modelMap);
		return "redirect:/getThtlist.do?pageId=" + pageId + "&tag=2";
	}

	/*
	 * ajax获取json
	 */
	@RequestMapping("/getnTable")
	public void getnTable(HttpServletRequest request, String id, HttpServletResponse response) throws IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, Object> map = new HashMap<String, Object>();
		String ccpid = null;
		if (id == null) {
			id = "-1";
		}
		if (id != null && id.contains("_")) {
			ccpid = id;
			id = null;
		}
		map.put("ccp_id", ccpid);
		map.put("id", id);
		List<Map<String, Object>> list = platSetService.getTaskTypeInfo2(map);
		if (list.size() == 0) {
			response.getWriter().write("false");
		} else {
			Gson gson = new Gson();
			response.getWriter().write(gson.toJson(list));
		}
	}

	/**
	 * Sjm 模糊搜索公司
	 * 
	 * @param request
	 * @param response
	 * @param searchText
	 */
	@RequestMapping("/seachCaipCompanyListfor")
	public void seachCpCompanyList(HttpServletRequest request, Caitsat obj, ModelMap modelMap, HttpServletResponse response, String searchText) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		@SuppressWarnings("unchecked")
		List<SearchBean> l = (List<SearchBean>) request.getSession().getAttribute("scpList");
		CpCompany sc = new CpCompany();
		String searStr = "%" + searchText + "%";
		modelMap.put("searchText", searStr);
		try {
			if (l == null) {
				l = platSetService.seachCompanyList(modelMap);
				request.getSession().setAttribute("scpList", l);
				System.out.println("-------------->:" + l.size() + ":::" + sc.getCreate_name());
			}
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		for (SearchBean bean1 : l) {

			if (bean1.getName().contains(searchText)) {
				sb.append(bean1.toString());
			}
		}
		out.print(sb.toString());
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @Title: seachCodeList @Description: 模糊搜索项目代码 @param @param
	 * request @param @param response @param @param searchText 设定文件 @return void
	 * 返回类型 @throws
	 */
	@RequestMapping("/seachCodeList")
	public void seachCprodList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, String searchText) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		List<SearchBean> l = (List<SearchBean>) request.getSession().getAttribute("scdList");

		String searStr = "%" + searchText + "%";
		modelMap.put("searchText", searStr);
		try {
			if (l == null) {
				l = platSetService.seachCprodList(modelMap);
				request.getSession().setAttribute("scdList", l);
			}
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getName().contains(searchText)) {
				sb.append(l.get(i).toString());
			}
		}
		out.print(sb.toString());
		out.flush();
		out.close();
	}

}
