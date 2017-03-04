package com.sky.blue.business.cpmanager;

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
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.comm.BaseController;
@Controller
public class CpCompanyController extends BaseController {
	  @Resource(name="cpCompanyServiceImpl")
	private ICpCompanyService cpCompanyService;
	  
	   @RequestMapping("/listCpCompany")
	    public String listCpCompany(HttpServletRequest request,CpCompany cpCompany, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(cpCompany==null){
	        	return "err";
	        }
	        //CpCompany gatewayInfo = new CpCompany();
	        System.out.println("============="+cpCompany.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<CpCompany> list= cpCompanyService.qryCpCompanyList(cpCompany);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	        } catch (Exception e) {
	        	
	        }
	        return "cpmanager/listCpCompany";
	    }
	   
	    @RequestMapping("/addCpCompany")
	    public String addCpCompany(HttpServletRequest request,CpCompany cpCompany, ModelMap modelMap)
	            throws Exception {
	        if(cpCompany==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpCompany gatewayInfo = new CpCompany();
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        cpCompany.setCreate_name(dbUser.getUserName());
	        System.out.println(cpCompany.toString());  
	        int id =cpCompanyService.addCpCompany(cpCompany);
	        System.out.println(id+"  ============");
	        return "redirect:/listCpCompany.do";
	    }
	     
	    @RequestMapping("/deleteCpCompany")
	    public void deleteCpCompany(HttpServletRequest request, HttpServletResponse response,CpCompany cpCompany,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+cpCompany.getArrayIds());
	    		int i= cpCompanyService.deleteCpCompany(cpCompany);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editCpCompany")
	    public String editCpCompany (HttpServletRequest request,CpCompany cpCompany, ModelMap modelMap)
	            throws Exception {
	        if(cpCompany==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpCompany gatewayInfo = new CpCompany();
	        CpCompany cpCompanyObj=new CpCompany();
	        if(cpCompany.getCp_id()!=null){
	        List<CpCompany> list= cpCompanyService.qryCpCompanyList(cpCompany);
	         cpCompanyObj= list.get(0);
	        }

	        System.out.println(cpCompany.toString());  
	        modelMap.addAttribute("paramObj", cpCompanyObj);
	        return "cpmanager/editCpCompany";
	    }
}
