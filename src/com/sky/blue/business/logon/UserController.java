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
import com.sky.blue.business.logon.comm.ToolUtil;
import com.sky.blue.business.logon.entity.Group;
import com.sky.blue.business.logon.entity.Role;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.logon.service.IGroupService;
import com.sky.blue.business.logon.service.IRoleService;
import com.sky.blue.business.logon.service.IUserService;
import com.sky.blue.comm.BaseController;
@Controller
public class UserController extends BaseController {
	  @Resource(name="userServiceImpl")
	private IUserService userService;
		@Resource(name="roleServiceImpl")
		private IRoleService roleService;
		@Resource(name="groupServiceImpl")
		private IGroupService groupService;
	  
	   @RequestMapping("/listUser")
	    public String listUser(HttpServletRequest request,User user, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(user==null){
	        	return "err";
	        }
	        //User gatewayInfo = new User();
	        System.out.println("============="+user.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<User> list= userService.getUsers(user);
	            List<Role>  roleList = roleService.qryRoleList(new Role());
	            List<Group> groupList = groupService.qryGroupList(new Group());
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("roleList", roleList);
	            modelMap.addAttribute("groupList", groupList);
	        } catch (Exception e) {
	        	
	        }
	        return "regist/listUser";
	    }
	   
	    @RequestMapping("/addUser")
	    public String addUser(HttpServletRequest request,User user, ModelMap modelMap)
	            throws Exception {
	        if(user==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //User gatewayInfo = new User();
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        user.setCreate_name(dbUser.getUserName());
	        System.out.println(user.toString());  
	        user.setRef_roles(arrayToString(user.getRoles()));
	        user.setPassword(ToolUtil.getMD5(user.getPassword()));
	        int id =userService.register(user);;
	        System.out.println(id+"  ============");
	        return "redirect:/listUser.do";
	    }
	     
	    @RequestMapping("/deleteUser")
	    public void deleteUser(HttpServletRequest request, HttpServletResponse response,User user,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+user.getArrayIds());
	    		userService.update(user);;
	    		
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editUser")
	    public String editUser (HttpServletRequest request,User user, ModelMap modelMap)
	            throws Exception {
	        if(user==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //User gatewayInfo = new User();
	        User userObj=new User();
	        if(user.getUserId()!=null){
	        List<User> list= userService.getUsers(user);
	         userObj= list.get(0);
	        }
       
	        List<Group> groupList = groupService.qryGroupList(new Group());
	        List<Role>  roleList = roleService.qryRoleList(new Role());
	        System.out.println(user.toString());  
	        modelMap.addAttribute("paramObj", userObj);
	        modelMap.addAttribute("groupList", groupList);
	        modelMap.addAttribute("roleList", roleList);
	        return "regist/editUser";
	    }
	    
	    
	    @RequestMapping("/updateUsePwd")
		public void updateUserPwd(HttpServletRequest request, HttpServletResponse response, String oldPwd, String newPwd) {
			// 获取当前登陆用户
			User curuser = (User) request.getSession().getAttribute("curUser");
			oldPwd=ToolUtil.getMD5(oldPwd);
			// 判断旧密码是否正确
			if (curuser.getPassword().equals(oldPwd)) {
				// 正确
				newPwd=ToolUtil.getMD5(newPwd);
				curuser.setPassword(newPwd);
				// 判断是CP用户还是其他用户
				
					// 其他
					try {
						userService.update(curuser);
						super.ajaxSuccess(response, "密码修改成功,请重新登录");
					} catch (Exception e) {
						e.printStackTrace();
						super.ajaxFail(response, "修改密码失败!");
					}
				
			} else {
				// 错误
				super.ajaxFail(response, "密码错误!");
			}
		}
	    
	    
}
