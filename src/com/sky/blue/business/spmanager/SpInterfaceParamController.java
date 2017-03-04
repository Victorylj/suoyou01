package com.sky.blue.business.spmanager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.sky.blue.business.spmanager.entity.SpInterfaceParam;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.service.ISpInterfaceParamService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.comm.BaseController;
@Controller
public class SpInterfaceParamController extends BaseController {
	@Resource(name="spInterfaceParamServiceImpl")
	private ISpInterfaceParamService spInterfaceParamService;
	@Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	   @RequestMapping("/listSpInterfaceParam")
	    public String listSpInterfaceParam(HttpServletRequest request,SpInterfaceParam spInterfaceParam, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(spInterfaceParam==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+spInterfaceParam.toString());
	        List<SpCompany> spList= spCompanyService.qryCpCompanyList(new SpCompany());
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<SpInterfaceParam> list= spInterfaceParamService.qryCpInterfaceParamList(spInterfaceParam);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("spList", spList);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listSpInterfaceParam";
	    }
	   
	    @RequestMapping("/addSpInterfaceParam")
	    public String addSpInterfaceParamInfo(HttpServletRequest request,SpInterfaceParam spInterfaceParam, ModelMap modelMap)
	            throws Exception {
	        if(spInterfaceParam==null){
	        	return "err";
	        }
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        spInterfaceParam.setCreate_name(dbUser.getUserName());
	        System.out.println(spInterfaceParam.toString());  
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
			String t= dateFormat.format(Calendar.getInstance().getTime());
	        int id=-1;
	        try{
	        
	         String url = "http://"	+spInterfaceParam.getIp_port()+"/interface/sp00"+
	        		 spInterfaceParam.getSp_id()+"-"+t+".jsp";
	         	spInterfaceParam.setUrl(url);
	         	if(spInterfaceParam.getId()==null){
	         		
	         		 spInterfaceParam.setSp_tag(spInterfaceParam.getSp_id()+"-"+t);
	         	}
	         id =spInterfaceParamService.addSpInterfaceParam(spInterfaceParam);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listSpInterfaceParam.do";
	    }
	     
	    @RequestMapping("/deleteSpInterfaceParam")
	    public void deleteSpInterfaceParam(HttpServletRequest request, HttpServletResponse response,SpInterfaceParam spInterfaceParam,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+spInterfaceParam.getArrayIds());
	    		int i= spInterfaceParamService.deleteSpInterfaceParam(spInterfaceParam);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editSpInterfaceParam")
	    public String editSpInterfaceParam (HttpServletRequest request,SpInterfaceParam spInterfaceParam, ModelMap modelMap)
	            throws Exception {
	        if(spInterfaceParam==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        SpInterfaceParam spInterfaceParamObj=new SpInterfaceParam();
	        if(spInterfaceParam.getId()!=null){
	        List<SpInterfaceParam> list= spInterfaceParamService.qryCpInterfaceParamList(spInterfaceParam);
	         spInterfaceParamObj= list.get(0);
	         System.out.println(spInterfaceParamObj.getIp_str()+"  ===================== ");
	        }else{
	        List<SpCompany> list= spCompanyService.qryCpCompanyList(new SpCompany());
	        modelMap.addAttribute("spList", list);
	        }
	        System.out.println(spInterfaceParam.toString()); 
	     
	        modelMap.addAttribute("paramObj", spInterfaceParamObj);
	        return "spmanager/editSpInterfaceParam";
	    }
}
