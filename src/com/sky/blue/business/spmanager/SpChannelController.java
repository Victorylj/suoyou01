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
import com.sky.blue.business.spmanager.entity.SpChannel;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.service.ISpChannelService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.comm.BaseController;
@Controller
public class SpChannelController extends BaseController {
	@Resource(name="spChannelServiceImpl")
	private ISpChannelService spChannelService;
	@Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	   @RequestMapping("/listSpChannel")
	    public String listSpChannel(HttpServletRequest request,SpChannel spChannel, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(spChannel==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+spChannel.toString());
	        List<SpCompany> spList= spCompanyService.qryCpCompanyList(new SpCompany());
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<SpChannel> list= spChannelService.qryCpChannelList(spChannel);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("spList", spList);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listSpChannel";
	    }
	   
	    @RequestMapping("/addSpChannel")
	    public String addSpChannelInfo(HttpServletRequest request,SpChannel spChannel, ModelMap modelMap)
	            throws Exception {
	        if(spChannel==null){
	        	return "err";
	        }
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        spChannel.setCreate_name(dbUser.getUserName());
	        System.out.println(spChannel.toString());  
	        int id=-1;
	        try{
	         id =spChannelService.addSpChannel(spChannel);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listSpChannel.do";
	    }
	     
	    @RequestMapping("/deleteSpChannel")
	    public void deleteSpChannel(HttpServletRequest request, HttpServletResponse response,SpChannel spChannel,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+spChannel.getArrayIds());
	    		int i= spChannelService.deleteSpChannel(spChannel);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editSpChannel")
	    public String editSpChannel (HttpServletRequest request,SpChannel spChannel, ModelMap modelMap)
	            throws Exception {
	        if(spChannel==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        SpChannel spChannelObj=new SpChannel();
	        if(spChannel.getSp_channel_id()!=null){
	        List<SpChannel> list= spChannelService.qryCpChannelList(spChannel);
	         spChannelObj= list.get(0);
	         System.out.println(spChannelObj.getSp_name()+"  ===================== ");
	        }else{
	        List<SpCompany> list= spCompanyService.qryCpCompanyList(new SpCompany());
	        modelMap.addAttribute("spList", list);
	        }
	        System.out.println(spChannel.toString()); 
	     
	        modelMap.addAttribute("paramObj", spChannelObj);
	        return "spmanager/editSpChannel";
	    }
}
