package com.sky.blue.business.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sky.blue.business.data.entity.MobileUser;
import com.sky.blue.business.data.entity.MobileUserGreen;
import com.sky.blue.business.data.service.IMobileUserGreenService;
import com.sky.blue.comm.BaseController;
@Controller
public class MobileUserGreenController extends BaseController{
	@Autowired
	private IMobileUserGreenService mobileUserGreenService;
	
	/**
	 * 查询列表信息
	 * @param MobileUserGreen
	 * @return
	 * @author fys
	 */
	@RequestMapping("/qryMobileUserGreen")
	public String qryMobileUserGreen(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId,MobileUserGreen mbg){
		List<MobileUserGreen> list=null;
		try {
			PageHelper.startPage(pageId, 10);
			list =mobileUserGreenService.qryMobileUserGreen(mbg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo page = null;
		if(list.size()!=0 && list!=null){
			 page = new PageInfo(list);
		}
		request.setAttribute("page", page);
		request.setAttribute("searchObj", mbg);
		return "data/listMobileGreenlist";
	};
	@RequestMapping("/upqryMobileUserGreen")
	public void upMobileUserGreen(HttpServletRequest request,MobileUserGreen mbg,HttpServletResponse response){
		try {
			mbg =mobileUserGreenService.upMobileUserGreen(mbg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//request.setAttribute("paramObj", mbg);

		Gson gson = new Gson();
        try {
			response.getWriter().write(gson.toJson(mbg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*return "data/editMobileUserGreen";*/
	};
	/**
	 * 新增信息
	 * @param MobileUserGreen
	 * @return
	 * @author fys
	 */
	@RequestMapping("/addMobileUserGreen")
	public String addMobileUserGreen(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId,MobileUserGreen mbg) {
		
		try {
			System.out.println(mbg.getMobile());
			mobileUserGreenService.addMobileUserGreen(mbg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/qryMobileUserGreen.do";
	};
	@RequestMapping("/addMobileUserGreeninfo")
	public String addMobileUserGreeninfo(MobileUserGreen mbg) {

		return null;
	};
	/**
	 * 添加修改信息
	 * @param MobileUserGreen
	 * @return
	 * @author fys
	 */
	@RequestMapping("/updMobileUserGreen")
	public String updMobileUserGreen(MobileUserGreen mbg) {
		if(mbg.getId()==null){
			try {
				mobileUserGreenService.addMobileUserGreen(mbg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			mobileUserGreenService.updMobileUserGreen(mbg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/qryMobileUserGreen.do";
	};
	/**
	 * 删除信息
	 * @param MobileUserGreen
	 * @return
	 * @author fys
	 */
	@RequestMapping("/delMobileUserGreen")
	public void delMobileUserGreen(HttpServletRequest request, HttpServletResponse response,MobileUserGreen mbg) {
			try {
				System.out.println("====="+mbg.getId());
				mobileUserGreenService.delMobileUserGreen(mbg);
				super.ajaxSuccess(response, "删除成功");
			} catch (Exception e) {
				super.ajaxSuccess(response, "删除失败");
			}
	};
	
}
