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
import com.sky.blue.business.platform.entity.City;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.business.platform.service.ICityService;
import com.sky.blue.business.platform.service.IProvinceService;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.entity.SpCommand;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.entity.SpFeecodeLimit;
import com.sky.blue.business.spmanager.entity.SpFeecodeProvinceLimit;
import com.sky.blue.business.spmanager.service.ICpMakefeeItemService;
import com.sky.blue.business.spmanager.service.ISpCommandService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.business.spmanager.service.ISpFeecodeLimitService;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
import com.sky.blue.comm.BaseController;
@Controller
public class CpMakefeeItemController extends BaseController {
	@Resource(name="cpMakefeeItemServiceImpl")
	private ICpMakefeeItemService cpMakefeeItemService;
	@Resource(name="spCommandServiceImpl")
	private ISpCommandService spCommandService;
	@Resource(name="spFeecodeServiceImpl")
	private ISpFeecodeService spFeecodeService;
	@Resource(name = "cityServiceImpl")
	private ICityService cityService;	
	@Resource(name="provinceServiceImpl")
	private IProvinceService provinceService;
    @Resource(name="spCompanyServiceImpl")
    private ISpCompanyService spCompanyService;
    @Resource(name="spFeecodeLimitServiceImpl")
	private ISpFeecodeLimitService spFeecodeLimitService;
	
