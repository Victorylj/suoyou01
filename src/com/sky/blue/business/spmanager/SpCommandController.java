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
import com.sky.blue.business.spmanager.entity.SpCommand;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.service.ISpCommandService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
import com.sky.blue.comm.BaseController;
@Controller
public class SpCommandController extends BaseController {
	@Resource(name="spCommandServiceImpl")
	private ISpCommandService spCommandService;
	@Resource(name="spFeecodeServiceImpl")
	private ISpFeecodeService spFeecodeService;
	@Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	   @RequestMapping("/listSpCommand")
	    public String listSpCommand(HttpServletRequest request,SpCommand spCommand, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(spCommand==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+spCommand.toString());
	        List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<SpCommand> list= spCommandService.qryCpCommandList(spCommand);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	           
	            List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
	            modelMap.addAttribute("companyList", companyList);
	            modelMap.addAttribute("searchObj", spCommand);
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("feecodeList", feecodeList);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listSpCommand";
	    }
	   
	   @RequestMapping("/getSpCommandList")
	    public void getSpCommandList(HttpServletResponse response,HttpServletRequest request,SpCommand spCommand, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	       
	            List<SpCommand> list= spCommandService.qryCpCommandList(spCommand);
	            ajaxResponse(response,list);
	        
	    }
	   
	    @RequestMapping("/addSpCommand")
	    public String addSpCommandInfo(HttpServletRequest request,SpCommand spCommand, ModelMap modelMap)
	            throws Exception {
	        if(spCommand==null){
	        	return "err";
	        }
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        spCommand.setCreate_name(dbUser.getUserName());
	        System.out.println(spCommand.toString());  
	        int id=-1;
	        try{
	         id =spCommandService.addSpCommand(spCommand);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listSpCommand.do";
	    }
	     
	    @RequestMapping("/closeOrOpenSpCommand")
	    public void closeOrOpenSpCommand(HttpServletRequest request, HttpServletResponse response,SpCommand spCommand,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+spCommand.toString());
	    		int i= spCommandService.closeOrOpenSpCommand(spCommand);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "操作成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "操作失败");
	    	}
	    	
	      
	    }
	    
	    @RequestMapping("/updspcps")
	    public void updSpCommandPositiveStatu(HttpServletRequest request, HttpServletResponse response,SpCommand spCommand,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		int i= spCommandService.updSpCommandPositiveStatu(spCommand);
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "操作成功");
	    	}catch(Exception e){
	    		super.ajaxFail(response, "操作失败");
	    	}
	    }
	    
	    @RequestMapping("/editSpCommand")
	    public String editSpCommand (HttpServletRequest request,SpCommand spCommand, ModelMap modelMap)
	            throws Exception {
	        if(spCommand==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        SpCommand spCommandObj=new SpCommand();
	        if(spCommand.getCommand_id()!=null){
	        List<SpCommand> list= spCommandService.qryCpCommandList(spCommand);
	         spCommandObj= list.get(0);
	         System.out.println(spCommandObj.getCommand()+"  ===================== ");
	        }else{
	        	  List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
	        modelMap.addAttribute("feecodeList", feecodeList);
	        }
	        System.out.println(spCommand.toString()); 
	     
	        modelMap.addAttribute("paramObj", spCommandObj);
	        return "spmanager/editSpCommand";
	    }
}
