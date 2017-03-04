package com.sky.blue.business.cpfeeplan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
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
import com.sky.blue.business.cpfeeplan.entity.CpFeemeasure;
import com.sky.blue.business.cpfeeplan.entity.CpFeemeasureItem;
import com.sky.blue.business.cpfeeplan.entity.CpFeeplan;
import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;
import com.sky.blue.business.cpfeeplan.service.ICpFeemeasureService;
import com.sky.blue.business.cpfeeplan.service.ICpFeeplanService;
import com.sky.blue.business.cpfeeplan.service.ICpMakefeeLinkService;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.business.platform.service.IProvinceService;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.service.ICpMakefeeItemService;
import com.sky.blue.comm.BaseController;
@Controller
public class CpFeemeasureController extends BaseController {
	  @Resource(name="cpFeemeasureServiceImpl")
	private ICpFeemeasureService cpFeemeasureService;
	  @Resource(name="cpFeeplanServiceImpl")
		private ICpFeeplanService cpFeeplanService;
		@Resource(name="cpMakefeeItemServiceImpl")
		private ICpMakefeeItemService cpMakefeeItemService;
		  @Resource(name="cpMakefeeLinkServiceImpl")
			private ICpMakefeeLinkService cpMakefeeLinkService;
			@Resource(name="provinceServiceImpl")
			private IProvinceService provinceService;	  
		
	   @RequestMapping("/listCpFeemeasure")
	    public String listCpFeemeasure(HttpServletRequest request,CpFeemeasure cpFeemeasure, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(cpFeemeasure==null){
	        	return "err";
	        }
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        System.out.println("============="+cpFeemeasure.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<CpFeemeasure> list= cpFeemeasureService.qryCpFeemeasureList(cpFeemeasure);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            List<CpFeeplan> cpfeeplanlist= cpFeeplanService.qryCpFeeplanList(new CpFeeplan());
	 	        modelMap.addAttribute("feeplanList", cpfeeplanlist);
	 	       modelMap.addAttribute("searchObj", cpFeemeasure);
	        } catch (Exception e) {
	        	
	        }
	        return "cpfeeplan/listCpFeemeasure";
	    }
	   
	   
	   @RequestMapping("/listCpFeemeasureItem")
	    public String listCpFeemeasureItem(HttpServletRequest request,CpFeemeasureItem cpFeemeasureItem, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(cpFeemeasureItem==null){
	        	return "err";
	        }
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        System.out.println("============="+cpFeemeasureItem.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 35);
	            List<CpFeemeasureItem> list= cpFeemeasureService.qryCpFeemeasureItemList(cpFeemeasureItem);
	            
	            HashMap<Integer ,CpFeemeasureItem> temp = new HashMap<Integer ,CpFeemeasureItem>();
	            for(CpFeemeasureItem item:list){
	            	//item.setRemarks();
	            	String stat ="";
	            	String str ="绑定：";
	            	String refItems="";
	            	if(item.getCp_item_id()!=null){
		            	if(item.getItem_status()==0){
		            		stat="<font color=\"grean\">启用</font>";
		            	}else{
		            		stat="<font color=\"red\">关闭</font>";
		            	}
		            	 str ="<p>绑定：-"+item.getCp_item_id()+"-"+stat+"</p>";
		            	 refItems=item.getCp_item_id()+",";
	            	}
	            	CpFeemeasureItem it = temp.get(item.getFeemeasure_item_id());
	            	if(it==null){
	            		item.setRemarks(str);
	            		item.setRef_items(refItems);
	            		temp.put(item.getFeemeasure_item_id(), item);
	            	}else{
	            		it.setRemarks(it.getRemarks()+str);
	            		it.setRef_items(it.getRef_items()+refItems);
	            	}
	            	
	            }
	          /*  ArrayList<CpFeemeasureItem> cfiList = new  ArrayList<CpFeemeasureItem> ();
	            Iterator<Integer> it = temp.keySet().iterator();
	            while (it.hasNext()) {
	            	cfiList.add(temp.get(it.next()));
	            }
	            Collections.sort(cfiList,new Comparator<CpFeemeasureItem>(){
	                public int compare(CpFeemeasureItem arg0, CpFeemeasureItem arg1) {
	                    return arg0.getFeemeasure_item_id().compareTo(arg1.getFeemeasure_item_id());
	                }
	            });*/
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            //List<CpFeemeasure> cpfeemeasurelist= cpFeemeasureService.qryCpFeemeasureList(new CpFeemeasure());
	 	        //modelMap.addAttribute("cpfeemeasurelist", cpfeemeasurelist);
	 	       List<CpFeeplan> cpfeeplanlist= cpFeeplanService.qryCpFeeplanList(new CpFeeplan());
	 	        modelMap.addAttribute("feeplanList", cpfeeplanlist);
		        List<Province> proList = provinceService.getProvinceList(new Province());
		        modelMap.addAttribute("proList", proList);
		        modelMap.addAttribute("searchObj", cpFeemeasureItem);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return "cpfeeplan/listCpFeemeasureItem";
	    }
	   
