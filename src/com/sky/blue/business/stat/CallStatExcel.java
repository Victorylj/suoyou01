package com.sky.blue.business.stat;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.sky.blue.business.stat.entity.CallStat;
import com.sky.blue.business.stat.entity.RecDataStat;


public class CallStatExcel {

	public static void createExcelByte(
			Collection<CallStat> dataset, HttpServletResponse response)
			throws IOException {
        response.setContentType("application/vnd.ms-excel");  
        String codedFileName = null;  
        OutputStream fos = null;  
        
		String[] titles = new String[] { "日期",
				"产品", "渠道", "渠道编号", "有效用户数", 
				"下发协议次数", "下发协议用户数", "过滤用户","下发短信用户","总访问次数", "总访问用户数","比值"
			};
	codedFileName = java.net.URLEncoder.encode("fangwenliang", "UTF-8");  
    response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");  
    fos = response.getOutputStream();  
		
		/** 声明一个工作薄 **/
		HSSFWorkbook workbook = new HSSFWorkbook();
		/** 生成一个表格 **/
		HSSFSheet sheet = workbook.createSheet("ss");
		/** 设置表格默认列宽度 **/
		sheet.setDefaultColumnWidth((short) 25 * 256);
		sheet.setColumnWidth(0, (short) 20 * 256);
		sheet.setColumnWidth(1, (short) 20 * 256);
		sheet.setColumnWidth(2, (short) 25 * 256);
		sheet.setColumnWidth(3, (short) 20 * 256);
		sheet.setColumnWidth(4, (short) 20 * 256);
		sheet.setColumnWidth(5, (short) 20 * 256);
		sheet.setColumnWidth(6, (short) 20 * 256);
		sheet.setColumnWidth(7, (short) 20 * 256);
		sheet.setColumnWidth(8, (short) 20 * 256);
		sheet.setColumnWidth(9, (short) 20 * 256);
		sheet.setColumnWidth(10, (short) 20 * 256);
		sheet.setColumnWidth(11, (short) 20 * 256);
		sheet.setColumnWidth(12, (short) 20 * 256);
		/** 生成一个样式 **/
		HSSFCellStyle style = workbook.createCellStyle();

		/** 设置这些样式 **/
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		/** 生成一个字体 **/
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		/** 把字体应用到当前的样式 **/
		style.setFont(font);
		/** 生成并设置另一个样式 **/
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.WHITE.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/** 生成另一个字体 **/
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		/** 把字体应用到当前的样式 **/
		style2.setFont(font2);

		/** 产生表格标题行 **/
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(titles[i]);
			cell.setCellValue(text);
		}
		try {
			/** 遍历集合数据，产生数据行 **/
			if (null != dataset) {
				
				  int allSuccCalls=0;
		            int allSuccUsers=0;
		           // int allFailCalls=0;
		          //  int allFailUsers=0;
		            int allCalls=0;
		            int allUsers=0;
		            int allInitnum=0;
		            int allSmsNum=0;	
		            int allSmsReportNum=0;
				Iterator<CallStat> it = dataset.iterator();
				int index = 0;
				CallStat vo = null;
				while (it.hasNext()) {
					/**
					 * "序号", "营销分类", "营销主题", "商户", "地区", 
					 * "活动时间", "修改时间", "修改人", "状态"
					 **/
					index++;
					vo = it.next();
					row = sheet.createRow(index);
					HSSFCell dater = row.createCell(0);
					dater.setCellValue(vo.getDater());

					HSSFCell product = row.createCell(1);
					product.setCellValue(vo.getProduct_name());
 
					HSSFCell cp = row.createCell(2);
					cp.setCellValue(vo.getCp_name());

					HSSFCell cpid = row.createCell(3);
					cpid.setCellValue(vo.getCcp_id());

					HSSFCell init = row.createCell(4);
					 init.setCellValue(vo.getInitnum()==null?0:vo.getInitnum());
					 
					 HSSFCell feecalls = row.createCell(5);
						feecalls.setCellValue(vo.getSucc_calls()==null?0:vo.getSucc_calls());
					HSSFCell feeusers = row.createCell(6);
					feeusers.setCellValue(vo.getSucc_users()==null?0:vo.getSucc_users());
							
					HSSFCell smsf = row.createCell(7);
					if(".".equals(vo.getRemarks())){
						smsf.setCellValue((vo.getSmsNum()==null?0:vo.getSmsNum())+vo.getRemarks());
					}else{
						smsf.setCellValue((vo.getSmsNum()==null?0:vo.getSmsNum()));
					}
					
					HSSFCell smsr = row.createCell(8);
					smsr.setCellValue(vo.getSmsReportNum()==null?0:vo.getSmsReportNum());
					
					HSSFCell allcalls = row.createCell(9);
					allcalls.setCellValue(vo.getAll_calls()==null?0:vo.getAll_calls());
					
					HSSFCell allusers = row.createCell(10);
					allusers.setCellValue(vo.getAll_users()==null?0:vo.getAll_users());
					
					HSSFCell rate = row.createCell(11);
					
					rate.setCellValue(vo.getRate()==null?"-":vo.getRate());
					
					
					if(vo.getSucc_calls()!=null)
						allSuccCalls=allSuccCalls+  (vo.getSucc_calls()==null?0:vo.getSucc_calls());
	            	allSuccUsers=allSuccUsers+(vo.getSucc_users()==null?0:vo.getSucc_users());
	            	//allFailCalls=allFailCalls+vo.getFail_calls();
	            	//allFailUsers=allFailUsers+vo.getFail_users();
	            	allCalls=allCalls+(vo.getAll_calls()==null?0:vo.getAll_calls());
	            	allUsers=allUsers+(vo.getAll_users()==null?0:vo.getAll_users());
	            	allInitnum = allInitnum+(vo.getInitnum()==null?0:vo.getInitnum());
	            	allSmsNum=allSmsNum+(vo.getSmsNum()==null?0:vo.getSmsNum());
	            	allSmsReportNum=allSmsReportNum+(vo.getSmsReportNum()==null?0:vo.getSmsReportNum());
				}
				index++;
				row = sheet.createRow(index);
				row.createCell(4).setCellStyle(style2);
				row.createCell(4).setCellValue(allInitnum);
				row.createCell(5).setCellStyle(style2);
				row.createCell(5).setCellValue(allSuccCalls);
				row.createCell(6).setCellStyle(style2);
				row.createCell(6).setCellValue(allSuccUsers);
				row.createCell(7).setCellStyle(style2);
				row.createCell(7).setCellValue(allSmsNum);
				row.createCell(8).setCellStyle(style2);
				row.createCell(8).setCellValue(allSmsReportNum);
				
				row.createCell(9).setCellStyle(style2);
				row.createCell(9).setCellValue(allCalls);
				row.createCell(10).setCellStyle(style2);
				row.createCell(10).setCellValue(allUsers);
				
				
			}
			workbook.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != fos) {
				fos.flush();
				fos.close();
			}
		}
	}
}