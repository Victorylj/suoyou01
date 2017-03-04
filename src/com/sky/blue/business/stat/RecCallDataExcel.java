package com.sky.blue.business.stat;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
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

import com.sky.blue.business.stat.entity.RecCallAllDate;


public class RecCallDataExcel {

	public static void createExcelByte(Collection<RecCallAllDate> dataset, HttpServletResponse response)throws IOException {
        response.setContentType("application/vnd.ms-excel");  
        String codedFileName = null;  
        OutputStream fos = null;  
        
		String[] titles = new String[] { "序号", "上游公司名称", "产品", "初始值",  "上行条数", "成功条数", "电信报盘","联通报盘","移动报盘","总报盘","电信收入","联通收入","移动收入", "总收入", "日期"};
		codedFileName = java.net.URLEncoder.encode("shourutongji", "UTF-8");  
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
		sheet.setColumnWidth(13, (short) 20 * 256);
		sheet.setColumnWidth(14, (short) 20 * 256);
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
				Iterator<RecCallAllDate> it = dataset.iterator();
				int index = 0;
				RecCallAllDate vo = null;
				int allinit=0;
				int allsuccalls=0;
				int allsucc=0;
				double allydfee=0;
				double allltfee=0;
				double alldxfee=0;
				double allfee=0;
				
				double allydrate=0;
				double allltrate=0;
				double alldxrate=0;
				double allrate=0;
				
				while (it.hasNext()) {
					/**
					 * "序号", "营销分类", "营销主题", "商户", "地区", 
					 * "活动时间", "修改时间", "修改人", "状态"
					 **/
					index++;
					vo = it.next();
					row = sheet.createRow(index);
					HSSFCell number = row.createCell(0);
					number.setCellValue(index);

					HSSFCell spname = row.createCell(1);
					spname.setCellValue(vo.getCh_name());
					
					HSSFCell ccpid = row.createCell(2);
					ccpid.setCellValue(vo.getCcp_id());
					
					HSSFCell initnum = row.createCell(3);
					initnum.setCellValue(vo.getInitnum()==null?0:vo.getInitnum());
					
					HSSFCell succcalls = row.createCell(4);
					succcalls.setCellValue(vo.getSucc_calls());

					HSSFCell sussnum = row.createCell(5);
					sussnum.setCellValue(vo.getSucc_num());

					HSSFCell dx_fee = row.createCell(6);
					dx_fee.setCellValue(vo.getDx_fee());
					HSSFCell lt_fee = row.createCell(7);
					lt_fee.setCellValue(vo.getLt_fee());
					HSSFCell yd_fee = row.createCell(8);
					yd_fee.setCellValue(vo.getYd_fee());
					HSSFCell fee = row.createCell(9);
					fee.setCellValue(vo.getFee());
					
					HSSFCell dx_rates = row.createCell(10);
					dx_rates.setCellValue(vo.getDx_rates());
					HSSFCell lt_rates = row.createCell(11);
					lt_rates.setCellValue(vo.getLt_rates());
					HSSFCell yd_rates = row.createCell(12);
					yd_rates.setCellValue(vo.getYd_rates());
					HSSFCell rates = row.createCell(13);
					rates.setCellValue(vo.getRates());
					
					allinit=allinit+(vo.getInitnum()==null?0:vo.getInitnum());
					allsuccalls=allsuccalls+vo.getSucc_calls();
					allsucc=allsucc+vo.getSucc_num();
					
					allydfee=allydfee + Float.parseFloat(vo.getYd_fee()==null?"0":vo.getYd_fee());
					allltfee=allltfee+ Float.parseFloat(vo.getLt_fee()==null?"0":vo.getLt_fee());
					alldxfee=alldxfee+ Float.parseFloat(vo.getDx_fee()==null?"0":vo.getDx_fee());
					allfee=allfee+ Float.parseFloat(vo.getFee()==null?"0":vo.getFee());
					
					allydrate=allydrate + Float.parseFloat(vo.getYd_rates()==null?"0":vo.getYd_rates());
					allltrate=allltrate+ Float.parseFloat(vo.getLt_rates()==null?"0":vo.getLt_rates());
					alldxrate=alldxrate+ Float.parseFloat(vo.getDx_rates()==null?"0":vo.getDx_rates());
					allrate=allrate+ Float.parseFloat(vo.getRates()==null?"0":vo.getRates());
					
					HSSFCell dater = row.createCell(14);
					dater.setCellValue(vo.getDater());
					      		            		            	
				}
				index++;
				row = sheet.createRow(index);
				HSSFCell number = row.createCell(0);
				number.setCellValue("总计");

				HSSFCell spname = row.createCell(1);
				
				HSSFCell ccpid = row.createCell(2);
				
				HSSFCell initnum = row.createCell(3);
				initnum.setCellValue(allinit);
				HSSFCell succcalls = row.createCell(4);
				succcalls.setCellValue(allsuccalls);

				HSSFCell sussnum = row.createCell(5);
				sussnum.setCellValue(allsucc);
				DecimalFormat df = new DecimalFormat("0.00");
				HSSFCell dx_fee = row.createCell(6);
				dx_fee.setCellValue(df.format(alldxfee));
				HSSFCell lt_fee = row.createCell(7);
				lt_fee.setCellValue(df.format(allltfee));
				HSSFCell yd_fee = row.createCell(8);
				yd_fee.setCellValue(df.format(allydfee));
				HSSFCell fee = row.createCell(9);
				fee.setCellValue(df.format(allfee));
				
				HSSFCell dx_rates = row.createCell(10);
				dx_rates.setCellValue(df.format(alldxrate));
				HSSFCell lt_rates = row.createCell(11);
				lt_rates.setCellValue(df.format(allltrate));
				HSSFCell yd_rates = row.createCell(12);
				yd_rates.setCellValue(df.format(allydrate));
				HSSFCell rates = row.createCell(13);
				rates.setCellValue(df.format(allrate));

				HSSFCell dater = row.createCell(14);	
				index++;
				row = sheet.createRow(index);
		
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