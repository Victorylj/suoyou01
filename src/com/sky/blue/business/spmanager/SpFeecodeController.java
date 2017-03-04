package com.sky.blue.business.spmanager;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
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
import com.sky.blue.business.spmanager.entity.SpChannel;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecodeGroup;
import com.sky.blue.business.spmanager.service.ISpChannelService;
import com.sky.blue.business.spmanager.service.ISpFeecodeGroupServer;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.business.stat.entity.SmsFilterStat;
import com.sky.blue.comm.BaseController;
@Controller
public class SpFeecodeController extends BaseController {
	@Resource(name="spFeecodeServiceImpl")
	private ISpFeecodeService spFeecodeService;
	@Resource(name="spChannelServiceImpl")
	private ISpChannelService spChannelService;
	@Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	@Autowired
	public ISpFeecodeGroupServer spFeecodeGroupServer;
	   @RequestMapping("/listSpFeecode")
	    public String listSpFeecode(HttpServletRequest request,SpFeecode spFeecode, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(spFeecode==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+spFeecode.toString());
	        List<SpCompany> spList= spCompanyService.qryCpCompanyList(new SpCompany());
	        List<SpFeecodeGroup> spfcgroup = spFeecodeGroupServer.listSpFeecodeGroup(new SpFeecodeGroup());
	        
	        HashMap<String, String> fgs = new HashMap<String, String>();
            for(SpFeecodeGroup fg: spfcgroup){
            	fgs.put("key_"+fg.getG_id(), fg.getG_name());
        	}
            
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<SpFeecode> list= spFeecodeService.qryCpFeecodeList(spFeecode);
	            if(fgs.size()>0){
	            	String gname = null;
		            for (SpFeecode sf : list) {
		            	gname = fgs.get("key_"+sf.getGroup_id());
		            	gname = gname==null?"无分组":gname;
						sf.setGroup_name(gname);
					}
	            }
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("searchObj", spFeecode);
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("spList", spList);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listSpFeecode";
	    }
	   
	   @RequestMapping("/getSpFeecodeList")
	    public void getSpFeecodeList(HttpServletResponse response,HttpServletRequest request,SpFeecode spFeecode, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	       
	           List<SpFeecode> list= spFeecodeService.qryCpFeecodeList(spFeecode);
	            
	           ajaxResponse(response,list);
	    }
	   
	    @RequestMapping("/addSpFeecode")
	    public String addSpFeecodeInfo(HttpServletRequest request,SpFeecode spFeecode, ModelMap modelMap)
	            throws Exception {
	        if(spFeecode==null){
	        	return "err";
	        }
	       
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        spFeecode.setCreate_name(dbUser.getUserName());
	        System.out.println(spFeecode.toString());  
	        int id=-1;
	        try{
	         id =spFeecodeService.addSpFeecode(spFeecode);
	         request.getSession().removeAttribute("sfcList");
	         request.getSession().removeAttribute("sfcList1");
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listSpFeecode.do";
	    }
	     
	    @RequestMapping("/deleteSpFeecode")
	    public void deleteSpFeecode(HttpServletRequest request, HttpServletResponse response,SpFeecode spFeecode,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+spFeecode.getArrayIds());
	    		int i= spFeecodeService.deleteSpFeecode(spFeecode);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editSpFeecode")
	    public String editSpFeecode (HttpServletRequest request,SpFeecode spFeecode, ModelMap modelMap)
	            throws Exception {
	        if(spFeecode==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        SpFeecode spFeecodeObj=new SpFeecode();
	        if(spFeecode.getFeecode_id()!=null){
	        	List<SpFeecode> list= spFeecodeService.qryCpFeecodeList(spFeecode);
	         	spFeecodeObj= list.get(0);
	         	System.out.println(spFeecodeObj.getSp_name()+"  ===================== ");
	        }else{
	        	List<SpCompany> list= spCompanyService.qryCpCompanyList(new SpCompany());
	        	modelMap.addAttribute("spList", list);
	        
	        	List<SpChannel> spchannellist= spChannelService.qryCpChannelList(new SpChannel());
	        	modelMap.addAttribute("spChannelList", spchannellist);
	        }
	        List<SpFeecodeGroup> spfcgroup = spFeecodeGroupServer.listSpFeecodeGroup(new SpFeecodeGroup());
        	modelMap.addAttribute("spfcgroup", spfcgroup); 
	        System.out.println(spFeecode.toString()); 
	     
	        modelMap.addAttribute("paramObj", spFeecodeObj);
	        return "spmanager/editSpFeecode";
	    }
	    
	    /**
	     * 判断任意公司下的计费端口是否存在
	     * @param request
	     * @param response
	     * @param spFeecode
	     * @param modelMap
	     * @throws Exception
	     * @create 2014-12-13 am
	     * @author wangjie
	     */
	    @RequestMapping("/getFeecodeNumberBySpId")
	    public void getFeecodeNumberBySpId(HttpServletRequest request, HttpServletResponse response,SpFeecode spFeecode,ModelMap modelMap)
	            throws Exception {
	    	int i= -1;
	    	try{
	    		System.out.println("========="+spFeecode.getArrayIds());
	    		i= spFeecodeService.getFeecodeNumberBySpId(spFeecode);
	    		if(i>0){
	    			super.ajaxSuccess(response, "端口已被占用!");
	    		}else{
	    			super.ajaxFail(response,"");
	    		}
	    		
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "");
	    	}
	    	
	      
	    }
	    
}
