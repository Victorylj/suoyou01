package com.sky.blue.business.stat;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.cpmanager.entity.Channel;
import com.sky.blue.business.cpmanager.entity.ChannelManager;
import com.sky.blue.business.cpmanager.entity.CpMember;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.cpmanager.service.IChannelManagerService;
import com.sky.blue.business.cpmanager.service.IChannelService;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
import com.sky.blue.business.data.entity.DataDictionary;
import com.sky.blue.business.data.service.IDataDictionaryService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.service.ICpMakefeeItemService;
import com.sky.blue.business.stat.RecCallAllDateController.Sort;
import com.sky.blue.business.stat.entity.CallStat;
import com.sky.blue.business.stat.entity.RecCallAllDate;
import com.sky.blue.business.stat.entity.SmsFilterStat;
import com.sky.blue.business.stat.service.ICallStatService;
import com.sky.blue.business.stat.service.IFeecodeStatService;
import com.sky.blue.comm.BaseController;

@Controller
public class CallStatController extends BaseController {
	@Resource(name = "dataDictionaryServiceImpl")
	private IDataDictionaryService dataDictionaryService;
	@Resource(name = "feecodeStatServiceImpl")
	private IFeecodeStatService feecodeStatService;

	@Resource(name = "callStatServiceImpl")
	private ICallStatService callStatService;

	// @Resource(name="provinceServiceImpl")
	// private IProvinceService provinceService;
	@Resource(name = "cpCompanyServiceImpl")
	private ICpCompanyService cpCompanyService;
	@Resource(name = "channelServiceImpl")
	private IChannelService channelService;
	@Resource(name = "channelManagerServiceImpl")
	private IChannelManagerService channelManagerService;
	@Resource(name = "cpMakefeeItemServiceImpl")
	private ICpMakefeeItemService cpMakefeeItemService;

