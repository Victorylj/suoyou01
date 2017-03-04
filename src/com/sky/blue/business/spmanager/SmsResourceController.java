package com.sky.blue.business.spmanager;

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
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.spmanager.entity.SmsResource;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.service.ISmsResourceService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
import com.sky.blue.comm.BaseController;
@Controller
public class SmsResourceController extends BaseController {
	@Resource(name="smsResourceServiceImpl")
	private ISmsResourceService smsResourceService;
	@Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	@Resource(name="spFeecodeServiceImpl")
	private ISpFeecodeService spFeecodeService;
	   @RequestMapping("/listSmsResource")
	    public String listSmsResource(HttpServletRequest request,SmsResource smsResource, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(smsResource==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+smsResource.toString());
	         List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<SmsResource> list= smsResourceService.qryCpCommandList(smsResource);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("companyList", companyList);
	            modelMap.addAttribute("searchObj", smsResource);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listSmsResource";
	    }
	   
	    @RequestMapping("/addSmsResource")
	    public String addSmsResourceInfo(HttpServletRequest request,SmsResource smsResource, ModelMap modelMap)
	            throws Exception {
	        if(smsResource==null){
	        	return "err";
	        }
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        smsResource.setCreate_name(dbUser.getUserName());
	        System.out.println(smsResource.toString());  
	        int id=-1;
	        try{
	         id =smsResourceService.addSmsResource(smsResource);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listSmsResource.do";
	    }
	     
	    @RequestMapping("/deleteSmsResource")
	    public void deleteSmsResource(HttpServletRequest request, HttpServletResponse response,SmsResource smsResource,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+smsResource.getArrayIds());
	    		int i= smsResourceService.deleteSmsResource(smsResource);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editSmsResource")
	    public String editSmsResource (HttpServletRequest request,SmsResource smsResource, ModelMap modelMap)
	            throws Exception {
	        if(smsResource==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        SmsResource smsResourceObj=new SmsResource();
	        if(smsResource.getId()!=null){
	        List<SmsResource> list= smsResourceService.qryCpCommandList(smsResource);
	         smsResourceObj= list.get(0);
	         System.out.println(smsResourceObj.getId()+"  ===================== ");
	        }else{
	        	  List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
	        modelMap.addAttribute("feecodeList", feecodeList);
	        }
	        System.out.println(smsResource.toString()); 
	     
	        modelMap.addAttribute("paramObj", smsResourceObj);
	        return "spmanager/editSmsResource";
	    }
}
