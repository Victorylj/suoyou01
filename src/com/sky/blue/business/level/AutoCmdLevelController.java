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
import com.sky.blue.business.cpfeeplan.entity.CpMakefeeLink;
import com.sky.blue.business.data.entity.DataDictionary;
import com.sky.blue.business.level.entity.AutoCmdLevel;
import com.sky.blue.business.level.entity.AutoLevelRatio;
import com.sky.blue.business.level.service.IAutoCmdLevelService;
import com.sky.blue.business.spmanager.entity.CpMakefeeItem;
import com.sky.blue.business.spmanager.entity.SpFeecode;
import com.sky.blue.comm.BaseController;
@Controller
public class AutoCmdLevelController extends BaseController {
	@Resource(name="autoCmdLevelServiceImpl")
	private IAutoCmdLevelService autoCmdLevelService;
	/**
	 * 查询新代码优先级分配代码列表信息
	 * @param request	
	 * @param autoCmdLevel	新代码优先级分配代码对象
	 * @param pageId	页码
	 * @param modelMap 
	 * @return String
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	@RequestMapping("/listAutoCmdLevel")
	public String listAutoCmdLevel(HttpServletRequest request,AutoCmdLevel autoCmdLevel, @RequestParam(defaultValue="1")int pageId,ModelMap modelMap){
		if(autoCmdLevel==null){
			return "err";
		}
		try {
			//设置每页显示记录条数		//页码	//记录条数
			PageHelper.startPage(pageId, 10);
			List<AutoCmdLevel>  list = autoCmdLevelService.qryAutoCmdLevelList(autoCmdLevel);
			PageInfo page = null;
			if(list.size()!=0 && list!=null){
				//将列表信息放到分页工具类中进行分页
				 page = new PageInfo(list);
			}
			//modelMap.addAttribute("searchObj", autoLevelRatio);
			//将分页后的列表信息放到作用域中
			modelMap.addAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "level/listAutoCmdLevel";
	}
	
	/**
	 * 编辑新代码优先级分配代码信息（新增和修改）
	 * @param request
	 * @param autoCmdLevel
	 * @param modelMap
	 * @return
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	@RequestMapping("/addAutoCmdLevel")
    public String addAutoLevelRatioInfo(HttpServletRequest request,AutoCmdLevel autoCmdLevel, ModelMap modelMap){
	 if(autoCmdLevel==null){
        	return "err";
     }
	 int id = -1;
	 try {
		id = autoCmdLevelService.addAutoCmdLevel(autoCmdLevel);
	} catch (Exception e) {
		e.printStackTrace();
	}
	 return "redirect:/listAutoCmdLevel.do";
 }
	 
	/**
	 * 到达编辑页面
	 * @param request
	 * @param autoCmdLevel
	 * @param modelMap
	 * @return
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	@RequestMapping("/editAutoCmdLevel")
    public String editAutoLevelRatio(HttpServletRequest request,AutoCmdLevel autoCmdLevel, ModelMap modelMap){
		AutoCmdLevel autoCmdLevelObj=null;
			 try {
				 if(autoCmdLevel==null){
			        	return "err";
			     }
				 autoCmdLevelObj = new AutoCmdLevel();
				 //如果id不为空给对象赋值
				 if(autoCmdLevel.getId()!=null){
					 List<AutoCmdLevel>  list = autoCmdLevelService.qryAutoCmdLevelList(autoCmdLevel);
					 autoCmdLevelObj = list.get(0);
				 }
			 } catch (Exception e) {
				e.printStackTrace();
			 }			 
			 modelMap.addAttribute("paramObj", autoCmdLevelObj);
			 return "level/editAutoCmdLevel";
	}
	
	/**
	 * 修改新代码优先级分配状态
	 * @param request
	 * @param response
	 * @param autoCmdLevel
	 * @param modelMap
	 * @throws Exception
	 * @create 2014-12-13 am
	 * @author wangjie
	 */
	@RequestMapping("/closeOrOpenAutoCmdLevel")
    public void closeOrOpenCpMakefeeItem(HttpServletRequest request, HttpServletResponse response,AutoCmdLevel autoCmdLevel,ModelMap modelMap)
            throws Exception {
    	try{
    		System.out.println("========="+autoCmdLevel.getArrayIds());
    		int i= autoCmdLevelService.closeOrOpenAutoCmdLevel(autoCmdLevel);
    		
    		System.out.println("========="+i);
    		super.ajaxSuccess(response, "操作成功");
    	}catch(Exception e){
    		e.printStackTrace();
    		super.ajaxFail(response, "操作失败");
    	}
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
	  @RequestMapping("/deleteAutoCmdLevel")
	    public void deleteCpMakefeeLink(HttpServletRequest request, HttpServletResponse response,AutoCmdLevel autoCmdLevel,ModelMap modelMap)
	            throws Exception {
	    	try{
	    		System.out.println("========="+autoCmdLevel.getArrayIds());
	    		int i= autoCmdLevelService.deleteAutoCmdLevel(autoCmdLevel);
	    		System.out.println("========="+i);
	    		super.ajaxSuccess(response, "删除成功");
	    	}catch(Exception e){
	    		
	    		super.ajaxFail(response, "删除失败");
	    	}
	    	
	      
	    }
}