	@RequestMapping("/listCallStat")
	public String listCallStat(HttpServletRequest request, CallStat callStat, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {
		if (callStat == null) {
			return "err";
		}
		// GatewayInfo gatewayInfo = new GatewayInfo();
		System.out.println("=============" + callStat.toString());
		User user = getSessionUser(request);
		// if(user.getGroup_id()==4)
		Channel curCp = null;

		if (user != null) {
			if (!"".equals(user.getAccount())) {
				if (user.getGroup_id() == 4) {
					String mId = user.getAccount().substring(5);
					callStat.setM_id(Integer.parseInt(mId));
					ChannelManager cm = new ChannelManager();
					cm.setM_id(Integer.parseInt(mId));
					List<ChannelManager> cmList = channelManagerService.qryChannelManagerList(cm);
					if (cmList != null) {
						if (cmList.size() > 0) {
							ChannelManager cm1 = cmList.get(0);
							curCp = new Channel();
							curCp.setShow_type(cm1.getShow_type());
						}
					}
				} else {
					callStat.setCp_id(Integer.parseInt(user.getAccount()));
				}
				Channel ch = new Channel();
				ch.setCh_id(Integer.parseInt(user.getAccount()));
				List<Channel> chList = channelService.qryChannelList(ch);
				if (chList != null) {
					if (chList.size() > 0) {
						curCp = chList.get(0);
					}
				}
			}
		}

		if (curCp == null && user.getGroup_id() != 4) {
			return "stat/listCallStat";
		}
		try {
			PageHelper.startPage(pageId, 35);
			List<CallStat> list = callStatService.qryCallStatList(callStat);
			PageInfo page = new PageInfo(list);

			int allCalls = 0;
			int allDataInit = 0;
			int allDataRet = 0;
			int allDataDiv = 0;
			int allDataFee = 0;
			for (CallStat cs : list) {
				/*
				 * int calls = cs.getCalls(); calls =
				 * calls*curCp.getCp_cut()/100; cs.setCalls(calls);
				 * allCalls=allCalls+calls;
				 */
				if (cs.getData_init() == null) {
					cs.setData_init(0);
				}
				if (cs.getData_fee() == null) {
					cs.setData_fee(0);
				}
				if (cs.getData_ret() == null) {
					cs.setData_ret(0);
				}
				if (cs.getData_div() == null) {
					cs.setData_div(0);
				}
				allDataInit = allDataInit + cs.getData_init();
				allDataRet = allDataRet + cs.getData_ret();
				allDataDiv = allDataDiv + cs.getData_div();
				allDataFee = allDataFee + cs.getData_fee();
			}
//			System.out.println(page.getTotal() + "===========" + page.getPageNum() + "======" + page.getPageSize());
			modelMap.addAttribute("page", page);
			modelMap.addAttribute("allDataInit", allDataInit);
			modelMap.addAttribute("allDataRet", allDataRet);
			modelMap.addAttribute("allDataDiv", allDataDiv);
			modelMap.addAttribute("allDataFee", allDataFee);
			modelMap.addAttribute("searchObj", callStat);
			modelMap.addAttribute("curCH", curCp);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
		return "stat/listCallStat";
	}

	private List<CallStat> qryAllCallStatList(CallStat callStat) throws Exception {

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sf.parse(callStat.getStart_time());
//		date.setDate(date.getDate() + 1);
		date.setTime(date.getTime() + 1000 * 60 * 60 * 24);
		callStat.setEnd_time(sf.format(date));

		List<CallStat> lsr = callStatService.getSdkRLByd(callStat);
		List<CallStat> lsi = callStatService.getSdkILByd(callStat);

		String key = "";
		HashMap<String, CallStat> sr = new HashMap<String, CallStat>();
		HashMap<String, Integer> si = new HashMap<String, Integer>();
		int i = 0;
		int lsrlh = lsr.size();
		int lsilh = lsi.size();
		int length = lsrlh > lsilh ? lsrlh : lsilh;
		CallStat cs = null;

		List<CallStat> l = callStatService.getCpchsta(callStat);
		HashMap<String, String> hm = new HashMap<String, String>();
		for (CallStat c : l) {
			key = c.getCp_id() + c.getCcp_id();
			hm.put(key, c.getTag());
		}
		String sta = null;

		List<CallStat> lsr1 = new ArrayList<CallStat>();

		List<CallStat> lsi1 = new ArrayList<CallStat>();
		for (i = 0; i < length; i++) {
			if (i < lsrlh) {
				cs = lsr.get(i);
				key = cs.getCp_id() + cs.getCcp_id() + cs.getPackager();
				sta = hm.get(cs.getCp_id() + cs.getCcp_id());
				if ("1".equals(callStat.getTag())) {
					if ("2".equals(sta)) {
						// lsr.remove(cs);
					} else {
						lsr1.add(cs);
						sr.put(key, cs);
					}
				} else {
					if (!"2".equals(sta)) {
						// lsr.remove(cs);
					} else {
						lsr1.add(cs);
						sr.put(key, cs);
					}
				}
			}
			if (i < lsilh) {
				// System.out.println(i+"==="+lsilh+"====="+length+"====="+lsrlh);
				cs = lsi.get(i);
				key = cs.getCp_id() + cs.getCcp_id() + cs.getPackager();
				sta = hm.get(cs.getCp_id() + cs.getCcp_id());
				if ("1".equals(callStat.getTag())) {
					if ("2".equals(sta)) {
						// lsi.remove(cs);
					} else {
						lsi1.add(cs);
						si.put(key, cs.getInitnum());
					}
				} else {
					if (!"2".equals(sta)) {
						// lsi.remove(cs);
					} else {
						lsi1.add(cs);
						si.put(key, cs.getInitnum());
					}
				}
			}
		}

		l = callStatService.getAllCompany(callStat);
		HashMap<String, String> hm1 = new HashMap<String, String>();
		for (CallStat c : l) {
			hm1.put("K" + c.getCp_id(), c.getCp_name());
		}
		l = callStatService.getAllProduct(callStat);
		for (CallStat c : l) {
			hm1.put(c.getPackager(), c.getProduct_name());
		}

		Integer in = null;
		lsrlh = lsr1.size();
		lsilh = lsi1.size();
		for (i = 0; i < lsrlh; i++) {
			cs = lsr1.get(i);
			if (cs.getPackager() == null || hm1.get(cs.getPackager()) == null || hm1.get("K" + cs.getCp_id()) == null) {
				lsr1.remove(cs);
				lsrlh--;
				i--;
				continue;
			}
			key = cs.getCp_id() + cs.getCcp_id() + cs.getPackager();
			in = si.get(key);
			cs.setCp_name(hm1.get("K" + cs.getCp_id()));
			cs.setProduct_name(hm1.get(cs.getPackager()));
			if (in != null) {
				cs.setInitnum(in);
			}
		}
		for (i = 0; i < lsilh; i++) {
			cs = lsi1.get(i);
			if (cs.getPackager() == null) {
				continue;
			}
			key = cs.getCp_id() + cs.getCcp_id() + cs.getPackager();
			if (sr.get(key) == null) {
				if (hm1.get(cs.getPackager()) == null || hm1.get("K" + cs.getCp_id()) == null) {
					continue;
				}
				cs.setCp_name(hm1.get("K" + cs.getCp_id()));
				cs.setProduct_name(hm1.get(cs.getPackager()));
				lsr1.add(cs);
			}
		}
		callStat.setEnd_time(callStat.getStart_time());
		return lsr1;
	}

	@RequestMapping("/listAllCallStat")
	public String listAllCallStat(HttpServletRequest request, CallStat callStat, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {
		if (callStat == null) {
			return "err";
		}

		String protag = callStat.getProtype();
		String searchCcpid = callStat.getCcp_id();
		Integer cpid = callStat.getCp_id();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String dater = sf.format(new Date());
		if (callStat.getStart_time() == null || callStat.getEnd_time() == null) {
			callStat.setDater(dater);
			callStat.setStart_time(dater);
			callStat.setEnd_time(dater);
		} else {
			callStat.setDater(callStat.getStart_time());
		}
		// List<Channel> chList = channelService.qryChannelList(new Channel());
		List<CpMember> cpmList = cpCompanyService.qryCpMemberList(new CpMember());
		HashMap<String, String> cpmTemp = new HashMap<String, String>();
		for (CpMember cpm : cpmList) {
			// System.out.println(String.valueOf(cpm.getCpm_id())+"========="+cpm.getCpm_name());
			cpmTemp.put(String.valueOf(cpm.getCpm_id()), cpm.getCpm_name());
		}

		try {
			if (callStat.getTag() == null || "".equals(callStat.getTag())) {
				callStat.setTag("1");
			}
			// PageHelper.startPage(pageId, 10000, false);
			List<CallStat> list = null;
			if (dater.equals(callStat.getStart_time())) {
				list = qryAllCallStatList(callStat);
			} else {
				list = callStatService.qryAllCallStatList(callStat);
			}

			List<CallStat> nofeeinitlist = callStatService.qryInitNoFeeStatList(callStat);

			SmsFilterStat smsFilter = new SmsFilterStat();
			smsFilter.setStart_time(callStat.getStart_time());
			smsFilter.setEnd_time(callStat.getEnd_time());

			List<SmsFilterStat> listSms = feecodeStatService.qrySmsFilterCpStatList(smsFilter);
			List<SmsFilterStat> listSmsReport = feecodeStatService.qrySmsReportStatList(smsFilter);
			List<DataDictionary> listd = dataDictionaryService.qryDataDictionaryLists(new DataDictionary());
			DataDictionary ddd = listd.get(0);
			String cpids = ",";
			for (DataDictionary d : listd) {
				cpids = cpids + d.getCpids() + ",";
			}
			System.err.println(cpids);
			ddd.setCpids(cpids);

			int allSuccCalls = 0;
			int allSuccUsers = 0;
			// int allFailCalls=0;
			// int allFailUsers=0;
			int allCalls = 0;
			int allUsers = 0;
			int allInitnum = 0;
			int allSmsNum = 0;
			int allSmsReportNum = 0;
			int allNofeeInitnum = 0;
			HashMap<String, Integer> ssf = new HashMap<String, Integer>();
			for (SmsFilterStat smsF : listSms) {
				ssf.put(smsF.getDater() + smsF.getCp_id(), smsF.getFilterUsers());
			}

			HashMap<String, Integer> ssr = new HashMap<String, Integer>();
			for (SmsFilterStat smsR : listSmsReport) {
				if (smsR.getCp_id() != null) {
					ssr.put(smsR.getDater() + smsR.getCp_id(), smsR.getFilterUsers());
				}
			}

			HashMap<String, Integer> nofeeTemp = new HashMap<String, Integer>();
			for (CallStat nofeeinit : nofeeinitlist) {
				if (nofeeinit != null) {
					nofeeTemp.put(nofeeinit.getDater() + nofeeinit.getCcp_id(), nofeeinit.getInitnum());
				}
			}
			List<CallStat> retlist = new ArrayList<CallStat>();
			for (CallStat cs : list) {

				if (cpid != null && cs.getCp_id() != null && cs.getCp_id().intValue() != cpid.intValue()) {
					continue;
				}

				if (searchCcpid != null && !"".equals(searchCcpid)) {
					if (cs.getCcp_id() != null && !cs.getCcp_id().contains(searchCcpid)) {

						continue;
					}
				}

				if ("2".equals(protag)) {
					if (cs.getCp_id() != null) {
						if (cs.getCp_id() < 10000) {
							continue;
						}
					}
				}

				if ("3".equals(protag)) {
					if (cs.getCp_id() != null) {
						if (cs.getCp_id() >= 10000) {
							continue;
						}
					}
				}

				if (cs.getInitnum() == null) {
					cs.setInitnum(0);
				}
				/*
				 * for(SmsFilterStat smsF: listSms){
				 * if(cs.getDater().equals(smsF.getDater())&&(smsF.getCp_id().
				 * equals(String.valueOf(cs.getCp_id()))||smsF.getCp_id().equals
				 * (cs.getCcp_id()))){ cs.setSmsNum(smsF.getFilterUsers()); } }
				 * for(SmsFilterStat smsR:listSmsReport){
				 * if(smsR.getCp_id()!=null)
				 * if(cs.getDater().equals(smsR.getDater())&&(smsR.getCp_id().
				 * equals(String.valueOf(cs.getCp_id()))||smsR.getCp_id().equals
				 * (cs.getCcp_id()))){
				 * cs.setSmsReportNum(smsR.getFilterUsers()); } }
				 */
				cs.setSmsNum(ssf.get(cs.getDater() + cs.getCcp_id()));
				if (cs.getSmsNum() == null) {
					cs.setSmsNum(ssf.get(cs.getDater() + cs.getCp_id()));
				}

				cs.setSmsReportNum(ssr.get(cs.getDater() + cs.getCcp_id()));
				if (cs.getSmsReportNum() == null) {
					cs.setSmsReportNum(ssr.get(cs.getDater() + cs.getCp_id()));
				}
				cs.setNofeeinitnum(nofeeTemp.get(cs.getDater() + cs.getCcp_id()) == null ? 0 : nofeeTemp.get(cs.getDater() + cs.getCcp_id()));
				cs.setSmsNum(cs.getSmsNum() == null ? 0 : cs.getSmsNum());
				cs.setSmsReportNum(cs.getSmsReportNum() == null ? 0 : cs.getSmsReportNum());
				allSuccCalls = allSuccCalls + (cs.getSucc_calls() == null ? 0 : cs.getSucc_calls());
				allSuccUsers = allSuccUsers + (cs.getSucc_users() == null ? 0 : cs.getSucc_users());
				// allFailCalls=allFailCalls+cs.getFail_calls();
				// allFailUsers=allFailUsers+cs.getFail_users();
				allCalls = allCalls + (cs.getAll_calls() == null ? 0 : cs.getAll_calls());
				allUsers = allUsers + (cs.getAll_users() == null ? 0 : cs.getAll_users());
				allInitnum = allInitnum + (cs.getInitnum() == null ? 0 : cs.getInitnum());
				allSmsNum = allSmsNum + (cs.getSmsNum() == null ? 0 : cs.getSmsNum());
				allSmsReportNum = allSmsReportNum + (cs.getSmsReportNum() == null ? 0 : cs.getSmsReportNum());
				allNofeeInitnum = allNofeeInitnum + cs.getNofeeinitnum();
				if (cs.getSucc_users() != null) {
					cs.setRate(new DecimalFormat("#.##%").format((double) cs.getSmsReportNum() / (double) cs.getSucc_users()));
				} else {
					cs.setRate("-");
				}
				if (ddd.getCpids().contains("," + cs.getCp_id() + ",") || ddd.getCpids().contains("," + cs.getCcp_id() + ",")) {
					cs.setRemarks(".");
				}

				if (cs.getCcp_id() != null && !"".equals(cs.getCcp_id())) {
					String ccpid = cs.getCcp_id();
					if (ccpid.contains("_")) {
						String ccp = ccpid.split("_")[0];
						if (ccp.equals(String.valueOf(cs.getCp_id()))) {
							String ccpname = cpmTemp.get(ccp);
							if (ccpname != null && !"".equals(ccpname)) {
								cs.setCp_name(ccpname);
							}
						}
					}
				}
				retlist.add(cs);
			}
			PageInfo page = new PageInfo(retlist);
			page.setList(retlist);
			page.setPageNum(1);
			page.setTotal(retlist.size());
			if (cpid != null && cpid.intValue() > 0) {

			} else {
				Collections.sort(retlist, new Sort());
			}
			modelMap.addAttribute("resultList", retlist);

			modelMap.addAttribute("page", page);
			modelMap.addAttribute("allSuccCalls", allSuccCalls);
			modelMap.addAttribute("allSuccUsers", allSuccUsers);
			// modelMap.addAttribute("allFailCalls", allFailCalls);
			// modelMap.addAttribute("allFailUsers", allFailUsers);
			modelMap.addAttribute("allCalls", allCalls);
			modelMap.addAttribute("allUsers", allUsers);
			modelMap.addAttribute("allInitnum", allInitnum);
			modelMap.addAttribute("allSmsNum", allSmsNum);
			modelMap.addAttribute("allSmsReportNum", allSmsReportNum);
			modelMap.addAttribute("allNofeeInitnum", allNofeeInitnum);
			// modelMap.addAttribute("chList", chList);
			modelMap.addAttribute("searchObj", callStat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "stat/listAllCallStat";
	}

	/**
	 * Sjm 模糊搜索渠道
	 * 
	 * @param request
	 * @param response
	 * @param searchText
	 */
	@RequestMapping("/seachChannelList")
	public void seachChannelList(HttpServletRequest request, HttpServletResponse response, String searchText) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		List<SearchBean> l = (List<SearchBean>) request.getSession().getAttribute("sccList");
		Channel c = new Channel();
		c.setCh_name("%" + searchText + "%");
		try {
			if (l == null) {
				l = channelService.searchChannelList(c);
				request.getSession().setAttribute("sccList", l);
			}
			out = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		String str = "";
		for (int i = 0; i < l.size(); i++) {
			str = l.get(i).getName();// +l.get(i).getId();
			if (str.contains(searchText)) {
				sb.append(l.get(i).toString());
			}
		}
		out.print(sb.toString());
		out.flush();
		out.close();
	}

	@RequestMapping("/mvCallStat")
	public String mvCallStat(HttpServletRequest request, String cps, String cp_id[], Integer tag, ModelMap modelMap) throws Exception {

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		// GatewayInfo gatewayInfo = new GatewayInfo();
		if (tag == null) {
			tag = 2;
		} else if (tag == 2) {
			tag = 1;
		} else {
			tag = 2;
		}
		try {
			for (int i = 0; i < cp_id.length; i++) {
				Channel ch = new Channel();
				String[] cp = cp_id[i].split("&");
				ch.setCh_id(Integer.parseInt(cp[0]));
				ch.setPublic_key(cp[1]);
				ch.setTag(tag);
				if (channelService.updateChStatus(ch) <= 0) {
					ch.setCh_cut(1);
					channelService.updateChStatus(ch);
				}
			}
			/*
			 * String cpids = null; if(cp_id!=null){ cpids=
			 * arrayToString(cp_id); } if(cps!=null&&!"".equals(cps)){
			 * cpids=cps.replace("，", ","); } Channel ch = new Channel();
			 * if(tag==null){ tag=2; }else if(tag==2){ tag=1; }else{ tag=2; }
			 * ch.setTag(tag); ch.setArrayIds(cpids);
			 * channelService.updateChannelTag(ch); //List<CallStat> list=
			 * callStatService.qryAllCallStatList(callStat); //
			 * CallStatExcel.createExcelByte( list, response);
			 */
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
		return "redirect:/listAllCallStat.do";
	}

	protected String arrayToString(String arr[]) {
		StringBuffer sb = new StringBuffer();
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				if (i < arr.length - 1) {
					sb.append(arr[i]).append(",");
				} else {
					sb.append(arr[i]);
				}
			}

		}
		return sb.toString();
	}

	@RequestMapping("/exportCallStat")
	public void exportCallStat(HttpServletRequest request, HttpServletResponse response, CallStat callStat, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String dater = sf.format(new Date());
		if (callStat.getStart_time() == null || callStat.getEnd_time() == null) {
			callStat.setDater(dater);
			callStat.setStart_time(dater);
			callStat.setEnd_time(dater);
		} else {
			callStat.setDater(callStat.getStart_time());
		}
		// GatewayInfo gatewayInfo = new GatewayInfo();
		System.out.println("=============" + callStat.toString());
		if (callStat.getTag() == null || "".equals(callStat.getTag())) {
			callStat.setTag("1");
		}

		String protag = callStat.getProtype();
		String searchCcpid = callStat.getCcp_id();
		Integer cpid = callStat.getCp_id();
		List<CpMember> cpmList = cpCompanyService.qryCpMemberList(new CpMember());
		HashMap<String, String> cpmTemp = new HashMap<String, String>();
		for (CpMember cpm : cpmList) {
			cpmTemp.put(String.valueOf(cpm.getCpm_id()), cpm.getCpm_name());
		}
		try {

			List<CallStat> list = null;
			if (dater.equals(callStat.getStart_time())) {
				list = qryAllCallStatList(callStat);
			} else {
				list = callStatService.qryAllCallStatList(callStat);
			}
			SmsFilterStat smsFilter = new SmsFilterStat();
			smsFilter.setStart_time(callStat.getStart_time());
			smsFilter.setEnd_time(callStat.getEnd_time());
			List<SmsFilterStat> listSms = feecodeStatService.qrySmsFilterCpStatList(smsFilter);
			List<SmsFilterStat> listSmsReport = feecodeStatService.qrySmsReportStatList(smsFilter);
			List<DataDictionary> listd = dataDictionaryService.qryDataDictionaryLists(new DataDictionary());
			DataDictionary ddd = listd.get(0);
			String cpids = ",";
			for (DataDictionary d : listd) {
				cpids = cpids + d.getCpids() + ",";
			}
			ddd.setCpids(cpids);

			HashMap<String, Integer> ssf = new HashMap<String, Integer>();
			for (SmsFilterStat smsF : listSms) {
				ssf.put(smsF.getDater() + smsF.getCp_id(), smsF.getFilterUsers());
			}

			HashMap<String, Integer> ssr = new HashMap<String, Integer>();
			for (SmsFilterStat smsR : listSmsReport) {
				if (smsR.getCp_id() != null) {
					ssr.put(smsR.getDater() + smsR.getCp_id(), smsR.getFilterUsers());
				}
			}
			List<CallStat> nofeeinitlist = callStatService.qryInitNoFeeStatList(callStat);

			int allNofeeInitnum = 0;
			HashMap<String, Integer> nofeeTemp = new HashMap<String, Integer>();
			for (CallStat nofeeinit : nofeeinitlist) {
				if (nofeeinit != null) {
					nofeeTemp.put(nofeeinit.getDater() + nofeeinit.getCcp_id(), nofeeinit.getInitnum());
				}
			}
			List<CallStat> retlist = new ArrayList<CallStat>();
			for (CallStat cs : list) {

				if (searchCcpid != null && !"".equals(searchCcpid)) {
					if (cs.getCcp_id() != null && !cs.getCcp_id().contains(searchCcpid)) {

						continue;
					}
				}

				if ("2".equals(protag)) {
					if (cs.getCp_id() != null) {
						if (cs.getCp_id() < 10000) {

							continue;
						}
					}
				}

				if ("3".equals(protag)) {
					if (cs.getCp_id() != null) {
						if (cs.getCp_id() >= 10000) {

							continue;
						}
					}
				}

				if (cpid != null && cs.getCp_id() != null && cs.getCp_id().intValue() != cpid.intValue()) {
					System.out.println();
					continue;
				}

				/*
				 * for(SmsFilterStat smsF: listSms){
				 * if(cs.getDater().equals(smsF.getDater())&&(smsF.getCp_id().
				 * equals(String.valueOf(cs.getCp_id()))||smsF.getCp_id().equals
				 * (cs.getCcp_id()))){ cs.setSmsNum(smsF.getFilterUsers()); } }
				 * 
				 * for(SmsFilterStat smsR:listSmsReport){
				 * if(smsR.getCp_id()!=null)
				 * if(cs.getDater().equals(smsR.getDater())&&(smsR.getCp_id().
				 * equals(String.valueOf(cs.getCp_id()))||smsR.getCp_id().equals
				 * (cs.getCcp_id()))){
				 * cs.setSmsReportNum(smsR.getFilterUsers()); } }
				 */
				cs.setNofeeinitnum(nofeeTemp.get(cs.getDater() + cs.getCcp_id()) == null ? 0 : nofeeTemp.get(cs.getDater() + cs.getCcp_id()));

				cs.setSmsNum(ssf.get(cs.getDater() + cs.getCcp_id()));
				if (cs.getSmsNum() == null) {
					cs.setSmsNum(ssf.get(cs.getDater() + cs.getCp_id()));
				}

				cs.setSmsReportNum(ssr.get(cs.getDater() + cs.getCcp_id()));
				if (cs.getSmsReportNum() == null) {
					cs.setSmsReportNum(ssr.get(cs.getDater() + cs.getCp_id()));
				}

				if (cs.getCcp_id() != null && !"".equals(cs.getCcp_id())) {
					String ccpid = cs.getCcp_id();
					if (ccpid.contains("_")) {
						String ccp = ccpid.split("_")[0];
						if (ccp.equals(String.valueOf(cs.getCp_id()))) {
							String ccpname = cpmTemp.get(ccp);
							if (ccpname != null && !"".equals(ccpname)) {
								cs.setCp_name(ccpname);
							}
						}
					}
				}

				cs.setSmsNum(cs.getSmsNum() == null ? 0 : cs.getSmsNum());
				cs.setSmsReportNum(cs.getSmsReportNum() == null ? 0 : cs.getSmsReportNum());

				if (cs.getSucc_users() != null) {
					cs.setRate(new DecimalFormat("#.##%").format((double) cs.getSmsReportNum() / (double) cs.getSucc_users()));
				} else {
					cs.setRate("-");
				}
				if (ddd.getCpids().contains("," + cs.getCp_id() + ",") || ddd.getCpids().contains("," + cs.getCcp_id() + ",")) {
					cs.setRemarks(".");
				} else {
					// cs.setRemarks("-");
				}
				retlist.add(cs);

			}
			CallStatExcel.createExcelByte(retlist, response);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
		/// return "stat/listRecData";
	}

	@RequestMapping("/listRecStat")
	public String listRecStat(HttpServletRequest request, CallStat callStat, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {
		if (callStat == null) {
			return "err";
		}

		List<Channel> chList = channelService.qryChannelList(new Channel());

		try {
			PageHelper.startPage(pageId, 35);
			List<CallStat> list = callStatService.qryRecStatList(callStat);
			PageInfo page = new PageInfo(list);

			int allSuccCalls = 0;
			int allSuccUsers = 0;

			for (CallStat cs : list) {
				for (Channel ch : chList) {
					if (ch.getCh_id() == cs.getCp_id()) {
						cs.setCp_name(ch.getCh_name());
						continue;
					}
				}
				allSuccCalls = allSuccCalls + cs.getSucc_calls();
				allSuccUsers = allSuccUsers + cs.getSucc_users();

			}
			System.out.println(page.getTotal() + "===========" + page.getPageNum() + "======" + page.getPageSize());
			modelMap.addAttribute("page", page);
			modelMap.addAttribute("allSuccCalls", allSuccCalls);
			modelMap.addAttribute("allSuccUsers", allSuccUsers);

			modelMap.addAttribute("chList", chList);
			modelMap.addAttribute("searchObj", callStat);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
		return "stat/listRecStat";
	}

	@RequestMapping("/listInitStat")
	public String listInitStat(HttpServletRequest request, CallStat callStat, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {
		if (callStat == null) {
			return "err";
		}

		List<Channel> chList = channelService.qryChannelList(new Channel());

		try {
			PageHelper.startPage(pageId, 35);
			List<CallStat> list = callStatService.qryInitStatList(callStat);
			PageInfo page = new PageInfo(list);

			int allSuccCalls = 0;
			int allSuccUsers = 0;
			int allFailCalls = 0;
			int allFailUsers = 0;
			int allCalls = 0;
			int allUsers = 0;

			for (CallStat cs : list) {
				allSuccCalls = allSuccCalls + cs.getSucc_calls();
				allSuccUsers = allSuccUsers + cs.getSucc_users();
				allFailCalls = allFailCalls + cs.getFail_calls();
				allFailUsers = allFailUsers + cs.getFail_users();
				allCalls = allCalls + cs.getAll_calls();
				allUsers = allUsers + cs.getAll_users();

			}
			System.out.println(page.getTotal() + "===========" + page.getPageNum() + "======" + page.getPageSize());
			modelMap.addAttribute("page", page);
			modelMap.addAttribute("allSuccCalls", allSuccCalls);
			modelMap.addAttribute("allSuccUsers", allSuccUsers);
			modelMap.addAttribute("allFailCalls", allFailCalls);
			modelMap.addAttribute("allFailUsers", allFailUsers);
			modelMap.addAttribute("allCalls", allCalls);
			modelMap.addAttribute("allUsers", allUsers);
			modelMap.addAttribute("cpList", chList);
			modelMap.addAttribute("searchObj", callStat);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}
		return "stat/listInitStat";
	}

	@RequestMapping("/listProvinceCallStat")
	public String listProvinceCallStat(HttpServletRequest request, CallStat callStat, @RequestParam(defaultValue = "1") int pageId, ModelMap modelMap) throws Exception {
		if (callStat == null) {
			return "err";
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String dater = sf.format(new Date());
		if (callStat.getStart_time() == null || callStat.getEnd_time() == null) {
			callStat.setDater(dater);
			callStat.setStart_time(dater);
			callStat.setEnd_time(dater);
		} else {
			callStat.setDater(callStat.getStart_time());
		}
		CpMakefeeItem cpMakefeeItem = new CpMakefeeItem();
		if (callStat.getOp() != null && !"".equals(callStat.getOp())) {
			cpMakefeeItem.setFeecode_op(Integer.parseInt(callStat.getOp()));
		}
		List<CpMember> cpmList = cpCompanyService.qryCpMemberList(new CpMember());
		HashMap<String, String> cpmTemp = new HashMap<String, String>();
		for (CpMember cpm : cpmList) {
			cpmTemp.put(String.valueOf(cpm.getCpm_id()), cpm.getCpm_name());
		}
		try {
			PageHelper.startPage(pageId, 1000);
			List<CallStat> list = callStatService.qryProvinceCallStatList(callStat);

			List<CpMakefeeItem> openCommands = cpMakefeeItemService.getOpenCommandCount(cpMakefeeItem);
			PageInfo page = new PageInfo(list);

			int allInitnum = 0;
			int allSuccCalls = 0;
			int allSuccUsers = 0;

			int allCalls = 0;
			int allUsers = 0;

			for (CallStat cs : list) {

				for (CpMakefeeItem item : openCommands) {
					System.out.println(item.getOpen_province_name() + item.getFeecode_op() + "====" + cs.getProvince_name() + cs.getOp());
					if ((item.getOpen_province_name() + item.getFeecode_op()).equals(cs.getProvince_name() + cs.getOp())) {
						cs.setCmds(item.getItem_count());
						cs.setProvince_id(item.getOpen_province_id());
						cs.setFees(item.getFees());
					} else {

					}
				}

				if (cs.getCcp_id() != null && !"".equals(cs.getCcp_id())) {
					String ccpid = cs.getCcp_id();
					if (ccpid.contains("_")) {
						String ccp = ccpid.split("_")[0];
						if (ccp.equals(cs.getCp_id())) {
							String ccpname = cpmTemp.get(ccp);
							if (ccpname != null && "".equals(ccpname)) {
								cs.setCp_name(ccpname);
							}
						}
					}
				}

				allInitnum = allInitnum + cs.getInitnum();
				allSuccCalls = allSuccCalls + cs.getSucc_calls();
				allSuccUsers = allSuccUsers + cs.getSucc_users();

				allCalls = allCalls + cs.getAll_calls();
				allUsers = allUsers + cs.getAll_users();

			}
			System.out.println(page.getTotal() + "===========" + page.getPageNum() + "======" + page.getPageSize());
			modelMap.addAttribute("page", page);
			modelMap.addAttribute("allInitnum", allInitnum);
			modelMap.addAttribute("allSuccCalls", allSuccCalls);
			modelMap.addAttribute("allSuccUsers", allSuccUsers);

			modelMap.addAttribute("allCalls", allCalls);
			modelMap.addAttribute("allUsers", allUsers);

			modelMap.addAttribute("searchObj", callStat);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

		return "stat/listProvinceCallStat";
	}

	class Sort implements Comparator<Object> {
		public int compare(Object o1, Object o2) {
			CallStat t1 = (CallStat) o1;
			CallStat t2 = (CallStat) o2;
			/*
			 * if (t1.getCp_id() > t2.getCp_id()) { return 1; } else if
			 * (t1.getCp_id() == t2.getCp_id()) { if (t1.getInitnum() >
			 * t2.getInitnum()) { return -1; } else if (t1.getInitnum() ==
			 * t2.getInitnum()) { return 0; } else if (t1.getInitnum() <
			 * t2.getInitnum()) { return 1; } } else if (t1.getCp_id() <
			 * t2.getCp_id()) { return -1; }
			 */

			if (t1.getInitnum() > t2.getInitnum()) {
				return -1;
			} else if (t1.getInitnum() == t2.getInitnum()) {
				return 0;
			} else if (t1.getInitnum() < t2.getInitnum()) {
				return 1;
			}

			return 0;
		}
	}

}
