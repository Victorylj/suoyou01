package com.sky.blue.business.spmanager;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sky.blue.business.spmanager.entity.FilterSpCom;
import com.sky.blue.business.spmanager.service.IFilterSpComService;
import com.sky.blue.comm.BaseController;
@Controller
public class FilterSpComController extends BaseController {
	
	@Autowired
	private IFilterSpComService filterSpComService;
	
	@RequestMapping("/listFilterSpCom")
	public void getFilterSpCom(HttpServletRequest request, HttpServletResponse response, FilterSpCom f) {
		 response.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=UTF-8");
	     List<FilterSpCom> li = filterSpComService.getFilterSpCom(f);
	     PrintWriter out = null;
	     try { 
			
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
	     }
	     out.print(JSONArray.fromObject(li));
		 out.flush();
		 out.close();
	}
	
	@RequestMapping("/delFilterSpCom")
	public void delFilterSpCom(HttpServletRequest request, HttpServletResponse response, FilterSpCom f) {
		 response.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=UTF-8");
	     int num = filterSpComService.delFilterSpCom(f);
	     PrintWriter out = null;
	     try { 
			
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
	     }
	     out.print(num);
		 out.flush();
		 out.close();
	}
	
	@RequestMapping("/addFilterSpCom")
	public void addFilterSpCom(HttpServletRequest request, HttpServletResponse response, FilterSpCom f) {
		 response.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=UTF-8");
	     filterSpComService.addFilterSpCom(f);
	     PrintWriter out = null;
	     try { 
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
	     }
	     out.print(f.getId());
		 out.flush();
		 out.close();
	}
	
	@RequestMapping("/updFilterSpCom")
	public void updFilterSpCom(HttpServletRequest request, HttpServletResponse response, FilterSpCom f) {
		 response.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=UTF-8");
	     int num = filterSpComService.updFilterSpCom(f);
	     PrintWriter out = null;
	     try { 
			
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
	     }
	     out.print(num);
		 out.flush();
		 out.close();
	}
	
	@RequestMapping("/updFilterSpComById")
	public void updFilterSpComById(HttpServletRequest request, HttpServletResponse response, FilterSpCom f) {
		 response.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset=UTF-8");
	     int num = filterSpComService.updFilterSpComById(f);
	     PrintWriter out = null;
	     try { 
			
			out = response.getWriter();
		 } catch (Exception e) {
			e.printStackTrace();
	     }
	     out.print(num);
		 out.flush();
		 out.close();
	}
}
