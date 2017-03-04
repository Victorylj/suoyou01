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
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.comm.BaseController;
@Controller
public class SpCompanyController extends BaseController {
	  @Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	  
	   @RequestMapping("/listSpCompany")
	    public String listGatewayInfo(HttpServletRequest request,SpCompany spCompany, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(spCompany==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+spCompany.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<SpCompany> list= spCompanyService.qryCpCompanyList(spCompany);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	        } catch (Exception e) {
	        	
	        }
	        return "spmanager/listSpCompany";
	    }
	   
	    @RequestMapping("/addSpCompany")
	    public String addGatewayInfo(HttpServletRequest request,SpCompany spCompany, ModelMap modelMap)
	            throws Exception {
	        if(spCompany==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        spCompany.setCreate_name(dbUser.getUserName());
	        System.out.println(spCompany.toString());  
	        request.getSession().removeAttribute("sssList");
	        int id =spCompanyService.addSpCompany(spCompany);
	        System.out.println(id+"  ============");
	        return "redirect:/listSpCompany.do";
	    }
	     
	    @RequestMapping("/deleteSpCompany")
	    public void deleteSpCompany(HttpServletRequest request, HttpServletResponse response,SpCompany spCompany,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+spCompany.getArrayIds());
	    		int i= spCompanyService.deleteSpCompany(spCompany);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editSpCompany")
	    public String editSpCompany (HttpServletRequest request,SpCompany spCompany, ModelMap modelMap)
	            throws Exception {
	        if(spCompany==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        
	        SpCompany spCompanyObj= null;
	        if(spCompany.getSp_id()!=null){
	        	List<SpCompany> list= spCompanyService.qryCpCompanyList(spCompany);
	        	spCompanyObj= list.get(0);
	        }
	        System.out.println(spCompany.toString());  
	        modelMap.addAttribute("paramObj", spCompanyObj);
	        return "spmanager/editSpCompany";
	    }
}
