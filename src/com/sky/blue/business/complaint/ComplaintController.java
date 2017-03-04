package com.sky.blue.business.complaint;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.complaint.entity.BlackMobileInfo;
import com.sky.blue.business.complaint.entity.ComplaintStat;
import com.sky.blue.business.complaint.service.IComplaintService;
import com.sky.blue.business.cpmanager.entity.Channel;
import com.sky.blue.business.cpmanager.entity.ChannelManager;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpMember;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.cpmanager.service.IChannelManagerService;
import com.sky.blue.business.cpmanager.service.IChannelService;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
import com.sky.blue.business.data.entity.DataDictionary;
import com.sky.blue.business.data.entity.MobileUser;
import com.sky.blue.business.data.service.IDataDictionaryService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.service.ICpMakefeeItemService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.business.stat.entity.Caitsat;
import com.sky.blue.business.stat.entity.CallStat;
import com.sky.blue.business.stat.entity.RecCallAllDate;
import com.sky.blue.business.stat.entity.SmsFilterStat;
import com.sky.blue.business.stat.service.ICaitsatService;
import com.sky.blue.business.stat.service.ICallStatService;
import com.sky.blue.business.stat.service.IFeecodeStatService;
import com.sky.blue.comm.BaseController;

@Controller
public class ComplaintController extends BaseController{
	
	@Resource(name="complaintServiceImpl")
	private IComplaintService complaintService;
	
	@Resource(name="callStatServiceImpl")
	private ICallStatService callStatService;
	
	 @Resource(name="cpCompanyServiceImpl")
	private ICpCompanyService cpCompanyService;
	 
	 @Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;

	 
	 @RequestMapping("/listBlackMobileInfo")
	    public String listBlackMobileInfo(HttpServletRequest request,BlackMobileInfo binfo, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
			 
			 List<BlackMobileInfo> list = null;
				try {
					PageHelper.startPage(pageId, 20);
					list = complaintService.listBlackMobileInfo(binfo);
				} catch (Exception e) {
					e.printStackTrace();
				}
				PageInfo page = null;
				if(list.size()!=0 && list!=null){
					 page = new PageInfo(list);
				}
				request.setAttribute("page", page);
				request.setAttribute("searchObj", binfo);
	      
	        return "complaint/listBlackMobileInfo";
	    }
	 