	   @RequestMapping("/listCpMakefeeItem")
	    public String listCpMakefeeItem(HttpServletRequest request,CpMakefeeItem cpMakefeeItem, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(cpMakefeeItem==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println(cpMakefeeItem.getItem_status()+"---------------------------------------------------");
	        System.out.println("============="+cpMakefeeItem.toString());
	        if("".equals(cpMakefeeItem.getItem_status())){
	        	cpMakefeeItem.setItem_status(null);
	        }
	        
	         boolean bo = true;
		     if(cpMakefeeItem.getFeecode_id()!=null){
		    	 bo = false;
		     }
		     if(cpMakefeeItem.getOpen_province_id()!=null){
		    	 bo = false;
		     }
		     if(cpMakefeeItem.getItem_status()!=null){
		     	 bo = false;
		     }
		     if(cpMakefeeItem.getFeecode_number()!=null&&!"".equals(cpMakefeeItem.getFeecode_number())){
		    	 bo = false;
		     }

		     if(cpMakefeeItem.getCommand()!=null&&!"".equals(cpMakefeeItem.getCommand())){
		    	 bo = false;
		     }
		     
		     if(bo){
		    	 if(cpMakefeeItem.getSp_id()!=null){
		    		 List<SpCommand> li = spCommandService.getSpCommandIdBySpid(cpMakefeeItem);
				     cpMakefeeItem.setCommand_id( li.get(pageId-1).getCommand_id());
				 }else{
					 List<SpCommand> li = spCommandService.getSpCommandId(new SpCommand());
				     cpMakefeeItem.setCommand_id( li.get(pageId-1).getCommand_id());
				 }
		     }
	        try {
	            PageHelper.startPage(1, 35, false);
	            List<CpMakefeeItem> list= cpMakefeeItemService.qryCpMakefeeItemList(cpMakefeeItem);
	            int count = cpMakefeeItemService.qryCpMakefeeItemCount(cpMakefeeItem);
	            PageInfo page = new PageInfo(list);
	            page.setTotal(count);
	            page.setPages(count%35==0?count/35:count/35+1);
	            page.setPageNum(pageId);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            //List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
	            //modelMap.addAttribute("companyList", companyList);
	            //List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
		        //modelMap.addAttribute("feecodeList", feecodeList);
				List<City> cityList = cityService.getCityList(new City());
				modelMap.addAttribute("cityList", cityList);
				List<Province> proList= provinceService.getProvinceList(new Province());
			    modelMap.addAttribute("proList", proList); 
				modelMap.addAttribute("searchObj", cpMakefeeItem);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "spmanager/listCpMakefeeItem";
	    }
	   
	   	@RequestMapping("/checkData")
	    public void checkData(HttpServletRequest request, HttpServletResponse response, CpMakefeeItem cpMakefeeItem){
		   	 if(cpMakefeeItem.getCp_item_id()==null){
	     		List<SpCommand> l = null;
				try {
					l = spCommandService.qryCpCommandList(cpMakefeeItem);
				} catch (Exception e) {
					super.ajaxSuccess(response, "同一个上游已经存在此指令和端口!");
					return;
				}
	     		if(l!=null&&l.size()>0){
	     			super.ajaxSuccess(response, "同一个上游已经存在此指令和端口!");
	     		}else{
	     			super.ajaxFail(response, "ok");
	     		}
	     	 }
	   	}
	   
	   
	    @RequestMapping("/addCpMakefeeItem")
	    public String addCpMakefeeItemInfo(HttpServletRequest request,CpMakefeeItem cpMakefeeItem, SpFeecodeLimit spFeecodeLimit, ModelMap modelMap)
	            throws Exception {
	        if(cpMakefeeItem==null){
	        	return "err";
	        }
	        if(cpMakefeeItem.getCp_item_id()==null){
	        	int feecode_id = cpMakefeeItem.getFeecode_id();
	        	cpMakefeeItem.setFeecode_id(null);
        		List<SpCommand> l = spCommandService.qryCpCommandList(cpMakefeeItem);
        		if(l!=null&&l.size()>0){
        			return "spmanager/editCpMakefeeItem";
        		}
        		cpMakefeeItem.setFeecode_id(feecode_id);
        	}
	        User dbUser = (User)request.getSession().getAttribute("curUser");
	        cpMakefeeItem.setCreate_name(dbUser.getUserName());
	        System.out.println("#################"+cpMakefeeItem.toString());  
	        int id=-1;
	        try{
		        cpMakefeeItem.setHide_city(arrayToString(cpMakefeeItem.getCitys()));
		        String prostrs = arrayToString(cpMakefeeItem.getProvince());
		        if(!"".equals(prostrs)&&prostrs!=null){
		        	if( !prostrs.contains("99")){
		        		prostrs=prostrs+",99";
		        	}
		        }
		        cpMakefeeItem.setOpenProvinceStr(prostrs);
		        
		        System.out.println(arrayToString(cpMakefeeItem.getProvince()));
		        
		        //<!-- sjm:
		        if(cpMakefeeItem.getCp_item_id()==null || cpMakefeeItem.getOpen_province_id()==99){
			        if(spFeecodeLimit!=null){
					   	spFeecodeLimit.setCreate_name(dbUser.getUserName()); 
					   	spFeecodeLimit.setRemarks(request.getParameter("limit_remarks"));
					    System.out.println(spFeecodeLimit.toString());  
					    id=-1;
					        
					    //spFeecodeLimit.setLimit_province(arrayToString(spFeecodeLimit.getProvince()));
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
				    	id = spFeecodeLimitService.addSpFeecodeLimit(spFeecodeLimit);
			        }
			    }else{
			    	/*
			    	SpFeecodeProvinceLimit proLimit = new SpFeecodeProvinceLimit();
			    	proLimit.setLimit_id(spFeecodeLimit.getLimit_id());
			    	proLimit.setCreate_name(dbUser.getUserName());
			    	proLimit.setProvince(cpMakefeeItem.getOpen_province_id());
			    	proLimit.setProvince_name(cpMakefeeItem.getOpen_province_name());
			    	proLimit.setRemarks(request.getParameter("limit_remarks"));
			    	proLimit.setPro_day_num(spFeecodeLimit.getDay_num());
			    	proLimit.setPro_month_num(spFeecodeLimit.getMonth_num());
			    	proLimit.setPro_single_day_num(spFeecodeLimit.getSingle_day_num());
			    	proLimit.setPro_single_month_num(spFeecodeLimit.getSingle_month_num());
			    	proLimit.setPro_limit_start_time(spFeecodeLimit.getLimit_start_time());
			    	proLimit.setPro_limit_end_time(spFeecodeLimit.getLimit_end_time());
			    	proLimit.setPro_limit_start_hour(spFeecodeLimit.getLimit_start_hour());
			    	proLimit.setPro_limit_end_hour(spFeecodeLimit.getLimit_end_hour());
			    	id = spFeecodeLimitService.addSpFeecodeProvinceLimit(proLimit);
			    	*/
			    }
			    //-->
	        id =cpMakefeeItemService.addCpMakefeeItem(cpMakefeeItem);
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	        System.out.println(id+"  ============");
	        
	        return "redirect:/listCpMakefeeItem.do";
	    }
	     
	    @RequestMapping("/closeOrOpenCpMakefeeItem")
	    public void closeOrOpenCpMakefeeItem(HttpServletRequest request, HttpServletResponse response,CpMakefeeItem cpMakefeeItem,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+cpMakefeeItem.getArrayIds());
	    		int i= cpMakefeeItemService.closeOrOpenCpMakefeeItem(cpMakefeeItem);
	    		
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "操作成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "操作失败");
	    	}
	    	
	      
	    }
	    @RequestMapping("/editCpMakefeeItem")
	    public String editCpMakefeeItem (HttpServletRequest request,CpMakefeeItem cpMakefeeItem, ModelMap modelMap)
	            throws Exception {
	        if(cpMakefeeItem==null){
	        	return "err";
	        }
	        //System.out.println(gatewayInfo.getProvince()[0]+" --------------------");
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        CpMakefeeItem cpMakefeeItemObj=new CpMakefeeItem();
	        if(cpMakefeeItem.getCp_item_id()!=null){
	        List<CpMakefeeItem> list= cpMakefeeItemService.qryCpMakefeeItemList(cpMakefeeItem);
	         cpMakefeeItemObj= list.get(0);
	         if(cpMakefeeItemObj.getOpen_province_id()==99){
	        	 CpMakefeeItem item = new CpMakefeeItem();
	        	 item.setFeecode_number(cpMakefeeItem.getFeecode_number());
	        	 item.setCommand(cpMakefeeItem.getCommand());
	        	 item.setCommand_id(cpMakefeeItem.getCommand_id());
	        	 //获得指令所有项
	        	 List<CpMakefeeItem> plist= cpMakefeeItemService.qryCpMakefeeItemList(item);
	        	 String proStr="";
	        	 //获得开通的省
	        	 for(CpMakefeeItem it :plist){
	        		 if("0".equals(it.getItem_status())){
	        			 proStr=proStr+","+it.getOpen_province_id();
	        		 }
	        	 }
	        	 cpMakefeeItemObj.setOpenProvinceStr(proStr);
	        	//<!--sjm: 修改全国计费项
		         SpFeecodeLimit sp = new SpFeecodeLimit();
		         sp.setFeecode_id(cpMakefeeItemObj.getFeecode_id());
		         List<SpFeecodeLimit> spls= spFeecodeLimitService.qryCpFeecodeLimitList(sp);
		         sp = spls.get(0);
		         modelMap.addAttribute("sp", sp);
		         //-->
	         }else{
	         	City city = new City();
				city.setProvince_id(cpMakefeeItemObj.getOpen_province_id());
				List<City> cityList = cityService.getCityList(city);
				modelMap.addAttribute("cityList", cityList);
				/*
				//<!--sjm: 修改省份计费项
		         SpFeecodeLimit sp = new SpFeecodeLimit();
		         sp.setFeecode_id(cpMakefeeItemObj.getFeecode_id());
		         List<SpFeecodeLimit> spls= spFeecodeLimitService.qryCpFeecodeLimitList(sp);
		         SpFeecodeProvinceLimit spp = new SpFeecodeProvinceLimit();
		         spp.setLimit_id(spls.get(0).getLimit_id());
		         spp.setProvince(cpMakefeeItemObj.getOpen_province_id());
		         List<SpFeecodeProvinceLimit> sppls = spFeecodeLimitService.getCpFeecodeProvinceLimitList(spp);
		         if(sppls!=null && sppls.size()>0){
		        	 modelMap.addAttribute("sp", sppls.get(0));
		         }else{
		        	 spp.setProvince_name(cpMakefeeItemObj.getOpen_province_name());
		        	 spFeecodeLimitService.addSpFeecodeProvinceLimit(spp);
		        	 modelMap.addAttribute("sp", spp);
		         }  
		         //-->		
		         */
	         }   
	         System.out.println(cpMakefeeItemObj.getCp_item_name()+"  ===================== ");
	        }else{
	        	List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
		        modelMap.addAttribute("companyList", companyList);	            
	      	  	List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
		        modelMap.addAttribute("feecodeList", feecodeList);
		        modelMap.addAttribute("sp", new SpFeecodeLimit());
		        //List<SpCommand> commanelist= spCommandService.qryCpCommandList(new SpCommand());
		        //modelMap.addAttribute("commandList", commanelist);
		        //modelMap.addAttribute("provinceList", new ArrayList<Province>());
	        }
	        System.out.println(cpMakefeeItem.toString()); 
	        List<Province> proList= provinceService.getProvinceList(new Province());
	        modelMap.addAttribute("proList", proList); 
	        modelMap.addAttribute("paramObj", cpMakefeeItemObj);
	        return "spmanager/editCpMakefeeItem";
	    }
}
