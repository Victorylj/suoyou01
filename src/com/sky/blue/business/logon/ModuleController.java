package com.sky.blue.business.logon;

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
import com.sky.blue.business.logon.entity.Module;
import com.sky.blue.business.logon.service.IModuleService;
import com.sky.blue.comm.BaseController;
@Controller
public class ModuleController extends BaseController {
	@Resource(name="moduleServiceImpl")
	private IModuleService moduleService;

	   @RequestMapping("/listModule")
	    public String listModule(HttpServletRequest request,Module module, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(module==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+module.toString());
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<Module> list= moduleService.qryModuleList(module);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("searchObj", module);
	            modelMap.addAttribute("page", page);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "logon/listModule";
	    }
	   
	   @RequestMapping("/getModuleList")
	    public void getModuleList(HttpServletResponse response,HttpServletRequest request,Module module, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	       
	           List<Module> list= moduleService.qryModuleList(module);
	            
	           ajaxResponse(response,list);
	    }
	   
	    @RequestMapping("/addModule")
	    public String addModuleInfo(HttpServletRequest request,Module module, ModelMap modelMap)
	            throws Exception {
	        if(module==null){
	        	return "err";
	        }
	       
	        System.out.println(module.toString());  
	        int id=-1;
	        try{
	         id =moduleService.addModule(module);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listModule.do";
	    }
	     
	    @RequestMapping("/deleteModule")
	    public void deleteModule(HttpServletRequest request, HttpServletResponse response,Module module,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+module.getArrayIds());
	    		int i= moduleService.deleteModule(module);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		super.ajaxFail(response, "删除失败");
	    	}
	    }
	    @RequestMapping("/editModule")
	    public String editModule (HttpServletRequest request,Module module, ModelMap modelMap)
	            throws Exception {
	        if(module==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        Module moduleObj=new Module();
	        if(module.getModule_id()!=null){

	        	moduleObj = moduleService.getModule(module);
	         System.out.println(moduleObj.getModule_name()+"  ===================== ");
	        }  if(module.getParent_id()!=null){
	        	moduleObj = moduleService.getModule(module);
	        	if(moduleObj!=null){
	        		moduleObj.setParent_name(module.getModule_name());
	        		moduleObj.setModule_id(null);
		        	if(module.getParent_id()==1){
		        		moduleObj.setDisplay_order( 1);
		        	}else{
		        		moduleObj.setDisplay_order(moduleObj.getDisplay_order()+1);
		        	}
	        	}else{
	        		moduleObj=new Module();
		        	moduleObj.setModule_id(module.getParent_id());
		        	moduleObj = moduleService.getModule(moduleObj);
		        	moduleObj.setIs_leaf(moduleObj.getIs_leaf()+1);
		        	moduleObj.setDisplay_order(moduleObj.getDisplay_order()+1);
		        	moduleObj.setParent_id(moduleObj.getModule_id());
		        	moduleObj.setP_id(moduleObj.getModule_id());
		        	moduleObj.setModule_id(null);
	        	}
	        }else{
	       
	        List<Module> list= moduleService.qryModuleList(module);
	        modelMap.addAttribute("moduleList", list);
	        }
	        System.out.println(module.toString()); 
	     
	        modelMap.addAttribute("paramObj", moduleObj);
	        return "logon/editModule";
	    }
}
