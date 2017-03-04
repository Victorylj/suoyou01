package com.sky.blue.business.data;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sky.blue.business.data.entity.MobileUserWihte;
import com.sky.blue.business.data.service.IMobileUserWihteService;
import com.sky.blue.comm.BaseController;
@Controller
public class MobileUserWihteController extends BaseController{
	@Autowired
	private IMobileUserWihteService mobileUserWihteService;
	
	/**
	 * 查询列表信息
	 * @param MobileUserWihte
	 * @return
	 * @author fys
	 */
	@RequestMapping("/qryMobileUserWihte")
	public String qryMobileUserWihte(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId,MobileUserWihte mbg){
		List<MobileUserWihte> list=null;
		try {
			PageHelper.startPage(pageId, 10);
			list =mobileUserWihteService.qryMobileUserWihte(mbg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo page = null;
		if(list.size()!=0 && list!=null){
			 page = new PageInfo(list);
		}
		request.setAttribute("page", page);
		request.setAttribute("searchObj", mbg);
		return "data/listMobileWihtelist";
	};
	@RequestMapping("/upqryMobileUserWihte")
	public void upMobileUserWihte(HttpServletRequest request,MobileUserWihte mbg,HttpServletResponse response){
		
		
		
		try {
			mbg =mobileUserWihteService.upMobileUserWihte(mbg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("paramObj", mbg);
		
		Gson gson = new Gson();
        try {
			response.getWriter().write(gson.toJson(mbg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*return "data/editMobileUserWihte";*/
	};
	/**
	 * 新增信息
	 * @param MobileUserWihte
	 * @return
	 * @author fys
	 */
	@RequestMapping("/addMobileUserWihte")
	public String addMobileUserWihte(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId,MobileUserWihte mbg) {
		
		try {
			mobileUserWihteService.addMobileUserWihte(mbg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/qryMobileUserWihte.do";
	};
	@RequestMapping("/addMobileUserWihteinfo")
	public String addMobileUserWihteinfo(MobileUserWihte mbg) {

		return null;
	};
	/**
	 * 修改信息
	 * @param MobileUserWihte
	 * @return
	 * @author fys
	 */
	@RequestMapping("/updMobileUserWihte")
	public String updMobileUserWihte(MobileUserWihte mbg) {
		if(mbg.getId()==null){
			try {
				mobileUserWihteService.addMobileUserWihte(mbg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			mobileUserWihteService.updMobileUserWihte(mbg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/qryMobileUserWihte.do";
	};
	/**
	 * 删除信息
	 * @param MobileUserWihte
	 * @return
	 * @author fys
	 */
	@RequestMapping("/delMobileUserWihte")
	public void delMobileUserWihte(HttpServletRequest request, HttpServletResponse response,MobileUserWihte mbg) {
			try {
				System.out.println("====="+mbg.getId());
				mobileUserWihteService.delMobileUserWihte(mbg);
				super.ajaxSuccess(response, "删除成功");
			} catch (Exception e) {
				super.ajaxSuccess(response, "删除失败");
			}
	};
	
}
