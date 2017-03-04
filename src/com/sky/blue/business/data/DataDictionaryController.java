package com.sky.blue.business.data;

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
import com.sky.blue.business.data.entity.DataDictionary;
import com.sky.blue.business.data.service.IDataDictionaryService;
import com.sky.blue.business.level.entity.AutoCmdLevel;
import com.sky.blue.business.level.entity.AutoLevelRatio;
import com.sky.blue.comm.BaseController;
@Controller
public class DataDictionaryController extends BaseController{
	@Resource(name="dataDictionaryServiceImpl")
	private IDataDictionaryService dataDictionaryService;
	/**
	 * 查询列表
	 * @param request
	 * @param dataDictionary
	 * @param pageId
	 * @param modelMap
	 * @return
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	@RequestMapping("/listDataDictionary")
	public String listAutoLevelRatio(HttpServletRequest request,DataDictionary dataDictionary, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap){
		if(dataDictionary==null){
        	return "err";
        }
		try {
			PageHelper.startPage(pageId, 5);
			List<DataDictionary>  list = dataDictionaryService.qryDataDictionaryList(dataDictionary);
			PageInfo page = null;
			if(list.size()!=0 && list!=null){
				 page = new PageInfo(list);
			}
			//modelMap.addAttribute("searchObj", autoLevelRatio);
			modelMap.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "data/listDataDictionary";
	}
	
	/**
	 * 编辑信息（新增和修改）
	 * @param request
	 * @param dataDictionary
	 * @param modelMap
	 * @create 2014-12-13 am
	 * @author wangjie
	 * @return
	 */
	@RequestMapping("/addDataDictionary")
    public String addAutoLevelRatioInfo(HttpServletRequest request,DataDictionary dataDictionary, ModelMap modelMap){
	 if(dataDictionary==null){
        	return "err";
        }
	 int id =-1;
	 try {
		id=dataDictionaryService.addDataDictionary(dataDictionary);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return "redirect:/listDataDictionary.do";
 }
	 /**
	  * 到达编辑页面
	  * @param request
	  * @param dataDictionary
	  * @param modelMap
	  * @create 2014-12-13 am
	  * @author wangjie
	  * @return
	  */
	@RequestMapping("/editDataDictionary")
    public String editDataDictionary(HttpServletRequest request,DataDictionary dataDictionary, ModelMap modelMap){
		 if(dataDictionary==null){
	        	return "err";
	     }
		 DataDictionary dataDictionaryObj = new DataDictionary();
			 try {
				 if(dataDictionary.getId()!=null){
					 List<DataDictionary>  list = dataDictionaryService.qryDataDictionaryList(dataDictionary);
					 dataDictionaryObj = list.get(0);
				 }
			 } catch (Exception e) {
				e.printStackTrace();
			 }			 
			 modelMap.addAttribute("paramObj", dataDictionaryObj);
			 return "data/editDataDictionary";
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
	  @RequestMapping("/deleteDataDictionary")
	    public void deleteCpMakefeeLink(HttpServletRequest request, HttpServletResponse response,DataDictionary dataDictionary,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+dataDictionary.getArrayIds());
	    		int i= dataDictionaryService.deleteDataDictionary(dataDictionary);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
}
