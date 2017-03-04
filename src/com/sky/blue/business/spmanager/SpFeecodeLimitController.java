package com.sky.blue.business.spmanager;

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
import com.sky.blue.business.logon.entity.User;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.business.platform.service.IProvinceService;
import com.sky.blue.business.spmanager.entity.SpCommand;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.entity.SpFeecodeLimit;
import com.sky.blue.business.spmanager.entity.SpFeecodeProvinceLimit;
import com.sky.blue.business.spmanager.entity.SpProvinceControl;
import com.sky.blue.business.spmanager.service.ISpFeecodeLimitService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
import com.sky.blue.comm.BaseController;
@Controller
public class SpFeecodeLimitController extends BaseController {
	@Resource(name="provinceServiceImpl")
	private IProvinceService provinceService;
	@Resource(name="spFeecodeLimitServiceImpl")
	private ISpFeecodeLimitService spFeecodeLimitService;
	@Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	@Resource(name="spFeecodeServiceImpl")
	private ISpFeecodeService spFeecodeService;

	   @RequestMapping("/listSpFeecodeLimit")
	    public String listSpFeecodeLimit(HttpServletRequest request,SpFeecodeLimit spFeecodeLimit, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(spFeecodeLimit==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+spFeecodeLimit.toString());
	        List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
	        List<Province> proList= provinceService.getProvinceList(new Province());
	        List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
	        modelMap.addAttribute("proList", proList); 
	        try {
	            PageHelper.startPage(pageId, 10);
	            List<SpFeecodeLimit> list= spFeecodeLimitService.qryCpFeecodeLimitList(spFeecodeLimit);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("searchObj", spFeecodeLimit);
	            modelMap.addAttribute("page", page);
	            modelMap.addAttribute("companyList", companyList);
	            modelMap.addAttribute("feecodeList", feecodeList);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listSpFeecodeLimit";
	    }
	   
	    @RequestMapping("/addSpFeecodeLimit")
	    public String addSpFeecodeLimitInfo(HttpServletRequest request,SpFeecodeLimit spFeecodeLimit, ModelMap modelMap)
	            throws Exception {
	        if(spFeecodeLimit==null){
	        	return "err";
	        }
	        
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        spFeecodeLimit.setCreate_name(dbUser.getUserName());
	       
	        System.out.println(spFeecodeLimit.toString());  
	        int id=-1;
	        try{
	        	spFeecodeLimit.setLimit_province(arrayToString(spFeecodeLimit.getProvince()));
	        	if(spFeecodeLimit.getLimit_time_str()!=null&&!"".equals(spFeecodeLimit.getLimit_time_str())){
	        		if(spFeecodeLimit.getLimit_time_str().contains("-")){
	        			String strs[]=spFeecodeLimit.getLimit_time_str().split("-");
	        			spFeecodeLimit.setLimit_start_time(strs[0]);
	        			spFeecodeLimit.setLimit_end_time(strs[1]);
	        		}
	        	}
	        	
	        	if(spFeecodeLimit.getLimit_hour_str()!=null&&!"".equals(spFeecodeLimit.getLimit_hour_str())){
	        		if(spFeecodeLimit.getLimit_hour_str().contains("-")){
	        			String strs[]=spFeecodeLimit.getLimit_hour_str().split("-");
	        			spFeecodeLimit.setLimit_start_hour(strs[0]);
	        			spFeecodeLimit.setLimit_end_hour(strs[1]);
	        		}
	        	}
	        	
	         id =spFeecodeLimitService.addSpFeecodeLimit(spFeecodeLimit);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listSpFeecodeLimit.do";
	    }
	     
	    @RequestMapping("/deleteSpFeecodeLimit")
	    public void deleteSpFeecodeLimit(HttpServletRequest request, HttpServletResponse response,SpFeecodeLimit spFeecodeLimit,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+spFeecodeLimit.getArrayIds());
	    		int i= spFeecodeLimitService.deleteSpFeecodeLimit(spFeecodeLimit);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editSpFeecodeLimit")
	    public String editSpFeecodeLimit (HttpServletRequest request,SpFeecodeLimit spFeecodeLimit, ModelMap modelMap)
	            throws Exception {
	        if(spFeecodeLimit==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        
	        SpFeecodeLimit spFeecodeLimitObj=new SpFeecodeLimit();
	        if(spFeecodeLimit.getLimit_id()!=null&&!"".equals(spFeecodeLimit.getLimit_id())){
	        List<SpFeecodeLimit> list= spFeecodeLimitService.qryCpFeecodeLimitList(spFeecodeLimit);
	         spFeecodeLimitObj= list.get(0);
	         System.out.println(spFeecodeLimitObj.getFeecode_name()+"  ===================== ");
	        }else{
	        	List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
	        	modelMap.addAttribute("companyList", companyList); 
	        	List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
	        	modelMap.addAttribute("feecodeList", feecodeList);     
	        }
	        List<Province> proList= provinceService.getProvinceList(new Province());
	        modelMap.addAttribute("proList", proList);  
	        System.out.println(spFeecodeLimit.toString()); 
	     
	        modelMap.addAttribute("paramObj", spFeecodeLimitObj);
	        return "spmanager/editSpFeecodeLimit";
	    }
	    
	    @RequestMapping("/editSpFeecodeProvinceLimit")
	    public String editSpFeecodeProvinceLimit (HttpServletRequest request,SpFeecodeLimit spFeecodeLimit, ModelMap modelMap)
	            throws Exception {
	        if(spFeecodeLimit==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	  
	        SpFeecodeProvinceLimit spFeecodeLimitObj=new SpFeecodeProvinceLimit();
        	spFeecodeLimitObj.setLimit_id(spFeecodeLimit.getLimit_id());
	  
	        List<SpFeecodeProvinceLimit> proLimitList= spFeecodeLimitService.getCpFeecodeProvinceLimitList(spFeecodeLimitObj);
	        if(proLimitList.size()==0){
		        proLimitList = new ArrayList<SpFeecodeProvinceLimit>();
		        List<Province> proList= provinceService.getProvinceList(new Province());
		        for(int i=0;i<proList.size();i++){
		        	Province p = proList.get(i);
		        	SpFeecodeProvinceLimit limitObj=new SpFeecodeProvinceLimit();
		        	limitObj.setLimit_id(spFeecodeLimit.getLimit_id());
		        	limitObj.setProvince(p.getProvince_id());
		        	limitObj.setProvince_name(p.getProvince_name());
		        	proLimitList.add(limitObj);
		        }	    	       
	        }
	        modelMap.addAttribute("proLimitList", proLimitList);  
	        System.out.println(spFeecodeLimit.toString()); 
	     
	        modelMap.addAttribute("paramObj", spFeecodeLimit);
	        return "spmanager/editSpFeecodeProvinceLimit";
	    }
	    	    	
	    @RequestMapping("/saveFeecodeProvinceLimit")
	    public String saveFeecodeProvinceLimit(HttpServletRequest request,SpFeecodeLimit spFeecodeLimit, ModelMap modelMap)
	            throws Exception {
	        if(spFeecodeLimit==null){
	        	return "err";
	        }
	       
	        System.out.println(spFeecodeLimit.getProLimitArr().length+"================================");
	       
	        
	        List<SpFeecodeProvinceLimit> proLimitList = new ArrayList<SpFeecodeProvinceLimit>();
	        SpFeecodeProvinceLimit[] arr = spFeecodeLimit.getProLimitArr();
	        if(arr!=null){
	        	for(int i=0;i<arr.length;i++){
	        		SpFeecodeProvinceLimit proLimit=arr[i];
	        		if(proLimit.getProvince()!=null){
	        			if(proLimit.getPro_limit_hour_str()!=null&&!"".equals(proLimit.getPro_limit_hour_str())){
	        				String str[] = proLimit.getPro_limit_hour_str().split("-");
	        				proLimit.setPro_limit_start_hour(str[0]);
	        				proLimit.setPro_limit_end_hour(str[1]);
	        			}
	        			if(proLimit.getPro_limit_time_str()!=null&&!"".equals(proLimit.getPro_limit_time_str())){
	        				String str[] =proLimit.getPro_limit_time_str().split("-");
	        				proLimit.setPro_limit_start_time(str[0]);
	        				proLimit.setPro_limit_end_time(str[1]);
	        			}
	        			proLimitList.add(proLimit);
	        		}
	        	}
	        }
	        
	        spFeecodeLimitService.addSpFeecodeProvinceLimit(proLimitList);
	       
	        
	        return "redirect:/listSpFeecodeLimit.do";
	    }
	    
	    @RequestMapping("/listSpProvinceControl")
	    public String listSpProvinceControl(HttpServletRequest request,SpProvinceControl spProvinceControl, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(spProvinceControl==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+spProvinceControl.toString());
	          try {
	            PageHelper.startPage(pageId, 35);
	            List<SpProvinceControl> list= spFeecodeLimitService.qrySpProvinceControlList(new SpProvinceControl());
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listSpProvinceControl";
	    }
	   
	    @RequestMapping("/updateSpProvinceControl")
	    public void updateSpProvinceControl(HttpServletRequest request, HttpServletResponse response,SpProvinceControl spProvinceControl,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+spProvinceControl.toString());
	    		   User dbUser = (User)request.getSession().getAttribute("curUser");
	    		   spProvinceControl.setUpdate_name(dbUser.getUserName());
	    		int i= spFeecodeLimitService.updateSpProvinceControl(spProvinceControl);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "操作成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "操作失败");
	    	}
	    	
	      
	    } 
	    
}
