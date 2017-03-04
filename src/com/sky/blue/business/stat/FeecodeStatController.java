package com.sky.blue.business.stat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.business.platform.service.IProvinceService;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.service.ISpCommandService;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
import com.sky.blue.business.stat.entity.FeecodeStat;
import com.sky.blue.business.stat.entity.SmsFilterStat;
import com.sky.blue.business.stat.service.IFeecodeStatService;
import com.sky.blue.comm.BaseController;

@Controller
public class FeecodeStatController extends BaseController{
	@Resource(name="feecodeStatServiceImpl")
	private IFeecodeStatService feecodeStatService;
	@Resource(name="spCommandServiceImpl")
	private ISpCommandService spCommandService;
	@Resource(name="spFeecodeServiceImpl")
	private ISpFeecodeService spFeecodeService;
	@Resource(name="provinceServiceImpl")
	private IProvinceService provinceService;
	
	 @RequestMapping("/listFeecodeStat")
    public String listFeecodeStat(HttpServletRequest request,FeecodeStat feecodeStat, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
            throws Exception {
        if(feecodeStat==null){
        	return "err";
        }
        //GatewayInfo gatewayInfo = new GatewayInfo();
        System.out.println("============="+feecodeStat.toString());

        try {
            PageHelper.startPage(pageId, 35);
            List<FeecodeStat> list= feecodeStatService.qryFeecodeStatList(feecodeStat);
            PageInfo page = new PageInfo(list);
            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
            modelMap.addAttribute("page", page);
            List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
	        modelMap.addAttribute("feecodeList", feecodeList);
	        List<Province> proList = provinceService.getProvinceList(new Province());
	        modelMap.addAttribute("proList", proList);
	        modelMap.addAttribute("searchObj", feecodeStat);
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println();
        }
        return "stat/listFeecodeStat";
    }
   
	 @RequestMapping("/listSmsFilterStat")
	    public String listSmsFilterStat(HttpServletRequest request,SmsFilterStat smsFilterStat, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(smsFilterStat==null){
	        	return "err";
	        }
	        
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String dater=sf.format(new Date());
	        if(smsFilterStat.getStart_time()==null||smsFilterStat.getEnd_time()==null){
	        	smsFilterStat.setStart_time(dater);
	        	smsFilterStat.setEnd_time(dater);
	        }else{
	        }
	        
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+smsFilterStat.toString());

	        try {
	            PageHelper.startPage(pageId, 10000);
	            List<SmsFilterStat> list= feecodeStatService.qrySmsFilterStatList(smsFilterStat);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	           
		        modelMap.addAttribute("searchObj", smsFilterStat);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "stat/listSmsFilterStat";
	    }
	 
	 @RequestMapping("/listCurrentRate")
	    public String listCurrentRate(HttpServletRequest request,FeecodeStat feecodeStat, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(feecodeStat==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+feecodeStat.toString());

	        try {
	          //  PageHelper.startPage(pageId, 1000);
	            List<FeecodeStat> cmdlist= feecodeStatService.getCommandInfo(feecodeStat);
	            HashMap<String , FeecodeStat> cmdTemp =new   HashMap<String , FeecodeStat>();
	            for(int i=0;i<cmdlist.size();i++){
	            	FeecodeStat cmd= cmdlist.get(i);
	            	cmdTemp.put(cmd.getFeecode_number()+cmd.getCommand(), cmd);
	            }
	            List<FeecodeStat> ratelist= feecodeStatService.getRateInfo(feecodeStat);
	            List<FeecodeStat> retlist = new ArrayList<FeecodeStat>();
	            System.out.println(ratelist.size());
	            int allmo=0;
	            int allmr=0;
	            int allfee=0;
	            for(int i=0;i<ratelist.size();i++){
	            	FeecodeStat rate=ratelist.get(i);
	            	allmo=allmo+rate.getMo_num();
	            	allmr=allmr+rate.getMr_num();
	            	
	            	FeecodeStat cmd=cmdTemp.get(rate.getFeecode_number()+rate.getCommand());
	            	if(cmd!=null){
	            		rate.setSp_name(cmd.getSp_name());
	            		rate.setFeecode_name(cmd.getFeecode_name());
	            		rate.setFeecode_fee(cmd.getFeecode_fee());
	            		rate.setCommand_status(cmd.getCommand_status());
	            		rate.setOp(cmd.getOp());
	            		allfee=allfee+rate.getMr_num()*cmd.getFeecode_fee();
	            		retlist.add(rate);
	            	}
	            }
	            
	          //  PageInfo page = new PageInfo(ratelist);
	          // System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("ratelist", retlist);
	            modelMap.addAttribute("allmo", allmo);
	            modelMap.addAttribute("allmr", allmr);
	            modelMap.addAttribute("allfee", allfee);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "stat/listCurrentRate";
	    }
	   
}
