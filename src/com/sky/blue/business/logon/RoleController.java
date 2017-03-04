package com.sky.blue.business.logon;

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
import com.sky.blue.business.logon.entity.Module;
import com.sky.blue.business.logon.entity.Role;
import com.sky.blue.business.logon.service.IModuleService;
import com.sky.blue.business.logon.service.IRoleService;
import com.sky.blue.comm.BaseController;
@Controller
public class RoleController extends BaseController {
	@Resource(name="roleServiceImpl")
	private IRoleService roleService;
	@Resource(name="moduleServiceImpl")
	private IModuleService moduleService;

	   @RequestMapping("/listRole")
	    public String listRole(HttpServletRequest request,Role role, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(role==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+role.toString());
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<Role> list= roleService.qryRoleList(role);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("searchObj", role);
	            modelMap.addAttribute("page", page);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "logon/listRole";
	    }
	   
	   @RequestMapping("/getRoleList")
	    public void getRoleList(HttpServletResponse response,HttpServletRequest request,Role role, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	       
	           List<Role> list= roleService.qryRoleList(role);
	            
	           ajaxResponse(response,list);
	    }
	   
	    @RequestMapping("/addRole")
	    public String addRoleInfo(HttpServletRequest request,Role role, ModelMap modelMap)
	            throws Exception {
	        if(role==null){
	        	return "err";
	        }
	       
	        System.out.println(role.toString());  
	        int id=-1;
	        try{
	        	role.setRef_modules(arrayToString(role.getModules()));
	         id =roleService.addRole(role);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listRole.do";
	    }
	     
	    @RequestMapping("/deleteRole")
	    public void deleteRole(HttpServletRequest request, HttpServletResponse response,Role role,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+role.getArrayIds());
	    		int i= roleService.deleteRole(role);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    }
	    @RequestMapping("/editRole")
	    public String editRole (HttpServletRequest request,Role role, ModelMap modelMap)
	            throws Exception {
	        if(role==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        List<Module> moduleList=moduleService.qryModuleList(new Module());
	        Role roleObj=new Role();
	        if(role.getRole_id()!=null){
	        List<Role> list= roleService.qryRoleList(role);
	         roleObj= list.get(0);
	         System.out.println(roleObj.getRole_name()+"  ===================== ");
	        }else{
	        List<Role> list= roleService.qryRoleList(role);
	        modelMap.addAttribute("roleList", list);
	        }
	        System.out.println(role.toString()); 
	        modelMap.addAttribute("moduleList", moduleList);
	        modelMap.addAttribute("paramObj", roleObj);
	        return "logon/editRole";
	    }
	    @RequestMapping("/getChoosedModuleList")
	    public void getModuleList(HttpServletResponse response,Module module){
	    	ArrayList<Module> list = new ArrayList<Module>();
	    	System.out.println(module.toString());

	    	getModule(module,list);

	    	System.out.println(list.size());
	    	ajaxResponse(response,list);
	    }
	    
	    public void getModule(Module module,ArrayList<Module> list){
	    	if(module!=null){
	    		if(module.getParent_id()!=null){
	    			Module md = new Module();
	    			md.setModule_id(module.getParent_id());
	    			try {
						List<Module> modL = moduleService.qryModuleList(md);
						if(modL!=null){
							if(modL.size()>0){
								list.add(modL.get(0));
								getModule(modL.get(0),list);
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    	}
	    }
}