	    @RequestMapping("/addCpFeemeasure")
	    public String addCpFeemeasure(HttpServletRequest request,CpFeemeasure cpFeemeasure, ModelMap modelMap)
	            throws Exception {
	        if(cpFeemeasure==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        cpFeemeasure.setCreate_name(dbUser.getUserName());
	        System.out.println(cpFeemeasure.getFeeplan_name()+"^^^^^^^^^^^^^^^^^^^^^");  
	        int id =cpFeemeasureService.addCpFeemeasure(cpFeemeasure);
	        System.out.println(id+"  ============");
	        return "redirect:/listCpFeemeasure.do";
	    }
	     
	    @RequestMapping("/deleteCpFeemeasure")
	    public void deleteCpFeemeasure(HttpServletRequest request, HttpServletResponse response,CpFeemeasure cpFeemeasure,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+cpFeemeasure.getArrayIds());
	    		int i= cpFeemeasureService.deleteCpFeemeasure(cpFeemeasure);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/deleteCpFeemeasureItem")
	    public void deleteCpFeemeasureItem(HttpServletRequest request, HttpServletResponse response,CpFeemeasureItem cpFeemeasureItem,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+cpFeemeasureItem.getArrayIds());
	    		int i= cpFeemeasureService.deleteCpFeemeasureItem(cpFeemeasureItem);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    
	    @RequestMapping("/editCpFeemeasure")
	    public String editCpFeemeasure (HttpServletRequest request,CpFeemeasure cpFeemeasure, ModelMap modelMap)
	            throws Exception {
	        if(cpFeemeasure==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        CpFeemeasure cpFeemeasureObj=new CpFeemeasure();
	        if(cpFeemeasure.getFeemeasure_id()!=null){
	        	List<CpFeemeasure> list= cpFeemeasureService.qryCpFeemeasureList(cpFeemeasure);
	         cpFeemeasureObj= list.get(0);
	        }else{
	        	List<CpFeeplan> cpfeeplanlist= cpFeeplanService.qryCpFeeplanList(new CpFeeplan());
	 	        modelMap.addAttribute("feeplanList", cpfeeplanlist);
	        }

	        System.out.println(cpFeemeasure.toString());  
	        modelMap.addAttribute("paramObj", cpFeemeasureObj);
	        return "cpfeeplan/editCpFeemeasure";
	    }
	    
	    @RequestMapping("/editCpFeemeasureItem")
	    public String editCpFeemeasureItem (HttpServletRequest request,CpFeemeasureItem cpFeemeasureItem, ModelMap modelMap)
	            throws Exception {
	        if(cpFeemeasureItem==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        CpFeemeasureItem cpFeemeasureItemObj=new CpFeemeasureItem();
	        if(cpFeemeasureItem.getFeemeasure_item_id()!=null){
	        	List<CpFeemeasureItem> list= cpFeemeasureService.qryCpFeemeasureItemList(cpFeemeasureItem);
	        	cpFeemeasureItemObj= list.get(0);
	        }

	        System.out.println(cpFeemeasureItem.toString());  
	        modelMap.addAttribute("paramObj", cpFeemeasureItemObj);
	        return "cpfeeplan/editCpFeemeasureItem";
	    }
	    
	    @RequestMapping("/updateCpFeemeasureItem")
	    public String updateCpFeemeasureItem(HttpServletRequest request,CpFeemeasureItem cpFeemeasureItem, ModelMap modelMap)
	            throws Exception {
	        if(cpFeemeasureItem==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        System.out.println(cpFeemeasureItem.getFeeplan_name()+"^^^^^^^^^^^^^^^^^^^^^");  
	        int id =cpFeemeasureService.updateCpFeemeasureItem(cpFeemeasureItem);
	        System.out.println(id+"  ============");
	        return "redirect:/listCpFeemeasureItem.do";
	    }
	    
	    
	    @RequestMapping("/linkMakefeeItem")
	    public String linkMakefeeItem (HttpServletRequest request,CpFeemeasureItem cpFeemeasureItem, CpMakefeeLink cpMakefeeLink , ModelMap modelMap)
	            throws Exception {
	        if(cpFeemeasureItem==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        CpFeemeasure cpFeemeasureObj=cpFeemeasureItem;
	        List<CpMakefeeItem> list = new ArrayList<CpMakefeeItem>();
	        if(cpFeemeasureItem.getFeemeasure_item_id()!=null
	        		&&!"".equals(cpFeemeasureItem.getFeemeasure_item_id())
	        		&&cpFeemeasureItem.getFeemeasure_province()!=null&&!"".equals(cpFeemeasureItem.getFeemeasure_province())){
	        	CpMakefeeItem cpMakefeeItem = new CpMakefeeItem();
	        	cpMakefeeItem.setFeecode_op(cpFeemeasureItem.getFeemeasure_op());
	        	cpMakefeeItem.setOpen_province_id(cpFeemeasureItem.getFeemeasure_province());
	        	list= cpMakefeeItemService.qryCpMakefeeItemList(cpMakefeeItem);
	        	
	        }else{
	        	CpMakefeeItem cpMakefeeItem = new CpMakefeeItem();
	        	cpMakefeeItem.setFeecode_op(cpFeemeasureItem.getFeemeasure_op());
	        	cpMakefeeItem.setOpen_province_id(99);
	        	list= cpMakefeeItemService.qryCpMakefeeItemList(cpMakefeeItem);
	        }

	        System.out.println(cpFeemeasureItem.toString()); 
	        modelMap.addAttribute("makefeeLink",cpMakefeeLink);
	        modelMap.addAttribute("paramObj", cpFeemeasureObj);
	        modelMap.addAttribute("feeItemList", list);
	        return "cpfeeplan/linkMakefeeItem";
	    }
	    
	    @RequestMapping("/saveMakefeeLink")
	    public String saveMakefeeLink(HttpServletRequest request,CpMakefeeLink cpMakefeeLink, ModelMap modelMap)
	            throws Exception {
	        if(cpMakefeeLink==null){
	        	return "err";
	        }
	        System.out.println(cpMakefeeLink.getLink_id()+"********************");
		      
	        System.out.println(cpMakefeeLink.getFeemeasure_item_id()+"===============================");
	        System.out.println(cpMakefeeLink.getMakeFeeItem().length+"---------------");
	        cpMakefeeLinkService.addCpMakefeeLink(cpMakefeeLink);
	        
	        CpFeemeasureItem cpFeemeasureItem  = new CpFeemeasureItem();
	        cpFeemeasureItem.setFeemeasure_id(cpMakefeeLink.getFeemeasure_id());
	        //cpFeemeasureItem.setFeemeasure_op(cpMakefeeLink.get);
	        modelMap.addAttribute("cpFeemeasureItem", cpFeemeasureItem);
	  
	        return "redirect:/listCpFeemeasureItem.do";
	    }
}
