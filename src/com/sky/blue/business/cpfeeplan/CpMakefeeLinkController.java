package com.sky.blue.business.cpfeeplan;

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
import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;
import com.sky.blue.business.cpfeeplan.entity.CpFeeplan;
import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;
import com.sky.blue.business.cpfeeplan.service.ICpFeemeasureService;
import com.sky.blue.business.cpfeeplan.service.ICpMakefeeLinkService;
import com.sky.blue.business.cpfeeplan.service.ICpFeeplanService;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.service.ICpMakefeeItemService;
import com.sky.blue.comm.BaseController;
@Controller
public class CpMakefeeLinkController extends BaseController {
	  @Resource(name="cpMakefeeLinkServiceImpl")
	private ICpMakefeeLinkService cpMakefeeLinkService;
	  @Resource(name="cpFeemeasureServiceImpl")
	private ICpFeemeasureService cpFeemeasureService;
		@Resource(name="cpMakefeeItemServiceImpl")
		private ICpMakefeeItemService cpMakefeeItemService;
	   @RequestMapping("/listCpMakefeeLink")
	    public String listCpMakefeeLink(HttpServletRequest request,CpMakefeeLink cpMakefeeLink, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(cpMakefeeLink==null){
	        	return "err";
	        }
	        //CpMakefeeLink gatewayInfo = new CpMakefeeLink();
	        System.out.println("============="+cpMakefeeLink.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<CpMakefeeLink> list= cpMakefeeLinkService.qryCpMakefeeLinkList(cpMakefeeLink);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            List<CpFeemeasure> cpfeemeasurelist= cpFeemeasureService.qryCpFeemeasureList(new CpFeemeasure());
	 	        modelMap.addAttribute("feemeasureList", cpfeemeasurelist);
	        } catch (Exception e) {
	        	
	        }
	        return "cpfeeplan/listMakefeeLink";
	    }
	   
	    @RequestMapping("/addCpMakefeeLink")
	    public String addCpMakefeeLink(HttpServletRequest request,CpMakefeeLink cpMakefeeLink, ModelMap modelMap)
	            throws Exception {
	        if(cpMakefeeLink==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpMakefeeLink gatewayInfo = new CpMakefeeLink();
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        cpMakefeeLink.setCreate_name(dbUser.getUserName());
	        System.out.println("cpMakefeeLink:"+cpMakefeeLink.toString());  
	        int id =cpMakefeeLinkService.addCpMakefeeLink(cpMakefeeLink);
	        System.out.println(id+"  ============");
	        return "redirect:/listCpMakefeeLink.do";
	    }
	     
	    @RequestMapping("/deleteCpMakefeeLink")
	    public void deleteCpMakefeeLink(HttpServletRequest request, HttpServletResponse response,CpMakefeeLink cpMakefeeLink,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+cpMakefeeLink.getArrayIds());
	    		int i= cpMakefeeLinkService.deleteCpMakefeeLink(cpMakefeeLink);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	   
	   
}
