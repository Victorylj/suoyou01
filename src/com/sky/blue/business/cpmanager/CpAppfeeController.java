package com.sky.blue.business.cpmanager;

import java.util.ArrayList;
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
import com.sky.blue.business.cpfeeplan.entity.CpFeeplan;
import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;
import com.sky.blue.business.cpfeeplan.service.ICpFeemeasureService;
import com.sky.blue.business.cpfeeplan.service.ICpFeeplanService;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.entity.CpAppfee;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.business.cpmanager.entity.FeepointLink;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
import com.sky.blue.business.cpmanager.service.ICpAppfeeService;
import com.sky.blue.business.cpmanager.service.ICpProductService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.comm.BaseController;
@Controller
public class CpAppfeeController extends BaseController {
	  @Resource(name="cpAppfeeServiceImpl")
	private ICpAppfeeService cpAppfeeService;
	  @Resource(name="cpProductServiceImpl")
	private ICpProductService cpProductService;
	  
	  @Resource(name="cpFeemeasureServiceImpl")
	private ICpFeemeasureService cpFeemeasureService;
	  
	  @Resource(name="cpFeeplanServiceImpl")
	private ICpFeeplanService cpFeeplanService;
	  
	   @RequestMapping("/listCpAppfee")
	    public String listCpAppfee(HttpServletRequest request,CpAppfee cpAppfee, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(cpAppfee==null){
	        	return "err";
	        }
	        //CpAppfee gatewayInfo = new CpAppfee();
	        System.out.println("============="+cpAppfee.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<CpAppfee> list= cpAppfeeService.qryCpAppfeeList(cpAppfee);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            List<CpProduct> productlist= cpProductService.qryCpProductList(new CpProduct());
	 	        modelMap.addAttribute("productList", productlist);
	 	        modelMap.addAttribute("searchObj", cpAppfee);
	        } catch (Exception e) {
	        	
	        }
	        return "cpmanager/listCpAppfee";
	    }
	   
	    @RequestMapping("/addCpAppfee")
	    public String addCpAppfee(HttpServletRequest request,CpAppfee cpAppfee, ModelMap modelMap)
	            throws Exception {
	        if(cpAppfee==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpAppfee gatewayInfo = new CpAppfee();
	        System.out.println(cpAppfee.toString());
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        cpAppfee.setCreate_name(dbUser.getUserName());
	        int id =cpAppfeeService.addCpAppfee(cpAppfee);
	        System.out.println(id+"  ============");
	        return "redirect:/listCpAppfee.do";
	    }
	     
	    @RequestMapping("/deleteCpAppfee")
	    public void deleteCpAppfee(HttpServletRequest request, HttpServletResponse response,CpAppfee cpAppfee,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+cpAppfee.getArrayIds());
	    		int i= cpAppfeeService.deleteCpAppfee(cpAppfee);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editCpAppfee")
	    public String editCpAppfee (HttpServletRequest request,CpAppfee cpAppfee, ModelMap modelMap)
	            throws Exception {
	        if(cpAppfee==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpAppfee gatewayInfo = new CpAppfee();
	        CpAppfee cpAppfeeObj=new CpAppfee();
	        if(cpAppfee.getAppfee_id()!=null){
	        	List<CpAppfee> list= cpAppfeeService.qryCpAppfeeList(cpAppfee);
	         cpAppfeeObj= list.get(0);
	        }else{
	        	 List<CpProduct> productlist= cpProductService.qryCpProductList(new CpProduct());
		 	        modelMap.addAttribute("productList", productlist);
	        }

	        System.out.println(cpAppfee.toString());  
	        modelMap.addAttribute("paramObj", cpAppfeeObj);
	        return "cpmanager/editCpAppfee";
	    }
	    
	    @RequestMapping("/feepointLinkToFeeplan")
	    public String feepointLinkToFeeplan(HttpServletRequest request,CpAppfee cpAppfee,  ModelMap modelMap)
	            throws Exception {
	        if(cpAppfee==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        CpAppfee cpAppfeeObj=cpAppfee;
	        List<CpFeeplan> list = new ArrayList<CpFeeplan>();
	        if(cpAppfee.getAppfee_id()!=null&&cpAppfee.getAppfee_fee()!=null){
	        	CpFeeplan cpFeeplan = new CpFeeplan();
	        	cpFeeplan.setFeeplan_fee(cpAppfee.getAppfee_fee());
	        	list= cpFeeplanService.qryCpFeeplanList(cpFeeplan);
	        	
	        }

	        System.out.println(cpAppfee.toString()); 

	        modelMap.addAttribute("paramObj", cpAppfeeObj);
	        modelMap.addAttribute("cpFeeplanList", list);
	        return "cpmanager/linkToFeeplan";
	    }
	    
	    
	    @RequestMapping("/feepointLinkToFeemeasure")
	    public String feepointLinkToFeemeasure(HttpServletRequest request,CpAppfee cpAppfee,  ModelMap modelMap)
	            throws Exception {
	        if(cpAppfee==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeemeasure gatewayInfo = new CpFeemeasure();
	        CpAppfee cpAppfeeObj=cpAppfee;
	        List<CpFeemeasure> list = new ArrayList<CpFeemeasure>();
	        if(cpAppfee.getAppfee_id()!=null&&cpAppfee.getAppfee_fee()!=null){
	        	CpFeemeasure cpFeemeasure = new CpFeemeasure();
	        	cpFeemeasure.setFeemeasure_fee(cpAppfee.getAppfee_fee());
	        	list= cpFeemeasureService.qryCpFeemeasureList(cpFeemeasure);
	        	
	        }

	        System.out.println(cpAppfee.toString()); 

	        modelMap.addAttribute("paramObj", cpAppfeeObj);
	        modelMap.addAttribute("cpFeemeasureList", list);
	        return "cpmanager/linkToFeemeasure";
	    }
	    
	    @RequestMapping("/saveFeepointPlan")
	    public String saveFeepointPlan(HttpServletRequest request,FeepointLink feepointLink, ModelMap modelMap)
	            throws Exception {
	        if(feepointLink==null){
	        	return "err";
	        }
	        System.out.println(feepointLink+"---------------");
	        cpAppfeeService.addFeepointLink(feepointLink);
	        
	        return "redirect:/listCpAppfee.do";
	    }
	    
	    @RequestMapping("/listFeepointPlan")
	    public String listFeepointPlan(HttpServletRequest request,FeepointLink feepointLink, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(feepointLink==null){
	        	return "err";
	        }
	        //CpAppfee gatewayInfo = new CpAppfee();
	        System.out.println("============="+feepointLink.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<FeepointLink> list= cpAppfeeService.qryFeepointLinkList(feepointLink);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            List<CpAppfee> appFeelist= cpAppfeeService.qryCpAppfeeList(new CpAppfee());
	 	        modelMap.addAttribute("appfeeList", appFeelist);
	        } catch (Exception e) {
	        	
	        }
	        return "cpmanager/listFeepointPlan";
	    }
}
