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
import com.sky.blue.business.logon.entity.Group;
import com.sky.blue.business.logon.service.IGroupService;
import com.sky.blue.comm.BaseController;
@Controller
public class GroupController extends BaseController {
	@Resource(name="groupServiceImpl")
	private IGroupService groupService;

	   @RequestMapping("/listGroup")
	    public String listGroup(HttpServletRequest request,Group group, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(group==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+group.toString());
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<Group> list= groupService.qryGroupList(group);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("searchObj", group);
	            modelMap.addAttribute("page", page);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "logon/listGroup";
	    }
	   
	   @RequestMapping("/getGroupList")
	    public void getGroupList(HttpServletResponse response,HttpServletRequest request,Group group, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	       
	           List<Group> list= groupService.qryGroupList(group);
	            
	           ajaxResponse(response,list);
	    }
	   
	    @RequestMapping("/addGroup")
	    public String addGroupInfo(HttpServletRequest request,Group group, ModelMap modelMap)
	            throws Exception {
	        if(group==null){
	        	return "err";
	        }
	       
	        System.out.println(group.toString());  
	        int id=-1;
	        try{
	         id =groupService.addGroup(group);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listGroup.do";
	    }
	     
	    @RequestMapping("/deleteGroup")
	    public void deleteGroup(HttpServletRequest request, HttpServletResponse response,Group group,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+group.getArrayIds());
	    		int i= groupService.deleteGroup(group);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    }
	    @RequestMapping("/editGroup")
	    public String editGroup (HttpServletRequest request,Group group, ModelMap modelMap)
	            throws Exception {
	        if(group==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        Group groupObj=new Group();
	        if(group.getGroup_id()!=null){
	        List<Group> list= groupService.qryGroupList(group);
	         groupObj= list.get(0);
	         System.out.println(groupObj.getGroup_name()+"  ===================== ");
	        }else{
	        List<Group> list= groupService.qryGroupList(group);
	        modelMap.addAttribute("groupList", list);
	        }
	        System.out.println(group.toString()); 
	     
	        modelMap.addAttribute("paramObj", groupObj);
	        return "logon/editGroup";
	    }
}
