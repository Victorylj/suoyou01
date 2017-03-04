package com.sky.blue.business.cpmanager;

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
import com.sky.blue.business.cpmanager.entity.Channel;
import com.sky.blue.business.cpmanager.entity.ChannelManager;
import com.sky.blue.business.cpmanager.entity.ChannelProduct;
import com.sky.blue.business.cpmanager.entity.CpProduct;
import com.sky.blue.business.cpmanager.service.IChannelManagerService;
import com.sky.blue.business.cpmanager.service.IChannelService;
import com.sky.blue.business.cpmanager.service.ICpProductService;
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.comm.BaseController;
import com.sky.blue.comm.json.JsonUtil;
@Controller
public class ChannelController extends BaseController {
	  @Resource(name="channelServiceImpl")
	private IChannelService channelService;
	  @Resource(name="cpProductServiceImpl")
		private ICpProductService cpProductService;
	  @Resource(name="channelManagerServiceImpl")
	private IChannelManagerService channelManagerService;
	   @RequestMapping("/listChannel")
	    public String listChannel(HttpServletRequest request,Channel channel, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(channel==null){
	        	return "err";
	        }
	        //Channel gatewayInfo = new Channel();
	        System.out.println("============="+channel.toString());
	        
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<Channel> list= channelService.qryChannelList(channel);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            List<ChannelManager> mList=channelManagerService.qryChannelManagerList(new ChannelManager());
	            modelMap.addAttribute("mList", mList);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return "cpmanager/listChannel";
	    }
	   
	    @RequestMapping("/addChannel")
	    public String addChannel(HttpServletRequest request,Channel channel, ModelMap modelMap)
	            throws Exception {
	        if(channel==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //Channel gatewayInfo = new Channel();
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        channel.setCreate_name(dbUser.getUserName());
	        System.out.println(channel.toString());  
	        int id =channelService.addChannel(channel);
	        request.getSession().removeAttribute("sccList");
	        System.out.println(id+"  ============");
	        return "redirect:/listChannel.do";
	    }
	     
	    @RequestMapping("/updateChannelName")
	    public void updateChannelName(HttpServletRequest request,HttpServletResponse response,String userName ,Integer userId, ModelMap modelMap)
	            throws Exception {
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        Channel channel = new Channel();
	        channel.setCh_id(userId);
	        channel.setCh_name(userName); 
	        channel.setM_id(7);
	        System.out.println(userId+"$$$$$$$$$$$$$$$$$$$$"+userName);
	        if(userId!=null&&!"".equals(userId)){
		        int id =channelService.addChannel(channel);
		        //System.out.println(id+"  ============");
		        response.getWriter().write("ok");
	        }else{
	        	  response.getWriter().write("false");
	        }
	    }
	    
	    @RequestMapping("/deleteChannel")
	    public void deleteChannel(HttpServletRequest request, HttpServletResponse response,Channel channel,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+channel.getArrayIds());
	    		int i= channelService.deleteChannel(channel);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    
	    @RequestMapping("/linkProduct")
	    public String linkProduct(HttpServletRequest request, HttpServletResponse response,
	    		ChannelProduct channelProduct,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+channelProduct.getArrayIds());
	    		List<CpProduct> list = new ArrayList<CpProduct>();
	    		List<CpProduct> prodList= cpProductService.qryCpProductList(new CpProduct());
	    		List<ChannelProduct> linkList=channelService.qryChannelProductList(channelProduct);
	    		for(CpProduct prod:prodList){
	    			for(ChannelProduct cprod:linkList){
	    				if(cprod.getProduct_id()==prod.getProduct_id()){
	    					continue;
	    				}
	    				list.add(prod);
	    			}
	    		}
	    	 	modelMap.addAttribute("paramObj", channelProduct);
	    	 	modelMap.addAttribute("prodList", prodList);
	    		System.out.println("=========");
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	      return "cpmanager/linkToProduct";
	    }
	    
	    @RequestMapping("/listChannelProduct")
	    public String listChannelProduct(HttpServletRequest request,ChannelProduct channelProduct, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(channelProduct==null){
	        	return "err";
	        }
	        //Channel gatewayInfo = new Channel();
	        System.out.println("============="+channelProduct.toString());
	        
	        try {
	        	List<Channel> chlist= channelService.qryChannelList(new Channel());
	        	List<CpProduct> plist= cpProductService.qryCpProductList(new CpProduct());
	            PageHelper.startPage(pageId, 10);
	            List<ChannelProduct> list= channelService.qryChannelProductList(channelProduct);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("chList", chlist);
	            modelMap.addAttribute("prodList", plist);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return "cpmanager/listChannelProduct";
	    }
	    
	    @RequestMapping("/deleteChannelProduct")
	    public void deleteChannelProduct(HttpServletRequest request, HttpServletResponse response,ChannelProduct channelProduct,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+channelProduct.getArrayIds());
	    		int i= channelService.deleteChannelProduct(channelProduct);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    
	    @RequestMapping("/addLinkToProduct")
	    public String addLinkToProduct(HttpServletRequest request,
	    		ChannelProduct channelProduct, ModelMap modelMap)
	            throws Exception {
	        if(channelProduct==null){
	        	return "err";
	        }
	        if(channelProduct.getProduct_id()==null||channelProduct.getCh_id()==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //Channel gatewayInfo = new Channel();
	        System.out.println(channelProduct.toString());  
	        
	        int id =channelService.addChannelProduct(channelProduct);
	        System.out.println(id+"  ============");
	        return "redirect:/listChannelProduct.do";
	    }
	     
	    
	    @RequestMapping("/editChannel")
	    public String editChannel (HttpServletRequest request,Channel channel, ModelMap modelMap)
	            throws Exception {
	        if(channel==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //Channel gatewayInfo = new Channel();
	        Channel channelObj=new Channel();
	        if(channel.getCh_id()!=null){
	        List<Channel> list= channelService.qryChannelList(channel);
	         channelObj= list.get(0);
	        }
	        List<ChannelManager> mList=channelManagerService.qryChannelManagerList(new ChannelManager());
            modelMap.addAttribute("mList", mList);
	        System.out.println(channel.toString());  
	        modelMap.addAttribute("paramObj", channelObj);
	        return "cpmanager/editChannel";
	    }
}
