package com.sky.blue.business.spmanager;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.spmanager.entity.SpFeecodeGroup;
import com.sky.blue.business.spmanager.service.ISpFeecodeGroupServer;
import com.sky.blue.comm.BaseController;
@Controller
public class SpFeecodeGroupController extends BaseController {
	
	@Autowired
	public ISpFeecodeGroupServer spFeecodeGroupServer;
	
	@RequestMapping("/listSpFeecodeGroup")
	public String listSpFeecodeGroup(HttpServletRequest request,SpFeecodeGroup sfg,@RequestParam(defaultValue="1")int pageId,ModelMap modelMap){	
		PageHelper.startPage(pageId, 10);
		List<SpFeecodeGroup> list = null;
		try {
			list = spFeecodeGroupServer.listSpFeecodeGroup(sfg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo page = new PageInfo(list);
        modelMap.addAttribute("page", page);
        return "spmanager/listSpFeecodeGroup";
	}
	
	@RequestMapping("/editSpFeecodeGroup")
	public String editSpFeecodeGroup(HttpServletRequest request,SpFeecodeGroup sfg){
		return "spmanager/editSpFeecodeGroup";
	}
	
	@RequestMapping("/getSpFeecodeGroup")
	public void getSpFeecodeGroup(HttpServletRequest request, HttpServletResponse response, SpFeecodeGroup sfg){
		List<SpFeecodeGroup> list = null;
		try {
			list = spFeecodeGroupServer.listSpFeecodeGroup(sfg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list!=null&&list.size()>0){
			ajaxSuccess(response, "1");
		}else{
			ajaxSuccess(response, "0");
		}
	}
	
	@RequestMapping("/addSpFeecodeGroup")
	public String addSpFeecodeGroup(HttpServletRequest request,SpFeecodeGroup sfg){
		User dbUser = (User)request.getSession().getAttribute("curUser");
		sfg.setUpdate_name(dbUser.getUserName());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sfg.setUpdate_time(sf.format(new Date()));
		if(sfg.getG_id()==null){
			sfg.setCreate_name(dbUser.getUserName());
			sfg.setCreate_time(sfg.getUpdate_time());
			try {
				spFeecodeGroupServer.addSpFeecodeGroup(sfg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			try {
				spFeecodeGroupServer.updSpFeecodeGroup(sfg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/listSpFeecodeGroup.do";
	}
	

	
	@RequestMapping("/delSpFeecodeGroup")
	public void delSpFeecodeGroup(HttpServletRequest request,HttpServletResponse response, SpFeecodeGroup sfg){
		try {
			spFeecodeGroupServer.delSpFeecodeGroup(sfg);
			super.ajaxSuccess(response, "删除成功");
		} catch (Exception e) {
			super.ajaxFail(response, "删除失败");
		}
	}
	    
}
