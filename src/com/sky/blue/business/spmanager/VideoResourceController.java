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
import com.sky.blue.business.spmanager.entity.VideoResource;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.service.IVideoResourceService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
import com.sky.blue.comm.BaseController;
@Controller
public class VideoResourceController extends BaseController {
	@Resource(name="videoResourceServiceImpl")
	private IVideoResourceService videoResourceService;
	@Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	@Resource(name="spFeecodeServiceImpl")
	private ISpFeecodeService spFeecodeService;
	   @RequestMapping("/listVideoResource")
	    public String listVideoResource(HttpServletRequest request,VideoResource videoResource, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(videoResource==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+videoResource.toString());
	         List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<VideoResource> list= videoResourceService.qryCpCommandList(videoResource);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("companyList", companyList);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listVideoResource";
	    }
	   
	    @RequestMapping("/addVideoResource")
	    public String addVideoResourceInfo(HttpServletRequest request,VideoResource videoResource, ModelMap modelMap)
	            throws Exception {
	        if(videoResource==null){
	        	return "err";
	        }
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        videoResource.setCreate_name(dbUser.getUserName());
	        System.out.println(videoResource.toString());  
	        int id=-1;
	        try{
	         id =videoResourceService.addVideoResource(videoResource);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listVideoResource.do";
	    }
	     
	    @RequestMapping("/deleteVideoResource")
	    public void deleteVideoResource(HttpServletRequest request, HttpServletResponse response,VideoResource videoResource,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+videoResource.getArrayIds());
	    		int i= videoResourceService.deleteVideoResource(videoResource);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editVideoResource")
	    public String editVideoResource (HttpServletRequest request,VideoResource videoResource, ModelMap modelMap)
	            throws Exception {
	        if(videoResource==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        VideoResource videoResourceObj=new VideoResource();
	        if(videoResource.getId()!=null){
	        List<VideoResource> list= videoResourceService.qryCpCommandList(videoResource);
	         videoResourceObj= list.get(0);
	         System.out.println(videoResourceObj.getId()+"  ===================== ");
	        }else{
	        	  List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
	        modelMap.addAttribute("feecodeList", feecodeList);
	        }
	        System.out.println(videoResource.toString()); 
	     
	        modelMap.addAttribute("paramObj", videoResourceObj);
	        return "spmanager/editVideoResource";
	    }
}
