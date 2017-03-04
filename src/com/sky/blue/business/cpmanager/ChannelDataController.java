package com.sky.blue.business.cpmanager;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.sky.blue.business.cpmanager.entity.ChannelData;
import com.sky.blue.business.cpmanager.entity.CpCompany;
import com.sky.blue.business.cpmanager.service.IChannelDataService;
import com.sky.blue.business.cpmanager.service.IChannelService;
import com.sky.blue.business.cpmanager.service.ICpCompanyService;
import com.sky.blue.comm.BaseController;
@Controller
public class ChannelDataController extends BaseController {
	  @Resource(name="channelDataServiceImpl")
	private IChannelDataService channelDataService;
	  @Resource(name="channelServiceImpl")
	private IChannelService channelService;
	   @RequestMapping("/listChannelData")
	    public String listChannelData(HttpServletRequest request,ChannelData channelData, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(channelData==null){
	        	return "err";
	        }
	        //ChannelData gatewayInfo = new ChannelData();
	        System.out.println("============="+channelData.toString());
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String dater=sf.format(new Date());
	        if(channelData.getStart_time()==null||channelData.getEnd_time()==null){
	        	channelData.setDater(dater);
	        }
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<ChannelData> list= channelDataService.qryChannelDataList(channelData);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	           List<Channel> chList= channelService.qryChannelList(new Channel());
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("chList", chList);
	            modelMap.addAttribute("searchObj", channelData);
	        } catch (Exception e) {
	        	
	        }
	        return "cpmanager/listChannelData";
	    }
	   
	    @RequestMapping("/addChannelData")
	    public String addChannelData(HttpServletRequest request,ChannelData channelData, ModelMap modelMap)
	            throws Exception {
	        if(channelData==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //ChannelData gatewayInfo = new ChannelData();
	        System.out.println(channelData.toString());  
	        int id =channelDataService.addChannelData(channelData);
	        System.out.println(id+"  ============");
	        return "redirect:/listChannelData.do";
	    }
	     
	    @RequestMapping("/deleteChannelData")
	    public void deleteChannelData(HttpServletRequest request, HttpServletResponse response,ChannelData channelData,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+channelData.getArrayIds());
	    		int i= channelDataService.deleteChannelData(channelData);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editChannelData")
	    public String editChannelData (HttpServletRequest request,ChannelData channelData, ModelMap modelMap)
	            throws Exception {
	        if(channelData==null){
	        	return "err";
	        }
	     
	        ChannelData channelDataObj=new ChannelData();
	        if(channelData.getCh_data_id()!=null){
	        List<ChannelData> list= channelDataService.qryChannelDataList(channelData);
	         channelDataObj= list.get(0);
	        }
	        List<Channel> chList= channelService.qryChannelList(new Channel());
	        System.out.println(channelData.toString());  
	        modelMap.addAttribute("paramObj", channelDataObj);
	        modelMap.addAttribute("chList", chList);
	        return "cpmanager/editChannelData";
	    }
}
