package com.sky.blue.business.cpmanager;

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
import com.sky.blue.business.cpmanager.entity.ChannelManager;
import com.sky.blue.business.cpmanager.service.IChannelManagerService;
import com.sky.blue.comm.BaseController;
@Controller
public class ChannelManagerController extends BaseController {
	  @Resource(name="channelManagerServiceImpl")
	private IChannelManagerService channelManagerService;

	   @RequestMapping("/listChannelManager")
	    public String listChannelManager(HttpServletRequest request,ChannelManager channelManager, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(channelManager==null){
	        	return "err";
	        }
	        //ChannelManager gatewayInfo = new ChannelManager();
	        System.out.println("============="+channelManager.toString());
	       
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<ChannelManager> list= channelManagerService.qryChannelManagerList(channelManager);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);

	            
	        } catch (Exception e) {
	        	
	        }
	        return "cpmanager/listChannelManager";
	    }
	   
	    @RequestMapping("/addChannelManager")
	    public String addChannelManager(HttpServletRequest request,ChannelManager channelManager, ModelMap modelMap)
	            throws Exception {
	        if(channelManager==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //ChannelManager gatewayInfo = new ChannelManager();
	        System.out.println(channelManager.toString());  
	        int id =channelManagerService.addChannelManager(channelManager);
	        System.out.println(id+"  ============");
	        return "redirect:/listChannelManager.do";
	    }
	     
	    @RequestMapping("/deleteChannelManager")
	    public void deleteChannelManager(HttpServletRequest request, HttpServletResponse response,ChannelManager channelManager,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+channelManager.getArrayIds());
	    		int i= channelManagerService.deleteChannelManager(channelManager);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editChannelManager")
	    public String editChannelManager (HttpServletRequest request,ChannelManager channelManager, ModelMap modelMap)
	            throws Exception {
	        if(channelManager==null){
	        	return "err";
	        }
	     
	        ChannelManager channelManagerObj=new ChannelManager();
	        if(channelManager.getM_id()!=null){
	        List<ChannelManager> list= channelManagerService.qryChannelManagerList(channelManager);
	         channelManagerObj= list.get(0);
	        }
	        System.out.println(channelManager.toString());  
	        modelMap.addAttribute("paramObj", channelManagerObj);

	        return "cpmanager/editChannelManager";
	    }
}
