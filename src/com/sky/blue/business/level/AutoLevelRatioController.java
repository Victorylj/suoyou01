package com.sky.blue.business.level;

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
import com.sky.blue.business.level.entity.AutoCmdLevel;
import com.sky.blue.business.level.entity.AutoLevelRatio;
import com.sky.blue.business.level.service.IAutoLevelRatioService;
import com.sky.blue.comm.BaseController;
@Controller
public class AutoLevelRatioController extends BaseController {
	@Resource(name="autoLevelRatioServiceImpl")
	private IAutoLevelRatioService autoLevelRatioService;
	/**
	 * 新代码列表信息
	 * @param request
	 * @param autoLevelRatio
	 * @param pageId
	 * @param modelMap
	 * @return
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	@RequestMapping("/listAutoLevelRatio")
	public String listAutoLevelRatio(HttpServletRequest request,AutoLevelRatio autoLevelRatio, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap){
		if(autoLevelRatio==null){
        	return "err";
        }
		try {
			//设置每页显示记录条数		//页码	//记录条数
			PageHelper.startPage(pageId, 10);
			List<AutoLevelRatio>  list = autoLevelRatioService.qryAutoLevelRatioList(autoLevelRatio);
			PageInfo page = null;
			if(list.size()!=0 && list!=null){
				//将列表信息放到分页工具类中进行分页
				 page = new PageInfo(list);
			}
			//将分页后的列表信息放到作用域
			modelMap.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "level/listAutoLevelRatio";
	}
	
	/**
	 * 编辑优先级分配（新增和添加）
	 * @param request
	 * @param autoLevelRatio
	 * @param modelMap
	 * @return
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	@RequestMapping("/addAutoLevelRatio")
    public String addAutoLevelRatioInfo(HttpServletRequest request,AutoLevelRatio autoLevelRatio, ModelMap modelMap){
	 if(autoLevelRatio==null){
        	return "err";
        }
	 int id = -1;
	 try {
		id = autoLevelRatioService.addAutoLevelRatio(autoLevelRatio);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 System.out.println(id+"============");
	 return "redirect:/listAutoLevelRatio.do";
 }
	 
	/**
	 * 到达编辑页面
	 * @param request
	 * @param autoLevelRatio
	 * @param modelMap
	 * @return
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	@RequestMapping("/editAutoLevelRatio")
    public String editAutoLevelRatio(HttpServletRequest request,AutoLevelRatio autoLevelRatio, ModelMap modelMap){
		 if(autoLevelRatio==null){
	        	return "err";
	     }
		 AutoLevelRatio autoLevelRatioObj = new  AutoLevelRatio();
		 
			 try {
				 if(autoLevelRatio.getId()!=null){
					 List<AutoLevelRatio>  list = autoLevelRatioService.qryAutoLevelRatioList(autoLevelRatio);
					 autoLevelRatioObj = list.get(0);
				 }
			 } catch (Exception e) {
				e.printStackTrace();
			 }			 
			 modelMap.addAttribute("paramObj", autoLevelRatioObj);
			 return "level/editAutoLevelRatio";
	}
	/**
	 * 删除信息
	 * @param request
	 * @param response
	 * @param autoLevelRatio
	 * @param modelMap
	 * @throws Exception
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	 @RequestMapping("/deleteAutoLevelRatio")
	    public void deleteCpMakefeeLink(HttpServletRequest request, HttpServletResponse response,AutoLevelRatio autoLevelRatio,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+autoLevelRatio.getArrayIds());
	    		int i= autoLevelRatioService.deleteAutoLevelRatio(autoLevelRatio);
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
}
