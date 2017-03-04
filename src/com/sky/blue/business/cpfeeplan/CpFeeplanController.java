package com.sky.blue.business.cpfeeplan;

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
import com.sky.blue.business.cpfeeplan.entity.CpFeeplan;
import com.sky.blue.business.cpfeeplan.service.ICpFeeplanService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.comm.BaseController;
@Controller
public class CpFeeplanController extends BaseController {
	  @Resource(name="cpFeeplanServiceImpl")
	private ICpFeeplanService cpFeeplanService;
	  
	   @RequestMapping("/listCpFeeplan")
	    public String listCpFeeplan(HttpServletRequest request,CpFeeplan cpFeeplan, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(cpFeeplan==null){
	        	return "err";
	        }
	        //CpFeeplan gatewayInfo = new CpFeeplan();
	        System.out.println("============="+cpFeeplan.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<CpFeeplan> list= cpFeeplanService.qryCpFeeplanList(cpFeeplan);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	        } catch (Exception e) {
	        	
	        }
	        return "cpfeeplan/listCpFeeplan";
	    }
	   
	    @RequestMapping("/addCpFeeplan")
	    public String addCpFeeplan(HttpServletRequest request,CpFeeplan cpFeeplan, ModelMap modelMap)
	            throws Exception {
	        if(cpFeeplan==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeeplan gatewayInfo = new CpFeeplan();
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        cpFeeplan.setCreate_name(dbUser.getUserName());
	        System.out.println(cpFeeplan.toString());  
	        int id =cpFeeplanService.addCpFeeplan(cpFeeplan);
	        System.out.println(id+"  ============");
	        return "redirect:/listCpFeeplan.do";
	    }
	     
	    @RequestMapping("/deleteCpFeeplan")
	    public void deleteCpFeeplan(HttpServletRequest request, HttpServletResponse response,CpFeeplan cpFeeplan,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+cpFeeplan.getArrayIds());
	    		int i= cpFeeplanService.deleteCpFeeplan(cpFeeplan);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editCpFeeplan")
	    public String editCpFeeplan (HttpServletRequest request,CpFeeplan cpFeeplan, ModelMap modelMap)
	            throws Exception {
	        if(cpFeeplan==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //CpFeeplan gatewayInfo = new CpFeeplan();
	        CpFeeplan cpFeeplanObj=new CpFeeplan();
	        if(cpFeeplan.getFeeplan_id()!=null){
	        List<CpFeeplan> list= cpFeeplanService.qryCpFeeplanList(cpFeeplan);
	         cpFeeplanObj= list.get(0);
	        }

	        System.out.println(cpFeeplan.toString());  
	        modelMap.addAttribute("paramObj", cpFeeplanObj);
	        return "cpfeeplan/editCpFeeplan";
	    }
}