	 @RequestMapping("/listComplaintRate")
	    public String listComplaintRate(HttpServletRequest request,ComplaintStat obj, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
		 	Calendar rightNow = Calendar.getInstance();
				rightNow.setTime(new Date());
				int h=rightNow.get(Calendar.HOUR_OF_DAY);
				rightNow.add(Calendar.DATE, -90);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dater= dateFormat.format(rightNow.getTime());
				String dater1=dateFormat.format(new Date());
		 	if(obj.getStart_time()==null){
			obj.setStart_time(dater);
		 	obj.setEnd_time(dater1);	
	 		}
		 	
		 	 if( obj.getTag()==null||"".equals(obj.getTag())){
		 		obj.setTag(1);
	         }
		 	 HashMap<String ,Integer> statusTemp = new  HashMap<String ,Integer>();
		 	 List<ComplaintStat> showStatus = complaintService.getShowStaus();
		 	 for(ComplaintStat stat:showStatus){
		 		statusTemp.put(stat.getCp_id(), stat.getTag());
		 	 }
			 List<ComplaintStat> list = null;
			 List<ComplaintStat> retlist =new  ArrayList<ComplaintStat>();
				try {
				//	PageHelper.startPage(pageId, 20);
					list = complaintService.listComplaintRate(obj);
					for(int i=0;i<list.size();i++){
						ComplaintStat cmt=list.get(i);
						if(obj.getTag()==1){
							if(statusTemp.get(cmt.getCp_id())==null||statusTemp.get(cmt.getCp_id())!=2){
								retlist.add(cmt);
							}
						}else{
							if(statusTemp.get(cmt.getCp_id())!=null&&statusTemp.get(cmt.getCp_id())==2){
								retlist.add(cmt);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				//PageInfo page = null;
				//if(list.size()!=0 && list!=null){
					// page = new PageInfo(retlist);
			//}
				request.setAttribute("retlist", retlist);
				//request.setAttribute("page", page);
				request.setAttribute("searchObj", obj);
	      
	        return "complaint/listComplaintRate";
	    }
	 
	 
	 @RequestMapping("/mvComplaintStat")
	 public String mvComplaintStat(HttpServletRequest request,String cp_id[],Integer tag,ModelMap modelMap)
	            throws Exception {
	        
		  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	       
	        //GatewayInfo gatewayInfo = new GatewayInfo();
			if(tag==null){
	      		tag=2;
	      	}else if(tag==2){
	      		tag=1;
	      	}else{
	      		tag=2;
	      	}
	        try {
	        	for (int i = 0; i < cp_id.length; i++) {
	        		ComplaintStat obj = new ComplaintStat();
	        		String cp = cp_id[i];
	        		obj.setCp_id(cp);
	
	        		obj.setTag(tag);
	        		if(complaintService.updateCmStatus(obj)<=0){
	        			obj.setVtag(1);
	        			complaintService.updateCmStatus(obj);
	        		}
				}
	        	/*String cpids = null;
	        	if(cp_id!=null){
	        		cpids=	arrayToString(cp_id);
	        	}
	        	if(cps!=null&&!"".equals(cps)){
	        		cpids=cps.replace("，", ",");
	        	}
	        	Channel ch = new Channel();
	        	if(tag==null){
	        		tag=2;
	        	}else if(tag==2){
	        		tag=1;
	        	}else{
	        		tag=2;
	        	}
	        	ch.setTag(tag);
	        	ch.setArrayIds(cpids);
	        	channelService.updateChannelTag(ch);
	        	 //List<CallStat> list= callStatService.qryAllCallStatList(callStat);
	           // CallStatExcel.createExcelByte(  list, response);*/           
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "redirect:/listComplaintRate.do";
	    }
	 
	 /**
	  * Sjm
	  * 模糊搜索公司
	  * @param request
	  * @param response
	  * @param searchText 
	  */
	 @RequestMapping("/seachNewCpCompanyList")
	 public void seachNewCpCompanyList(HttpServletRequest request,Caitsat obj, HttpServletResponse response, String searchText){
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = null;
		 List<SearchBean> l = (List<SearchBean>) request.getSession().getAttribute("sssList");
		 CpCompany sc = new CpCompany();
		 sc.setCp_name("%"+searchText+"%");
		
		 SearchBean bean = new SearchBean();
		 try { 
			if(l==null){
				/*l=new HashSet<SearchBean>();
				List<CpCompany> l1 = cpCompanyService.qryCpCompanyList(sc);
				for (int i = 0; i < l1.size(); i++) {
					bean.setId((i+1));
					bean.setName(l1.get(i).getCp_name());
					l.add(bean);
				}*/
				l = spCompanyService.seachCompanyList(sc);
				request.getSession().setAttribute("sssList", l);
				System.out.println("-------------->:"+l.size()+":::"+sc.getCreate_name());
				
				request.getSession().setAttribute("sssList", l);
			}
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
		 }
		 StringBuffer sb = new StringBuffer();
		 for (SearchBean bean1:l) {
			 
			if(bean1.getName().contains(searchText)){
				 sb.append(bean1.toString());
			 }
		 }
		 out.print(sb.toString());
		 out.flush();
		 out.close();
	 }
	
	 /**
	  * Sjm
	  * 模糊
	  * @param request
	  * @param response
	  * @param searchText 
	  */
	 @RequestMapping("/seachNewCpProductList")
	 public void seachNewCpProductList(HttpServletRequest request, HttpServletResponse response, SearchBean search){
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = null;
		 List<SearchBean> l = (List<SearchBean>) request.getSession().getAttribute("sfcList");
		 CpProduct sf = new CpProduct();
		 sf.setCp_name("%"+search.getSearchText()+"%");
		 try { 
			if(l==null){
				l = spCompanyService.seachCpProductList(sf);
				request.getSession().setAttribute("sfcList", l);
			}
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
		 }
		 StringBuffer sb = new StringBuffer();
		 if(search.getPid()!=null){
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getPid().equals(search.getPid())&&l.get(i).getName().contains(search.getSearchText())){
					 sb.append(l.get(i).toString());
				 }
			 }
		 }else{
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getName().contains(search.getSearchText())){
					 sb.append(l.get(i).toString());
				 }
			 }
		 }
		 out.print(sb.toString());
		 out.flush();
		 out.close();
	 }
	   
}
