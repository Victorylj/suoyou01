package com.sky.blue.business.stat;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.cpmanager.entity.Channel;
import com.sky.blue.business.cpmanager.entity.SearchBean;
import com.sky.blue.business.platform.entity.Province;
import com.sky.blue.business.platform.service.IProvinceService;
import com.sky.blue.business.spmanager.entity.SpCommand;
import com.sky.blue.business.spmanager.entity.SpCompany;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.business.spmanager.service.ISpCommandService;
import com.sky.blue.business.spmanager.service.ISpCompanyService;
import com.sky.blue.business.spmanager.service.ISpFeecodeService;
import com.sky.blue.business.stat.entity.RecData;
import com.sky.blue.business.stat.entity.RecDataStat;
import com.sky.blue.business.stat.service.IRecDataStatService;
import com.sky.blue.comm.BaseController;

@Controller
public class RecDataStatController extends BaseController{
	@Resource(name="recDataStatServiceImpl")
	private IRecDataStatService recDataStatService;
	@Resource(name="spCommandServiceImpl")
	private ISpCommandService spCommandService;
	@Resource(name="spFeecodeServiceImpl")
	private ISpFeecodeService spFeecodeService;
	@Resource(name="provinceServiceImpl")
	private IProvinceService provinceService;
	@Resource(name="spCompanyServiceImpl")
	private ISpCompanyService spCompanyService;
	 @RequestMapping("/listRecDataStat")
    public String listRecDataStat(HttpServletRequest request,RecDataStat recDataStat, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
            throws Exception {
        if(recDataStat==null){
        	return "err";
        }
        //GatewayInfo gatewayInfo = new GatewayInfo();
        System.out.println("============="+recDataStat.toString());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dater=sf.format(new Date());
        if(recDataStat.getStart_time()==null||recDataStat.getEnd_time()==null){
        	 recDataStat.setDater(dater);
        	 recDataStat.setStart_time(dater);
        	 recDataStat.setEnd_time(dater);
        }else{
        	Date date = sf.parse(recDataStat.getEnd_time());
        	Date date1 = sf.parse(dater);
        	if(date.getTime()>date1.getTime()){
        		recDataStat.setEnd_time(dater);
        	}
        	Date date2 = sf.parse(recDataStat.getStart_time());
        	if(date2.getTime()<date1.getTime()&&date.getTime()>=date1.getTime()){
        		date1.setDate(date1.getDate()-1);
        		dater=sf.format(date1);
        		recDataStat.setEnd_time(dater);
        	}
        	recDataStat.setDater(null);
        }
       
        try {
            PageHelper.startPage(pageId, 10000);
            List<RecDataStat> list= recDataStatService.qryRecDataStatList(recDataStat);
            //List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
            List<SpCommand> commandList=spCommandService.listSpCommand(new SpCommand());
            PageInfo page = new PageInfo(list);
            
            int allDatas = 0;
            int allFee=0;
            int allUsers=0;
            float allIncomeB=0;
            HashMap<String ,SpCommand> temp = new HashMap<String,SpCommand>();
            for(SpCommand cmd:commandList){
            	temp.put(cmd.getSp_id().intValue()+cmd.getFeecode_number()+cmd.getCommand(), cmd);
        	}
            for(RecDataStat rds:list){
            	rds.setDater(recDataStat.getStart_time()+"至"+recDataStat.getEnd_time());
            	allDatas= allDatas+rds.getSucc_calls();
            	allFee=allFee+rds.getFee();
            	allUsers=allUsers+rds.getSucc_users();
            	SpCommand spC = temp.get(rds.getSp_id()+rds.getSpnumber()+rds.getCommand());
				if(spC!=null){
	            	Float f = spC.getCommand_share();
	            	if(f!=null){
	            		rds.setShare(f);
	            		float incomeb = rds.getSucc_calls()*f;
	            		allIncomeB=allIncomeB+incomeb;
	            	}
				}else{
					System.out.println("not'Command po:" + rds.getSp_id()+rds.getSpnumber()+rds.getCommand());
				}
            	/*
            	for (SpCommand spCommand : commandList) {
            		if(spCommand.getCommand_share() != null){
            			boolean flag1=rds.getCommand().equalsIgnoreCase(spCommand.getCommand());
            			boolean flag2=rds.getSpnumber().equalsIgnoreCase(spCommand.getFeecode_number());
            			boolean flag3=rds.getSp_id().equals(spCommand.getSp_id().intValue()+"");
            			if(flag1 && flag2&&flag3){
            				rds.setShare(spCommand.getCommand_share());
            				float incomeb = rds.getSucc_calls()*spCommand.getCommand_share();
            				allIncomeB=allIncomeB+incomeb;
            			}
            		}
				}
				*/
            }
            
            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
            modelMap.addAttribute("page", page);
            //List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
	        //modelMap.addAttribute("feecodeList", feecodeList);
	        List<Province> proList = provinceService.getProvinceList(new Province());
	        //modelMap.addAttribute("companyList", companyList);
	        modelMap.addAttribute("allDatas", allDatas);
			DecimalFormat df = new DecimalFormat("#.00");
	        modelMap.addAttribute("allIncomeB", df.format(allIncomeB));
	        modelMap.addAttribute("allFee", allFee);
	        modelMap.addAttribute("allUsers", allUsers);
	        modelMap.addAttribute("proList", proList);
	        modelMap.addAttribute("searchObj", recDataStat);
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println();
        }
        return "stat/listRecDataStat";
    }
	 
	 @RequestMapping("/exportRecDataDetail")
	 public void exportRecDataDetail(HttpServletRequest request,HttpServletResponse response,RecDataStat recDataStat, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String dater=sf.format(new Date());
	        if(recDataStat.getStart_time()==null||recDataStat.getEnd_time()==null){
	        	recDataStat.setDater(dater);
	        	recDataStat.setStart_time(dater);
	        	recDataStat.setEnd_time(dater);
	        }else{
	        	recDataStat.setDater(null);
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+recDataStat.toString());
	        List<SpCommand> commandList=spCommandService.qryCpCommandList(new SpCommand());
	        try {
	        	
	        	List<RecDataStat> list= recDataStatService.qryRecDataStatList(recDataStat);
	        	 for(RecDataStat rds:list){
	             	for (SpCommand spCommand : commandList) {
	             		if(spCommand.getCommand_share() != null){
	             			boolean flag1=rds.getCommand().equalsIgnoreCase(spCommand.getCommand());
	             			boolean flag2=rds.getSpnumber().equalsIgnoreCase(spCommand.getFeecode_number());
	             			boolean flag3=rds.getSp_id().equals(spCommand.getSp_id().intValue()+"");
	            			if(flag1 && flag2&&flag3){
	             				rds.setShare(spCommand.getCommand_share());
	             				float incomeb = rds.getSucc_calls()*spCommand.getCommand_share();
	             				DecimalFormat df = new DecimalFormat("#.00");
	            		        String s= df.format(incomeb);
	            		        rds.setIncomeb(s);
	             			}
	             		}
	 				}
	             }

	            RecDataExcel.createExcelByte(recDataStat,  list, response);
	            
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	       /// return "stat/listRecData";
	    }
	 public static void main(String[] args) throws ParseException {

	}
	 	/**
	 	 * Sjm
	 	 * @param request
	 	 * @param recDataStat
	 	 * @return
	 	 */
	 	@RequestMapping("/updSussNumber")
		public void updSussNumber(HttpServletRequest request, HttpServletResponse response,RecDataStat recDataStat){
	 		if(recDataStat.getIncome_user()!=null&&recDataStat.getIncome_user()!=0){return;}
	 		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 		PrintWriter out = null;
	 		SpCommand sm = new SpCommand();
	 		sm.setCommand(recDataStat.getCommand());
	 		sm.setFeecode_number(recDataStat.getFeecode_number());
	 		sm.setSp_id(Integer.parseInt(recDataStat.getSp_id()));
	 		DecimalFormat df = new DecimalFormat("0.00");
	 		if(recDataStat.getIncome_calls()==null){
	 			recDataStat.setIncome_calls(0);
	 		}
	 		recDataStat.setRate(df.format(recDataStat.getIncome_calls()/1d/recDataStat.getSucc_calls()));
	 		int ffee = recDataStat.getFeecode_fee()==null?0:recDataStat.getFeecode_fee();
	 		recDataStat.setIncome_user(0);
	 		recDataStat.setFee(recDataStat.getIncome_calls()*ffee/100);
	 		try {
	 			Date date = sdf.parse(recDataStat.getDater());
	 			Date date2 = sdf.parse(format.format(new Date()));
	 			out = response.getWriter();
	 			if(date.getTime()>=date2.getTime()){return ;}
				recDataStatService.updRecDataStatHis(recDataStat);
				List<SpCommand> commandList=spCommandService.qryCpCommandList(sm);
				for (SpCommand spCommand : commandList) {
            		if(spCommand.getCommand_share() != null){
            			recDataStat.setShare(spCommand.getCommand_share());
            		}
            		if(recDataStat.getRate()!=null&&"".equals(recDataStat.getRate())){
            			recDataStat.setRate(df.format(Double.parseDouble(recDataStat.getRate())/spCommand.getSynchro_num()));
            		}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	 		out.print(JSONArray.fromObject(recDataStat));
			out.flush();
			out.close();
		}
	 
	 
		@RequestMapping("/getRecDataStat")
	    public String getRecDataStat(HttpServletRequest request,RecDataStat recDataStat, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(recDataStat==null){
	        	return "err";
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+recDataStat.toString());
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String dater=sf.format(new Date());
	        if(recDataStat.getStart_time()==null||recDataStat.getEnd_time()==null){
	        	 recDataStat.setDater(dater);
	        	 recDataStat.setStart_time(dater);
	        	 recDataStat.setEnd_time(dater);
	        }else{
	        	recDataStat.setDater(recDataStat.getStart_time());
	        }
	       
	        try {
	            PageHelper.startPage(pageId, 10000, false);
	            List<RecDataStat> list= recDataStatService.getRecDataStatList(recDataStat);
	            //List<SpCompany> companyList=spCompanyService.qryCpCompanyList(new SpCompany());
	            //List<SpCommand> commandList=spCommandService.qryCpCommandList(new SpCommand());
	            List<RecDataStat> listDelayMinute= recDataStatService.getRecDelayMinute(recDataStat);
	            HashMap<String,Integer> mtemp = new HashMap<String,Integer>();
	            for(RecDataStat dm:listDelayMinute){
	            	mtemp.put(dm.getSp_id()+dm.getSpnumber()+dm.getCommand(), dm.getDelaymiute());
	            }
	             SpCommand command = new SpCommand();
	             //command.setCommand_status(1);
	            List<SpCommand> cmdlist= spCommandService.listSpCommand(command);
	            System.out.println(cmdlist.size()+"==================================");
	            HashMap<String ,SpCommand> temp = new HashMap<String,SpCommand>();
	            int allDatas = 0;
	            int allFee=0;
	            int allUsers=0;
	            int allIncomeUser=0;
	            int allSuccs=0;
	            float allIncomeB=0;
	           /* for(RecDataStat rds:list){
	            	rds.setDater(recDataStat.getStart_time()+"至"+recDataStat.getEnd_time());
	            	allDatas= allDatas+rds.getSucc_calls();
	            	//allFee=allFee+rds.getFee();
	            	allUsers=allUsers+rds.getSucc_users();
	            	for (SpCommand spCommand : cmdlist) {
	            		if(spCommand.getCommand_share() != null){
	            			boolean flag1=rds.getCommand().equalsIgnoreCase(spCommand.getCommand());
	            			boolean flag2=rds.getFeecode_number().equalsIgnoreCase(spCommand.getFeecode_number());
	            			if(flag1 && flag2){
	            				rds.setShare(spCommand.getCommand_share());
	            				System.out.println("==================================ll");
	            			}
	            		}
					}
	            }*/
	            
	            for(SpCommand cmd:cmdlist){
	            	temp.put(cmd.getSp_id().intValue()+cmd.getFeecode_number()+cmd.getCommand(), cmd);
            	}
	            
	            for(RecDataStat rds:list){
	            	
	            	if(rds.getSucc_calls()!=null)
	            	allDatas= allDatas+rds.getSucc_calls();
	            	if(rds.getFee()!=null)
	            	allFee=allFee+rds.getFee();
	            	if(rds.getSucc_users()!=null)
	            	allUsers=allUsers+rds.getSucc_users();
	            	if(rds.getIncome_user()!=null)
	            	allIncomeUser=allIncomeUser+rds.getIncome_user();
	            	if(rds.getIncome_calls()!=null){
	            		allSuccs=allSuccs+rds.getIncome_calls();
	            	}
	            	
	            	//rds.setDater(recDataStat.getStart_time()+"至"+recDataStat.getEnd_time());
	            	String key=rds.getSp_id()+rds.getFeecode_number()+rds.getCommand();
	            	SpCommand spC = temp.get(key);
					if(spC!=null){
						Integer st = null;
						st = spC.getCommand_status()==null?null:Integer.parseInt(spC.getCommand_status());
						if(st!=null){
		            		if(st==1){
		            			rds.setRemarks("<span style=\"color: red\">关闭</span>");
		            		}else{
		            			rds.setRemarks("<span style=\"color: green\">开启</span>");
		            		}
		            	}
		            	DecimalFormat df = new DecimalFormat("0.00");
		            	Float f = spC.getCommand_share();
		            	if(f!=null){
		            		rds.setShare(f);
		            		if(rds.getRate()!=null&&!"".equals(rds.getRate())){
	        					rds.setRate(df.format(Double.parseDouble(rds.getRate())/spC.getSynchro_num()));
	        				}
		            		float incomeb = rds.getIncome_calls()*f;
	        				allIncomeB=allIncomeB+incomeb;
		            	}
					}
	            	Integer delayMinute= mtemp.get(key);
	            	if(dater.equals(recDataStat.getDater())){
		            	if(delayMinute!=null){
		            		if(delayMinute>=20){
		            			rds.setFeecode_number("<span style=\"color: red\">"+rds.getFeecode_number()+"</span>");
		            		}
		            	}else{
		            		rds.setFeecode_number("<span style=\"color: gray\">"+rds.getFeecode_number()+"</span>");
		            	}
	            	}
	            	//System.out.println(rds.getSpnumber());
	            	/*
	            	for (SpCommand spCommand : cmdlist) {
	            		if(spCommand.getCommand_share() != null){
	            			boolean flag1=rds.getCommand().equals(spCommand.getCommand());
	            			boolean flag2=rds.getFeecode_number().equals(spCommand.getFeecode_number());
	            			boolean flag3=rds.getSp_id().equals(spCommand.getSp_id().intValue()+"");
	            			if(flag1 && flag2&&flag3){
	            				rds.setShare(spCommand.getCommand_share());
	            				System.out.println("==================================ll");
	            				if(rds.getRate()!=null&&!"".equals(rds.getRate())){
	            					rds.setRate(df.format(Double.parseDouble(rds.getRate())/spCommand.getSynchro_num()));
	            				}
	            				float incomeb = rds.getIncome_calls()*spCommand.getCommand_share();
	            				allIncomeB=allIncomeB+incomeb;
	            			}
	            		}
					}*/
	            }
	            
	            
	            
	            PageInfo page = new PageInfo(list);
	            page.setTotal(list.size());
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            //List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
		        //modelMap.addAttribute("feecodeList", feecodeList);
		        //modelMap.addAttribute("companyList", companyList);
		        modelMap.addAttribute("allDatas", allDatas);
		        modelMap.addAttribute("allFee", allFee);
		        modelMap.addAttribute("allUsers", allUsers);
		        modelMap.addAttribute("allIncomeUser", allIncomeUser);
		        modelMap.addAttribute("allSuccs", allSuccs);

				DecimalFormat df = new DecimalFormat("#.00");
		        modelMap.addAttribute("allIncomeB", df.format(allIncomeB));
		        modelMap.addAttribute("searchObj", recDataStat);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	
	        }
	        return "stat/showRecDataStat";
	    }
	 
	 /**
	  * Sjm
	  * 模糊搜索上游公司
	  * @param request
	  * @param response
	  * @param searchText 
	  */
	 @RequestMapping("/seachCpCompanyList")
	 public void seachCpCompanyList(HttpServletRequest request, HttpServletResponse response, String searchText){
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = null;
		 List<SearchBean> l = (List<SearchBean>) request.getSession().getAttribute("sssList");
		 SpCompany sc = new SpCompany();
		 sc.setSp_name("%"+searchText+"%");
		 try { 
			if(l==null){
				l = spCompanyService.seachCpCompanyList(sc);
				request.getSession().setAttribute("sssList", l);
			}
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
		 }
		 StringBuffer sb = new StringBuffer();
		 for (int i = 0; i < l.size(); i++) {
			 if(l.get(i).getName().contains(searchText)){
				 sb.append(l.get(i).toString());
			 }
		 }
		 out.print(sb.toString());
		 out.flush();
		 out.close();
	 }
	 
	 /**
	  * Sjm
	  * 模糊搜索计费代码
	  * @param request
	  * @param response
	  * @param searchText 
	  */
	 @RequestMapping("/seachSpFeecodeList")
	 public void seachSpFeecodeList(HttpServletRequest request, HttpServletResponse response, SearchBean search){
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = null;
		 List<SearchBean> l = (List<SearchBean>) request.getSession().getAttribute("sfcList");
		 SpFeecode sf = new SpFeecode();
		 sf.setSp_name("%"+search.getSearchText()+"%");
		 try { 
			if(l==null){
				l = spCompanyService.seachSpFeecodeList(sf);
				request.getSession().setAttribute("sfcList", l);
			}
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
		 }
		 StringBuffer sb = new StringBuffer();
		 if(search.getPid()!=null){
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getPid().equals(search.getPid())&&l.get(i).getName().contains(search.getSearchText())){
					 sb.append(l.get(i).toString());
				 }
			 }
		 }else{
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getName().contains(search.getSearchText())){
					 sb.append(l.get(i).toString());
				 }
			 }
		 }
		 out.print(sb.toString());
		 out.flush();
		 out.close();
	 }
	 
