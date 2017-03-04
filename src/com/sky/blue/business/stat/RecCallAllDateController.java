package com.sky.blue.business.stat;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sky.blue.business.logon.entity.Module;
import com.sky.blue.business.stat.entity.RecCallAllDate;
import com.sky.blue.business.stat.service.IRecCallAllDateService;


@Controller
public class RecCallAllDateController {
	
	@Resource(name="recCallAllDateServiceImpl")
	private IRecCallAllDateService recCallAllDateService;

	 
	 @RequestMapping("/listRecCallAllDate")
	 public String listRecCallAllDate(HttpServletRequest request,RecCallAllDate callAllDate, @RequestParam(defaultValue="1")int pageId, ModelMap modelMap){
		 
		 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	     String dater=sf.format(new Date());
		 if(callAllDate.getStart_time()==null){
			 callAllDate.setStart_time(dater);
		 }
		 //request.getSession().removeAttribute("rcalld");
		 List<RecCallAllDate> l = null;
		try {
			l = recCallAllDateService.listRecCallAllDate(callAllDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 Map<String, List<RecCallAllDate>> m = new HashMap<String, List<RecCallAllDate>>();
		 Map<String, RecCallAllDate> mr = new HashMap<String, RecCallAllDate>();
		 List<RecCallAllDate> ls = new ArrayList<RecCallAllDate>();
		 for (RecCallAllDate r : l) {
			String key = "k_" + r.getCp_id()+r.getCcp_id();
			if(m.get(key)==null){
				m.put(key, new ArrayList<RecCallAllDate>());
				m.get(key).add(r);
				RecCallAllDate rAllDate = new RecCallAllDate();
				rAllDate.setCp_id(r.getCp_id());
				rAllDate.setCh_name(r.getCh_name());
				rAllDate.setSucc_calls(r.getSucc_calls());
				rAllDate.setSucc_num(r.getSucc_num());
				rAllDate.setInitnum(r.getInitnum());
				rAllDate.setRates(r.getRates());
				rAllDate.setDater(r.getDater());
				rAllDate.setFeecode_number("-----------");
				rAllDate.setCcp_id(r.getCcp_id());
				rAllDate.setDater(r.getDater());
				rAllDate.setCommand("-----------");
				ls.add(rAllDate);
				mr.put(key, rAllDate);
			}else{
				m.get(key).add(r);
				RecCallAllDate rAllDate = mr.get(key);
				rAllDate.setSucc_calls(rAllDate.getSucc_calls()+r.getSucc_calls());
				rAllDate.setSucc_num(rAllDate.getSucc_num()+r.getSucc_num());
				DecimalFormat df = new DecimalFormat("0.00");
				//(rAllDate.getRates()==null?0d:rAllDate.getRates())
				rAllDate.setRates(df.format(Double.parseDouble((rAllDate.getRates()==null?"0":rAllDate.getRates()))+Double.parseDouble((r.getRates()==null?"0":r.getRates()))));
			}
		 }
		 request.getSession().setAttribute("rcalld", m);
		 PageInfo page = new PageInfo(ls);
		 page.setTotal(ls.size());
		 page.setPageNum(pageId);
		 page.setList(ls);
		 modelMap.addAttribute("page", page);
		 modelMap.addAttribute("searchObj", callAllDate);
		 return "stat/listRecCallAllDate";
	 }
	 
	 @RequestMapping("/exportlrcAll")
	 public String exportListRecCallAllDate(HttpServletRequest request,RecCallAllDate callAllDate, HttpServletResponse response){
		 try {
			 	List<RecCallAllDate> list = (List<RecCallAllDate>) request.getSession().getAttribute("rcalldgroup");
			 	List<RecCallAllDate> newlist = new ArrayList<RecCallAllDate>();
			 	if(list!=null){
			 		for (RecCallAllDate r : list) {
						if(r.getStatus().intValue()==callAllDate.getStatus().intValue()){
							newlist.add(r);
						}
					}
			 	}else{
			 		//list = recCallAllDateService.exportlistRecCallAllDate(callAllDate);
			 	}
			 	RecCallDataExcel.createExcelByte(newlist, response);
	            
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	System.out.println();
	        }
		 return null;
	 }
	 
	 @SuppressWarnings("unchecked")
	 @RequestMapping("/getRecCallDates")
	 public String getRecCallDates(HttpServletRequest request,RecCallAllDate callAllDate, HttpServletResponse response){
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = null;
		 try { 
			 out = response.getWriter();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 Map<String, List<RecCallAllDate>> m = (Map<String, List<RecCallAllDate>>) request.getSession().getAttribute("rcalld");
		 List<RecCallAllDate> l = null;
		 if(m!=null){
			 l = m.get("k_" + callAllDate.getCp_id()+callAllDate.getCcp_id());
		 }else{
			 try {
				l = recCallAllDateService.listRecCallAllDate(callAllDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 out.print(JSONArray.fromObject(l));
		 out.flush();
		 out.close();
		 return null;
	 }
	 
	 
	 
	 @RequestMapping("/listRecCallAllDates")
	 public String listRecCallAllDates(HttpServletRequest request,RecCallAllDate callAllDate, @RequestParam(defaultValue="1")int pageId, ModelMap modelMap){
		 if(callAllDate.getStart_time()==null){
			 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			 Date d = new Date();
			 d.setDate(d.getDate()-1);
		     String dater=sf.format(d);
			 callAllDate.setStart_time(dater);
			 callAllDate.setStatus(1);
			
		 }
		 if("0".equals(callAllDate.getOp())){
			 callAllDate.setOp(null);
		 }
		 List<RecCallAllDate> l = null;
		 List<RecCallAllDate> l13 = null;
		 //Map<String, RecCallAllDate> sdkSum = null;
		 Map<String, RecCallAllDate> initSum = null;
		 Map<String, RecCallAllDate> initSumOp = null;
		 Map<String, RecCallAllDate> recSum = null;
		 try {
			 l = recCallAllDateService.listCallAllDate(callAllDate);
			 l13=recCallAllDateService.listCallAllData13(callAllDate);
			 //sdkSum = toMap(recCallAllDateService.listSumAllDate(callAllDate),1);
			 if("4".equals(callAllDate.getIsop())){
				 initSumOp = toMap(recCallAllDateService.listInitDate(callAllDate),3);
				 //为了下一步查询总初始化数据，改变条件
				 callAllDate.setIsop("3");
			 }
			 initSum = toMap(recCallAllDateService.listInitDate(callAllDate),2);
			 recSum = toMap(recCallAllDateService.listRecDate(callAllDate),1);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		 HashMap<String,String> h13Temp=new HashMap<String,String>();
		 for(RecCallAllDate r13: l13){
			 if(r13!=null){
				 h13Temp.put(r13.getCcp_id(), r13.getFee());
			 }
		 }
		 Map<String, List<RecCallAllDate>> m = new HashMap<String, List<RecCallAllDate>>();
		 Map<String, RecCallAllDate> mr = new HashMap<String, RecCallAllDate>();
		 List<RecCallAllDate> ls = new ArrayList<RecCallAllDate>();
		 DecimalFormat df = new DecimalFormat("0.00");
		 //a=0;b=0;
		 for (RecCallAllDate r : l) {
			 String key = "k_" + r.getCp_id()+r.getCcp_id();
			 RecCallAllDate rec = getObj(r.getFeecode_number()+r.getCommand(), recSum);
			 if(rec!=null){
				 r.setRateis(rec.getRateis());
				 r.setRatesp(rec.getRatesp());
				 //r.setFee(computeIncome(r,rec,getObj(r.getFeecode_number()+r.getCommand(),sdkSum)));
				 //r.setRates(computeIncome(r,rec.getIncome_calls()*todouble(rec.getCommand_share()),getObj(r.getFeecode_number()+r.getCommand(),sdkSum)));
				 r.setFee(computeIncome(r,rec));
				 if("3".equals(r.getOp())){
					 System.out.println(r.getFee()+"---"+rec.getRates()+"---"+rec.getSucc_num()+"----"+r.getSucc_num());
				 }
				 //b+=r.getSucc_num();
				 //System.out.println("b="+b);
				 //r.setRates(computeIncome(r,rec.getIncome_calls()*todouble(rec.getCommand_share()),rec));
				 r.setRates(computeIncome1(r,rec));
			 }else{
				 r.setRateis("0.00");
				 r.setRatesp("0.00");
			 }
			 if(m.get(key)==null){
				 m.put(key, new ArrayList<RecCallAllDate>());
				 m.get(key).add(r);
				 RecCallAllDate rAllDate = new RecCallAllDate();
				 rAllDate.setOp(r.getOp());
				 rAllDate.setCp_id(r.getCp_id());
				 rAllDate.setCh_name(r.getCh_name());
				 rAllDate.setSucc_calls(r.getSucc_calls());
				 rAllDate.setSucc_num(r.getSucc_num());
				 rAllDate.setInitnum(getObjByVal(getObj(r.getCp_id()+r.getCcp_id(),initSum)));
				 rAllDate.setFee13(h13Temp.get(r.getCcp_id()));
				 rAllDate.setStatus(r.getStatus());
				 rAllDate.setFee(r.getFee());
				 rAllDate.setRateis("------");
				 rAllDate.setRatesp("------");
				 rAllDate.setRates(r.getRates());
				 rAllDate.setFeecode_number("-----------");
				 rAllDate.setCcp_id(r.getCcp_id());
				 rAllDate.setDater(r.getDater());
				 rAllDate.setCommand("-----------");
				 
				 if("1".equals(r.getOp())){
					 rAllDate.setYd_initnum(getObjByVal(getObj(r.getCp_id()+r.getCcp_id()+"1",initSumOp)));
					 rAllDate.setYd_succ_calls(rAllDate.getYd_succ_calls()+r.getSucc_calls());
					 rAllDate.setYd_succ_num(rAllDate.getYd_succ_num()+r.getSucc_num());
					 //(rAllDate.getRates()==null?0d:rAllDate.getRates())
					 rAllDate.setYd_fee(df.format(todouble(r.getFee())));
					 rAllDate.setYd_rates(df.format(todouble(r.getRates())));
				 }
				 if("2".equals(r.getOp())){
					 rAllDate.setLt_initnum(getObjByVal(getObj(r.getCp_id()+r.getCcp_id()+"2",initSumOp)));
					 rAllDate.setLt_succ_calls(rAllDate.getLt_succ_calls()+r.getSucc_calls());
					 rAllDate.setLt_succ_num(rAllDate.getLt_succ_num()+r.getSucc_num());
					 //(rAllDate.getRates()==null?0d:rAllDate.getRates())
					 rAllDate.setLt_fee(df.format(todouble(r.getFee())));
					 rAllDate.setLt_rates(df.format(todouble(r.getRates())));
				 }
				 if("3".equals(r.getOp())){
					 rAllDate.setDx_initnum(getObjByVal(getObj(r.getCp_id()+r.getCcp_id()+"3",initSumOp)));
					 rAllDate.setDx_succ_calls(rAllDate.getDx_succ_calls()+r.getSucc_calls());
					 rAllDate.setDx_succ_num(rAllDate.getDx_succ_num()+r.getSucc_num());
					 //(rAllDate.getRates()==null?0d:rAllDate.getRates())
					 rAllDate.setDx_fee(df.format(todouble(r.getFee())));
					 
					 rAllDate.setDx_rates(df.format(todouble(r.getRates())));
					 System.out.println("AAAA"+rAllDate.getDx_fee()+"=="+r.getFee());
				 }
				 
				 ls.add(rAllDate);
				 mr.put(key, rAllDate);
			 }else{
				 m.get(key).add(r);
				 RecCallAllDate rAllDate = mr.get(key);
				 
				 if("1".equals(r.getOp())){
					 rAllDate.setYd_initnum(getObjByVal(getObj(r.getCp_id()+r.getCcp_id()+"1",initSumOp)));
					 rAllDate.setYd_succ_calls(rAllDate.getYd_succ_calls()+r.getSucc_calls());
					 rAllDate.setYd_succ_num(rAllDate.getYd_succ_num()+r.getSucc_num());
					 //(rAllDate.getRates()==null?0d:rAllDate.getRates())
					 rAllDate.setYd_fee(df.format(todouble(rAllDate.getYd_fee())+todouble(r.getFee())));
					 rAllDate.setYd_rates(df.format(todouble(rAllDate.getYd_rates())+todouble(r.getRates())));
				 }
				 if("2".equals(r.getOp())){
					 rAllDate.setLt_initnum(getObjByVal(getObj(r.getCp_id()+r.getCcp_id()+"2",initSumOp)));
					 rAllDate.setLt_succ_calls(rAllDate.getLt_succ_calls()+r.getSucc_calls());
					 rAllDate.setLt_succ_num(rAllDate.getLt_succ_num()+r.getSucc_num());
					 //(rAllDate.getRates()==null?0d:rAllDate.getRates())
					 rAllDate.setLt_fee(df.format(todouble(rAllDate.getLt_fee())+todouble(r.getFee())));
					 rAllDate.setLt_rates(df.format(todouble(rAllDate.getLt_rates())+todouble(r.getRates())));
				 }
				 if("3".equals(r.getOp())){
					 rAllDate.setDx_initnum(getObjByVal(getObj(r.getCp_id()+r.getCcp_id()+"3",initSumOp)));
					 rAllDate.setDx_succ_calls(rAllDate.getDx_succ_calls()+r.getSucc_calls());
					 rAllDate.setDx_succ_num(rAllDate.getDx_succ_num()+r.getSucc_num());
					 //(rAllDate.getRates()==null?0d:rAllDate.getRates())
					 rAllDate.setDx_fee(df.format(todouble(rAllDate.getDx_fee())+todouble(r.getFee())));
					 rAllDate.setDx_rates(df.format(todouble(rAllDate.getDx_rates())+todouble(r.getRates())));
					 System.out.println("BBBB"+rAllDate.getDx_fee()+"=="+r.getFee());
				 }
				 rAllDate.setSucc_calls(rAllDate.getSucc_calls()+r.getSucc_calls());
				 rAllDate.setSucc_num(rAllDate.getSucc_num()+r.getSucc_num());
				 //(rAllDate.getRates()==null?0d:rAllDate.getRates())
				 rAllDate.setFee(df.format(todouble(rAllDate.getFee())+todouble(r.getFee())));
				 rAllDate.setRates(df.format(todouble(rAllDate.getRates())+todouble(r.getRates())));
			 }
		 }

		 //还原显示条件
		 if("3".equals(callAllDate.getIsop())){
			 callAllDate.setIsop("4");
		 }
		 Collections.sort(ls,new Sort());
		 request.getSession().setAttribute("rcalld", m);
		 request.getSession().setAttribute("rcalldgroup", ls);
		 PageInfo page = new PageInfo(ls);
		 page.setTotal(ls.size());
		 page.setPageNum(pageId);
		 page.setList(ls);
		 modelMap.addAttribute("page", page);
		 modelMap.addAttribute("searchObj", callAllDate);
		
		 return "stat/listRecCallAllDate";
	 }
	 //int a = 0;
	 //int b = 0;
	 private String computeIncome(RecCallAllDate r, RecCallAllDate rec){//, RecCallAllDate sum
		double d = 0;
		try {
			d = Double.parseDouble(rec.getRates()) * r.getSucc_num()/ rec.getSucc_num();
			if( Double.isNaN(d)){
				d=0;
			}
			//System.out.println(1.0* r.getSucc_num()/rec.getSucc_num());
			//a+=r.getSucc_num();
			//System.out.println("a="+a);
		} catch (Exception e) {}
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(d);
	 }
	 private String computeIncome1(RecCallAllDate r, RecCallAllDate rec){
		 double d = 0;
		 try {
			 d = rec.getIncome_calls()*todouble(rec.getCommand_share()) * r.getSucc_num()/ rec.getSucc_num();
			// System.out.println( r.getSucc_num()+"==="+rec+"==="+sum.getSucc_num());
			 if( Double.isNaN(d)){
				 d=0;
			 }
		 } catch (Exception e) {}
		 DecimalFormat df = new DecimalFormat("0.00");
		 return df.format(d);
	 }
	 
	 private double todouble(String s){
		 if(s==null){
			 s="0";
		 }
		 try {
			 return Double.parseDouble(s);
		 } catch (Exception e) {}
		 return 0;
	 }
	 
	 private int getObjByVal(RecCallAllDate r){
		 try {
			 return r.getInitnum();
		 } catch (Exception e) {}
		 return 0;
	 }
	 
	 private RecCallAllDate getObj(String k, Map<String, RecCallAllDate> m){
		 if(k==null||"".equals(k)){
			 return null;
		 }
		 if(m==null){
			 return null;
		 }
		 return m.get(k);
	 }
	 
	 private Map<String, RecCallAllDate> toMap(List<RecCallAllDate> l, int type){
		 if(l==null){return null;}
		 int length = l.size();
		 Map<String, RecCallAllDate> mr = new HashMap<String, RecCallAllDate>();
		 RecCallAllDate r = null;
		 if(type==1){
			 for (int i = 0; i < length; i++) {
				 r = l.get(i);
				 mr.put(r.getFeecode_number()+r.getCommand(), r);
			 }
		 }else if(type==2){
			 for (int i = 0; i < length; i++) {
				 r = l.get(i);
				 mr.put(r.getCp_id()+r.getCcp_id(), r);
			 }
		 }else{
			 for (int i = 0; i < length; i++) {
				 r = l.get(i);
				 mr.put(r.getCp_id()+r.getCcp_id()+r.getOp(), r);
			 }
		 }
		 return mr;
	 } 
	 
	 class Sort implements Comparator<Object> {
			public int compare(Object o1, Object o2) {
				RecCallAllDate t1 = (RecCallAllDate) o1;
				RecCallAllDate t2 = (RecCallAllDate) o2;
				/*if (t1.getCp_id() > t2.getCp_id()) {
					return 1;
				} else if (t1.getCp_id() == t2.getCp_id()) {
					if (t1.getInitnum() > t2.getInitnum()) {
						return -1;
					} else if (t1.getInitnum() == t2.getInitnum()) {
						return 0;
					} else if (t1.getInitnum() < t2.getInitnum()) {
						return 1;
					}
				} else if (t1.getCp_id() < t2.getCp_id()) {
					return -1;
				}*/
				
				if (t1.getInitnum() > t2.getInitnum()) {
					return -1;
				} else if (t1.getInitnum() == t2.getInitnum()) {
					return 0;
				} else if (t1.getInitnum() < t2.getInitnum()) {
					return 1;
				}
				
				return 0;
			}
		}

	/*   String json = "{\"page\":1,\"total\":10,\"rows\":[{\"id\":1,\"name\":\"aaa\",\"cp\":\"bbb\",\"init\":100,\"jf\":100,\"pro\":200,\"sx\":99,\"ok\":999,\"zh\":\"98%\"},{\"id\":1,\"name\":\"aaa\",\"cp\":\"bbb\",\"init\":100,\"jf\":100,\"pro\":200,\"sx\":99,\"ok\":999,\"zh\":\"98%\"},{\"id\":1,\"name\":\"aaa\",\"cp\":\"bbb\",\"init\":100,\"jf\":100,\"pro\":200,\"sx\":99,\"ok\":999,\"zh\":\"98%\"}" +
		
		//   ",{\"id\":1,\"name\":\"aaa\",\"cp\":\"bbb\",\"init\":100,\"jf\":100,\"pro\":200,\"sx\":99,\"ok\":999,\"zh\":\"98%\"}"+
			 
			 "]}";

 		 return json;*/
	
}