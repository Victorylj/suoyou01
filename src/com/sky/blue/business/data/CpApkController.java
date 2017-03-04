package com.sky.blue.business.data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.data.entity.CpApkFeedback;
import com.sky.blue.business.data.entity.CpApkVersion;
import com.sky.blue.business.data.service.ICpApkVersionService;
import com.sky.blue.comm.BaseController;
import com.sky.blue.comm.FtpParamBean;
import com.sky.blue.comm.MySFTP;
@Controller
public class CpApkController extends BaseController{
	
	  @Autowired
	  private ICpApkVersionService cpApkVersionService;
	  
	  
	  @RequestMapping("/listCpApkVersion")
	  public String qrycpapkVersion(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId, CpApkVersion apk){
		  	List<CpApkVersion> list = null;
			try {
				PageHelper.startPage(pageId, 10);
				list = cpApkVersionService.qryCpApk(apk);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PageInfo page = null;
			if(list.size()!=0 && list!=null){
				 page = new PageInfo(list);
			}
			request.setAttribute("page", page);
			request.setAttribute("searchObj", apk);
			return "data/listCpApkVersion";
	  }
	  
	  @RequestMapping("/listCpApkFeedback")
	  public String qryCpApkFeedback(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId, CpApkFeedback apkfb){

	        if(apkfb.getStart_time()==null||apkfb.getEnd_time()==null){
			  	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		        String dater=sf.format(new Date());
	        	apkfb.setStart_time(dater);
	        	apkfb.setEnd_time(dater);
	        }
		  	List<CpApkFeedback> list = null;
			try {
				PageHelper.startPage(pageId, 10);
				list = cpApkVersionService.qryCpApkFeedback(apkfb);
			} catch (Exception e) {
				e.printStackTrace();
			}
			PageInfo page = null;
			if(list.size()!=0 && list!=null){
				 page = new PageInfo(list);
			}
			request.setAttribute("page", page);
			request.setAttribute("searchObj", apkfb);
			return "data/listCpApkFeedback";
	  }
	  
	  
	  @RequestMapping("/addcpapk")
	  public String addCpApk(HttpServletRequest request, CpApkVersion apk){
			FtpParamBean ftpBean  = new FtpParamBean();
			String fileurl = apk.getFilename();
			String name = fileurl.substring(fileurl.lastIndexOf("\\")+1,fileurl.lastIndexOf("."));
			fileurl = fileurl.substring(fileurl.lastIndexOf("."));
			String version = apk.getVersion();
			if(version==null||"".equals(version)){
				version = newVersion(null);
				apk.setVersion(version);
			}
			//fileurl = name + version + fileurl;
			//检测name是否存在
			try {
				String [] arr = newFileName(name,version,fileurl);
				fileurl = arr[0];
				apk.setVersion(arr[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			ftpBean.setIp("120.25.151.94");
			ftpBean.setUserName("root");
			ftpBean.setPassword("ym!@#$56");
			ftpBean.setPath("/usr/apache-tomcat-7.0.62/webapps/download/apkfile");
			ftpBean.setFilename(fileurl);
			ftpBean.setFile(apk.getFile());
			MySFTP.up(ftpBean);
			apk.setUrl("http://120.25.151.94:8080//download/apkfile/"+fileurl);
			apk.setFilename(fileurl);
			
			try {
				cpApkVersionService.addCpApk(apk);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return qrycpapkVersion(request, 1, new CpApkVersion());
		 }
	  
	  @RequestMapping("/updCpApkBycp")
	  public String updCpApkBycp(HttpServletRequest request, CpApkVersion apk){
		  try {
				cpApkVersionService.updCpApkVersionByCP(apk);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  return qrycpapkVersion(request, 1, new CpApkVersion());
	  }
	  
	  @RequestMapping("/updcpapk")
	  public String updCpApk(HttpServletRequest request, CpApkVersion apk){
			FtpParamBean ftpBean  = new FtpParamBean();
			ftpBean.setIp("120.25.151.94");
			ftpBean.setUserName("root");
			ftpBean.setPassword("ym!@#$56");
			ftpBean.setFilename(apk.getDelname());
			ftpBean.setPath("/usr/apache-tomcat-7.0.62/webapps/download/apkfile");
			MySFTP.del(ftpBean);
			String fileurl = apk.getFilename();
			String name = fileurl.substring(fileurl.lastIndexOf("\\")+1,fileurl.lastIndexOf("."));
			fileurl = fileurl.substring(fileurl.lastIndexOf("."));
			String version = apk.getVersion();
			version = newVersion(version);
			apk.setVersion(version);
			//fileurl = name + version + fileurl;
			//检测name是否存在
			try {
				String [] arr = newFileName(name,version,fileurl);
				fileurl = arr[0];
				apk.setVersion(arr[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			ftpBean.setFilename(fileurl);
			ftpBean.setFile(apk.getFile());
			MySFTP.up(ftpBean);
			apk.setUrl("http://120.25.151.94:8080/download/apkfile/"+fileurl);
			apk.setFilename(fileurl);		
			try {
				cpApkVersionService.updCpApk(apk);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return qrycpapkVersion(request, 1, new CpApkVersion());
		 }
	  
	  	 private String[] newFileName(String name, String version, String type) throws Exception{
	  		CpApkVersion c = new CpApkVersion();
	  		String s = name + version + type;
			c.setFilename(s);
	  		List<CpApkVersion> l = cpApkVersionService.qryCpApk(c);
			if(l!=null&&l.size()>0){
				version = newVersion(version);
				return newFileName(name,version,type);
			}else{
				return new String[]{s, version};
			}
	  	 }
	  
		  @RequestMapping("/delcpapk")
		  public void delCpApk(HttpServletRequest request, HttpServletResponse response, CpApkVersion apk){
			  	FtpParamBean ftpBean  = new FtpParamBean();
				ftpBean.setIp("120.25.151.94");
				ftpBean.setUserName("root");
				ftpBean.setPassword("ym!@#$56");
				ftpBean.setPath("/usr/apache-tomcat-7.0.62/webapps/download/apkfile");
				ftpBean.setFilename(apk.getFilename());
				int i = MySFTP.del(ftpBean);
				
				try {
					System.out.println("========="+i);
					i = cpApkVersionService.delCpApk(apk);
					System.out.println("========="+i);
					super.ajaxSuccess(response, "删除成功");
				} catch (Exception e) {
					super.ajaxFail(response, "删除失败");
				}
				
		  }
		  
		  
		  @RequestMapping("/delCpApkFeedback")
		  public void delCpApkFeedback(HttpServletRequest request, HttpServletResponse response, CpApkFeedback apkfb){
				try{
		    		System.out.println("========="+apkfb.getId());
		    		int i= cpApkVersionService.delCpApkFeedback(apkfb);
		    		
		    		System.out.println("========="+i);
		    		super.ajaxSuccess(response, "删除成功");
		    	}catch(Exception e){
		    		super.ajaxFail(response, "删除失败");
		    	}	
		  }
	  
	  
		  private  String newVersion(String s){
			  String v = "1.0.0";
			  if(s == null||"".equals(s)){return v;}
			  String[] arr = s.split("\\.");
			  int num = 0;
			  //boolean b = false;
			  for (int i = arr.length-1; i >= 0; i--) {
				 num = toInt(arr[i]);
				 if(num<9 && num>=0){
					 arr[i] = num+1+"";
					 //b = true;
					 break;
				 }
				 if(num>=9){
					 if(i==0){
						 arr[i] = num +1 +"";
					 }else{
						 arr[i] = "0";
					 }
				 }
			  }
			  v = "";
			  for (int i = 0; i < arr.length; i++) {
				v += arr[i]+".";
			  }
			  v = v.substring(0, v.length()-1);
			  return v;
		  }
		  
		  private int toInt(String s){
			  if(s == null||"".equals(s)){return -1;}
			  try {
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
				return -1;
			}
		  }
		  
	  	
		  public static int compareVersion(String version1, String version2) throws Exception {  
			    if (version1 == null || version2 == null) {  
			        throw new Exception("compareVersion error:illegal params.");  
			    }  
			    String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；  
			    String[] versionArray2 = version2.split("\\.");  
			    int idx = 0;  
			    int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值  
			    int diff = 0;  
			    while (idx < minLength  
			            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度  
			            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符  
			        ++idx;  
			    }  
			    //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；  
			    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;  
			    return diff;  
			}  
	  
}