	 @RequestMapping("/searchSpFeecodeTow")
	 public void searchSpFeecodeTow(HttpServletRequest request, HttpServletResponse response, SearchBean search){
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = null;
		 List<SearchBean> l = (List<SearchBean>) request.getSession().getAttribute("sfcList1");
		 SpFeecode sf = new SpFeecode();
		 sf.setSp_name("%"+search.getSearchText()+"%");
		 try { 
			if(l==null){
				l = spCompanyService.searchSpFeecodeTow(sf);
				request.getSession().setAttribute("sfcList1", l);
			}
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
		 }
		 //String s = l.toString().replaceAll(",", "");
		 StringBuffer sb = new StringBuffer();
		 if(search.getPid()!=null){
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getPid().equals(search.getPid())&&l.get(i).getName().contains(search.getSearchText())){
					 sb.append(l.get(i).toStringCode());
				 }
			 }
		 }else{
			 for (int i = 0; i < l.size(); i++) {
				 if(l.get(i).getName().contains(search.getSearchText())){
					 sb.append(l.get(i).toStringCode());
				 }
			 }
		 }
		 out.print(sb.toString());
		 out.flush();
		 out.close();
	 }
	 
	 
	 @RequestMapping("/listRecData")
	 public String listRecData(HttpServletRequest request,RecData recData, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        if(recData==null){
	        	return "err";
	        }
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String dater=sf.format(new Date());
	        if(recData.getStart_time()==null||recData.getEnd_time()==null){
	        	recData.setDater(dater);
	        	recData.setStart_time(dater);
	        	recData.setEnd_time(dater);
	        }else{
	        	recData.setDater(recData.getStart_time());
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+recData.toString());
	        
	        try {
	        	
	            PageHelper.startPage(pageId, 10000);
	            List<RecData> list= recDataStatService.qryRecDataList(recData);
	            PageInfo page = new PageInfo(list);
	            System.out.println(page.getTotal()+"==========="+page.getPageNum()+"======"+page.getPageSize());
	            modelMap.addAttribute("page", page);
	            List<SpFeecode> feecodeList= spFeecodeService.qryCpFeecodeList(new SpFeecode());
		        modelMap.addAttribute("feecodeList", feecodeList);
		        List<Province> proList = provinceService.getProvinceList(new Province());
		        modelMap.addAttribute("proList", proList);
		        modelMap.addAttribute("searchObj", recData);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	        return "stat/listRecData";
	    }
    
	 
	 @RequestMapping("/exportRateDetail")
	 public void exportRateDetail(HttpServletRequest request,HttpServletResponse response,RecDataStat recDataStat, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap)
	            throws Exception {
	        
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String dater=sf.format(new Date());
	        if(recDataStat.getStart_time()==null||recDataStat.getEnd_time()==null){
	        	recDataStat.setDater(dater);
	        	recDataStat.setStart_time(dater);
	        	recDataStat.setEnd_time(dater);
	        }else{
	        	recDataStat.setDater(recDataStat.getStart_time());
	        }
	        //GatewayInfo gatewayInfo = new GatewayInfo();
	        System.out.println("============="+recDataStat.toString());
	        SpCommand command = new SpCommand();
	        List<SpCommand> cmdlist= spCommandService.qryCpCommandList(command);
	        try {
	        	
	            List<RecDataStat> list= recDataStatService.getRecDataStatList(recDataStat);
	            for(RecDataStat rds:list){
	            	for (SpCommand spCommand : cmdlist) {
	            		if(spCommand.getCommand_share() != null){
	            			boolean flag1=rds.getCommand().equalsIgnoreCase(spCommand.getCommand());
	            			boolean flag2=rds.getFeecode_number().equalsIgnoreCase(spCommand.getFeecode_number());
	            			boolean flag3=rds.getSp_id().equals(spCommand.getSp_id().intValue()+"");
	            			if(flag1 && flag2&&flag3){
	            				rds.setShare(spCommand.getCommand_share());
	            				System.out.println("==================================ll");
	            				float incomeb = rds.getIncome_calls()*spCommand.getCommand_share();
	            				DecimalFormat df = new DecimalFormat("#.00");
	            		        String s= df.format(incomeb);
	            		        rds.setIncomeb(s);
	            		        float rateb = rds.getIncome_calls()*spCommand.getCommand_share()/(rds.getSucc_calls()*rds.getFeecode_fee());
	            		        BigDecimal bg = new BigDecimal(rateb);
	            		        float f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
	            		        
	            		        rds.setRateb(String.valueOf(f1));
	            			}
	            		}
					}
	            }

	            RateExcel.createExcelByte(  list, response);
	            
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
	       /// return "stat/listRecData";
	    }
	 
}
