package com.sky.blue.business.stat;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.stat.entity.Calldetail;
import com.sky.blue.business.stat.entity.Incomededail;
import com.sky.blue.business.stat.service.IStatAllServer;
import com.sky.blue.comm.BaseController;

@Controller
public class StatAllController extends BaseController{

	  @Autowired
	  private IStatAllServer statAllServer;
	  
	  @RequestMapping("/listALLChannelStat")
	  public String listALLChannelStat(HttpServletRequest request,Calldetail calldetail, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
		 if(calldetail==null){
	        	return "err";
	        }
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        Date d = new Date();
	        String dater=sf.format(d);
	        if(calldetail.getStart_time()==null||calldetail.getEnd_time()==null){
	        	calldetail.setDater(dater);
	        	calldetail.setStart_time(dater);
	        	calldetail.setEnd_time(dater);
	        }else{
	        	Date date = sf.parse(calldetail.getEnd_time());
	        	Date date1 = sf.parse(dater);
	        	if(date.getTime()>date1.getTime()){
	        		calldetail.setEnd_time(dater);
	        	}
	        	Date date2 = sf.parse(calldetail.getStart_time());
	        	if(date2.getTime()<date1.getTime()&&date.getTime()>=date1.getTime()){
	        		date1.setDate(date1.getDate()-1);
	        		dater=sf.format(date1);
	        		calldetail.setEnd_time(dater);
	        	}
	        	calldetail.setDater(null);
	        }
	        try {
	            //PageHelper.startPage(pageId, 10000, false);
	            List<Calldetail> list = statAllServer.listALLChannelStat(calldetail);
	            PageInfo page = new PageInfo(list);
	            page.setList(list);
	            page.setPageNum(1);
	            page.setTotal(list.size());
	            modelMap.addAttribute("page", page);
		        modelMap.addAttribute("searchObj", calldetail);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "stat/listAllChannelData";
	    }
	 
	 @RequestMapping("/updCalldetailFee")
	 public void updCalldetailFee(HttpServletRequest request, HttpServletResponse response, Calldetail calldetail){
		 PrintWriter out = null;
		 int meg = -1;
		 try {
			 out = response.getWriter();
			 meg = statAllServer.updCalldetailFee(calldetail);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 out.print(meg);
		 out.flush();
		 out.close();
	 }
	 
	 @RequestMapping("/listALLProductStat")
	    public String listALLProductStat(HttpServletRequest request,Calldetail calldetail , @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(calldetail==null){
	        	return "err";
	        }
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        Date d = new Date();
	        String dater=sf.format(d);
	        if(calldetail.getStart_time()==null||calldetail.getEnd_time()==null){
	        	calldetail.setDater(dater);
	        	calldetail.setStart_time(dater);
	        	calldetail.setEnd_time(dater);
	        }else{
	        	Date date = sf.parse(calldetail.getEnd_time());
	        	Date date1 = sf.parse(dater);
	        	if(date.getTime()>date1.getTime()){
	        		calldetail.setEnd_time(dater);
	        	}
	        	Date date2 = sf.parse(calldetail.getStart_time());
	        	if(date2.getTime()<date1.getTime()&&date.getTime()>=date1.getTime()){
	        		date1.setDate(date1.getDate()-1);
	        		dater=sf.format(date1);
	        		calldetail.setEnd_time(dater);
	        	}
	        	calldetail.setDater(null);
	        }
	        try {
	            //PageHelper.startPage(pageId, 10000, false);
	            List<Calldetail> list = statAllServer.listALLProductStat(calldetail);
	            PageInfo page = new PageInfo(list);
	            page.setList(list);
	            page.setPageNum(1);
	            page.setTotal(list.size());
	            modelMap.addAttribute("page", page);
		        modelMap.addAttribute("searchObj", calldetail);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "stat/listAllProductData";
	    }
	

		@RequestMapping("/listAllCompanyStat")
	    public String listAllCompanyStat(HttpServletRequest request,Incomededail incomededail, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(incomededail==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+incomededail.toString());
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        Date d = new Date();
	        String dater=sf.format(d);
	        if(incomededail.getStart_time()==null||incomededail.getEnd_time()==null){
	        	incomededail.setDater(dater);
	        	incomededail.setStart_time(dater);
	        	incomededail.setEnd_time(dater);
	        }else{
	        	Date date = sf.parse(incomededail.getEnd_time());
	        	Date date1 = sf.parse(dater);
	        	if(date.getTime()>date1.getTime()){
	        		incomededail.setEnd_time(dater);
	        	}
	        	Date date2 = sf.parse(incomededail.getStart_time());
	        	if(date2.getTime()<date1.getTime()&&date.getTime()>=date1.getTime()){
	        		date1.setDate(date1.getDate()-1);
	        		dater=sf.format(date1);
	        		incomededail.setEnd_time(dater);
	        	}
	        	incomededail.setDater(null);
	        }
	       
	        try {
	            PageHelper.startPage(pageId, 10000, false);
	            List<Incomededail> list= statAllServer.listAllCompanyStat(incomededail);
	            PageInfo page = new PageInfo(list);
	            page.setTotal(list.size());
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
		        modelMap.addAttribute("searchObj", incomededail);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	
	        }
	        return "stat/listAllCompanyData";
	    }
		
		
		 @RequestMapping("/updCompanyStatFee")
		 public void updCompanyStatFee(HttpServletRequest request, HttpServletResponse response, Incomededail incomededail){
			 PrintWriter out = null;
			 int meg = -1;
			 try {
				 out = response.getWriter();
				 meg = statAllServer.updCompanyStatFee(incomededail);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
			 out.print(meg);
			 out.flush();
			 out.close();
		 }
		
		@RequestMapping("/getAllproduct")
		public void getAllproduct(HttpServletRequest request, HttpServletResponse response, SearchBean sc){
			sc.setName("%"+sc.getName()+"%");
			 response.setCharacterEncoding("utf-8");
			 response.setContentType("text/html;charset=UTF-8");
			 PrintWriter out = null;
			List<SearchBean> l = null;
			try {
				l = statAllServer.getAllproduct(sc);
				out = response.getWriter();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 StringBuffer sb = new StringBuffer("");
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getName().contains(sc.getSearchText())){
					 sb.append(l.get(i).toString());
				 }
			 }
			 out.print(sb.toString());
			 out.flush();
			 out.close();
		}
		
		
		
		@RequestMapping("/getAllcp")
		public void getAllcp(HttpServletRequest request, HttpServletResponse response, SearchBean sc){
			sc.setName("%"+sc.getName()+"%");
			 response.setCharacterEncoding("utf-8");
			 response.setContentType("text/html;charset=UTF-8");
			 PrintWriter out = null;
			List<SearchBean> l = null;
			try {
				l = statAllServer.getAllcp(sc);
				out = response.getWriter();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 StringBuffer sb = new StringBuffer("");
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getName().contains(sc.getSearchText())){
					 sb.append(l.get(i).toString());
				 }
			 }
			 out.print(sb.toString());
			 out.flush();
			 out.close();
		}
		
		
		
		
		@RequestMapping("/getAllcompany")
		public void getAllcompany(HttpServletRequest request, HttpServletResponse response, SearchBean sc){
			sc.setName("%"+sc.getName()+"%");
			 response.setCharacterEncoding("utf-8");
			 response.setContentType("text/html;charset=UTF-8");
			 PrintWriter out = null;
			List<SearchBean> l = null;
			try {
				l = statAllServer.getAllcompany(sc);
				out = response.getWriter();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 StringBuffer sb = new StringBuffer("");
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getName().contains(sc.getSearchText())){
					 sb.append(l.get(i).toString());
				 }
			 }
			 out.print(sb.toString());
			 out.flush();
			 out.close();
		}

		@RequestMapping("/getAllfeecode")
        public void getAllfeecode(HttpServletRequest request, HttpServletResponse response, SearchBean sc){
			sc.setName("%"+sc.getSearchText()+"%");
			response.setCharacterEncoding("utf-8");
			 response.setContentType("text/html;charset=UTF-8");
			 PrintWriter out = null;
			List<SearchBean> l = null;
			try {
				l = statAllServer.getAllfeecode(sc);
				out = response.getWriter();
			} catch (Exception e) {
				e.printStackTrace();
			}
			 StringBuffer sb = new StringBuffer();
			 if(sc.getPid()!=null){
				 for (int i = 0; i < l.size(); i++) {
					 if(l.get(i).getPid().equals(sc.getPid())&&l.get(i).getName().contains(sc.getSearchText())){
						 sb.append(l.get(i).toString());
					 }
				 }
			 }else{
				 for (int i = 0; i < l.size(); i++) {
					 if(l.get(i).getName().contains(sc.getSearchText())){
						 sb.append(l.get(i).toString());
					 }
				 }
			 }
			 out.print(sb.toString());
			 out.flush();
			 out.close();
        }
		
		

		
}
