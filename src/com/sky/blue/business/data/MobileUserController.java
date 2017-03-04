package com.sky.blue.business.data;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.* ;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.blue.business.data.entity.MobileUser;
import com.sky.blue.business.data.entity.RequstInfo;
import com.sky.blue.business.data.service.IMobileUserService;
import com.sky.blue.comm.BaseController;
@Controller
public class MobileUserController extends BaseController{
	
	@Autowired
	private IMobileUserService mobileUserService;
	/**
	 * 查询列表信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	@RequestMapping("/getBlacklistMobile")
	public String qryMobileUser(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId, MobileUser mb){
		List<MobileUser> list = null;
		try {
			PageHelper.startPage(pageId, 10);
			list = mobileUserService.qryMobileUser(mb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo page = null;
		if(list.size()!=0 && list!=null){
			 page = new PageInfo(list);
		}
		request.setAttribute("page", page);
		request.setAttribute("searchObj", mb);
		return "data/listMobileBlacklist";
	}
	/**
	 * 导入EXCEL
	 * @param inputExcel
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/inputExcel")
	public String inputExcel(@RequestParam("file") MultipartFile[] files,MobileUser mb,HttpServletRequest request) throws UnsupportedEncodingException{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		InputStream in;  
		try {
			in=files[0].getInputStream();
			 Workbook workbook = WorkbookFactory.create(in); //这种方式 Excel 2003/2007/2010 都是可以处理的
			 int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量
			 for (int s = 0; s < sheetCount; s++) {
		            Sheet sheet = workbook.getSheetAt(s);
		            int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数
		            //遍历每一行
		            for (int r = 1; r < rowCount; r++) {
		                Row row = sheet.getRow(r);
		                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
		                //遍历每一列
		                for (int c = 0; c < cellCount; c++) {
		                    Cell cell = row.getCell(c);
		                    int cellType = cell.getCellType();
		                    String cellValue = null;
		                    switch(cellType) {
		                        case Cell.CELL_TYPE_STRING: //文本
		                            cellValue = cell.getStringCellValue();
		                            break;
		                        case Cell.CELL_TYPE_NUMERIC: //数字、日期
		                            if(DateUtil.isCellDateFormatted(cell)) {
		                                cellValue = fmt.format(cell.getDateCellValue()); //日期型
		                            }
		                            else {
		                                cellValue = String.valueOf(cell.getNumericCellValue()); //数字
		                            }
		                            break;
		                        case Cell.CELL_TYPE_BOOLEAN: //布尔型
		                            cellValue = String.valueOf(cell.getBooleanCellValue());
		                            break;
		                        case Cell.CELL_TYPE_BLANK: //空白
		                            cellValue = cell.getStringCellValue();
		                            break;
		                        case Cell.CELL_TYPE_ERROR: //错误
		                            cellValue = "错误";
		                            break;
		                        case Cell.CELL_TYPE_FORMULA: //公式
		                            cellValue = "错误";
		                            break;
		                        default:
		                            cellValue = "错误";
		                    }
		                    if (c==0) {
		                    	 mb.setMobile(cellValue);
							}
		                    if (c==1) {
								mb.setDater(cellValue);
							}
		                }
		                 mobileUserService.addMobileUserinfo(mb);
		                System.out.println(mb.getMobile()+":ccccccc"+mb.getDater()+"ccccccc:"+r);
		            }
		        }
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return "redirect:/getBlacklistMobile.do";
	}
	
	@RequestMapping("/getRequstInfoList")
	public String getRequstInfoList(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId, RequstInfo reqinfo){
		List<RequstInfo> list = null;
		try {
			//PageHelper.startPage(pageId, 10);
			int count=reqinfo.getSetCount();
			System.out.println("=================>:"+count);
			list = mobileUserService.qryRequstInfoList(reqinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*PageInfo page = null;
		if(list!=null && list.size()!=0 ){
			 page = new PageInfo(list);
		}*/
		//request.setAttribute("page", page);
		
		request.setAttribute("reqList", list);
		
		request.setAttribute("searchObj", reqinfo);
		return "data/getRequstInfoList";
	}
	@RequestMapping("/getImsiMobileList")
	public String getImsiMobileList(HttpServletRequest request, @RequestParam(defaultValue="1")int pageId, RequstInfo reqinfo){
		List<RequstInfo> list = null;
		System.out.println(reqinfo.getStart_time()+"  :time:  "+reqinfo.getEnd_time()+""+reqinfo.getSetCount());
		try {

			//PageHelper.startPage(pageId, 10);

			list = mobileUserService.getImsiMobileList(reqinfo);
			//System.out.println("mobile------------>:"+list.get(0).getMobile()+",imsi:"+list.get(1).getImsi());
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*PageInfo page = null;
		if(list!=null && list.size()!=0 ){
			 page = new PageInfo(list);
		}
		request.setAttribute("page", page);*/

	request.setAttribute("reqList", list);

		
		request.setAttribute("searchObj", reqinfo);
		return "data/getImsiMobileList";
	}
	
	
	/**
	 * 新增信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	@RequestMapping("/addBlacklistMobile")
	public String addMobileUser(HttpServletRequest request, String mobiles){
		if(mobiles==null||"".equals(mobiles)){
			return "redirect:/getBlacklistMobile.do";
		}
		MobileUser mb = new MobileUser();
		String [] m = mobiles.split("&");
		for (int i = 0; i < m.length; i++) {
			try {
				mb.setMobile(m[i].trim());
				mobileUserService.addMobileUser(mb);	
			} catch (Exception e) {
				logger.debug("mobile:" + m[i].trim());
			}
		}
		return "redirect:/getBlacklistMobile.do";
	}
	
	/**
	 * 删除信息
	 * @param MobileUser
	 * @return
	 * @author sjm
	 */
	@RequestMapping("/delBlacklistMobile")
	public void delMobileUser(HttpServletRequest request, HttpServletResponse response, MobileUser mb){
		try {
			mobileUserService.delMobileUser(mb);
			super.ajaxSuccess(response, "删除成功");
		} catch (Exception e) {
			super.ajaxSuccess(response, "删除失败");
		}
	}
}
