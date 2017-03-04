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

import com.sky.blue.business.stat.entity.RecDataStat;


public class RateExcel {

	public static void createExcelByte(
			Collection<RecDataStat> dataset, HttpServletResponse response)
			throws IOException {
        response.setContentType("application/vnd.ms-excel");  
        String codedFileName = null;  
        OutputStream fos = null;  
        
		String[] titles = new String[] { "序号",
				"SP公司", "运营商", "代码名称", "端口", 
				"指令", "省份", "计费用户数", "收入用户", "计费条数" ,
				"成功条数","单价(元)","A收入(元)","转化率A","B收入(元)","转化率B","日期"
			};
	codedFileName = java.net.URLEncoder.encode("zhuanhualv", "UTF-8");  
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
		sheet.setColumnWidth(15, (short) 20 * 256);
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
				
				 int allDatas = 0;
		            int allFee=0;
		            int allUsers=0;
		            int allIncomeUser=0;
		            int allSuccs=0;
		            float allIncomeb=0;
				Iterator<RecDataStat> it = dataset.iterator();
				int index = 0;
				RecDataStat vo = null;
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
					spname.setCellValue(vo.getSp_name());

					HSSFCell op = row.createCell(2);
					String opstr="";
					if("1".equals(vo.getOp())){
						opstr="移动";
					}else if("2".equals(vo.getOp())){
						opstr="联通";
					}else{
						opstr="电信";
					}
					op.setCellValue(opstr);

					HSSFCell feecodename = row.createCell(3);
					feecodename.setCellValue(vo.getFeecode_name());

					HSSFCell spnumber = row.createCell(4);
					spnumber.setCellValue(vo.getFeecode_number());

					HSSFCell command = row.createCell(5);
					 command.setCellValue(vo.getCommand());
					 
					HSSFCell province = row.createCell(6);
					
					province.setCellValue(vo.getProvince_name()==null?"全国":vo.getProvince_name());
					HSSFCell feeusers = row.createCell(7);
					feeusers.setCellValue(vo.getSucc_users()==null?0:vo.getSucc_users());
					
					HSSFCell incomeuser = row.createCell(8);
					incomeuser.setCellValue(vo.getIncome_user()==null?0:vo.getIncome_user());
					
					HSSFCell feecalls = row.createCell(9);
					feecalls.setCellValue(vo.getSucc_calls()==null?0:vo.getSucc_calls());
					
					HSSFCell incomecalls = row.createCell(10);
					incomecalls.setCellValue(vo.getIncome_calls()==null?0:vo.getIncome_calls());
					
					HSSFCell feemoney = row.createCell(11);
					feemoney.setCellValue(vo.getFeecode_fee());
					
					HSSFCell fee = row.createCell(12);
					fee.setCellValue(vo.getFee()==null?0:vo.getFee());
					
					HSSFCell rate = row.createCell(13);
					rate.setCellValue(vo.getRate());
					
					HSSFCell feeb = row.createCell(14);
					feeb.setCellValue(vo.getIncomeb()==null?"0":vo.getIncomeb());
					
					HSSFCell rateb = row.createCell(15);
					rateb.setCellValue(vo.getRateb());
					
					
					HSSFCell dater = row.createCell(16);
					dater.setCellValue(vo.getDater());
					
					
					if(vo.getSucc_calls()!=null)
		            	allDatas= allDatas+vo.getSucc_calls();
		            	if(vo.getFee()!=null)
		            	allFee=allFee+vo.getFee();
		            	if(vo.getSucc_users()!=null)
		            	allUsers=allUsers+vo.getSucc_users();
		            	if(vo.getIncome_user()!=null)
		            	allIncomeUser=allIncomeUser+vo.getIncome_user();
		            	if(vo.getIncome_calls()!=null){
		            		allSuccs=allSuccs+vo.getIncome_calls();
		            	}
		            	if(vo.getIncomeb()!=null){
		            		allIncomeb=allIncomeb+Float.parseFloat(vo.getIncomeb());
		            	}
				}
				
				DecimalFormat df = new DecimalFormat("#.00");
		        String s= df.format(allIncomeb);
				index++;
				row = sheet.createRow(index);
				row.createCell(7).setCellStyle(style2);
				row.createCell(7).setCellValue(allUsers);
				row.createCell(8).setCellStyle(style2);
				row.createCell(8).setCellValue(allIncomeUser);
				row.createCell(9).setCellStyle(style2);
				row.createCell(9).setCellValue(allDatas);
				row.createCell(10).setCellStyle(style2);
				row.createCell(10).setCellValue(allSuccs);
				row.createCell(12).setCellStyle(style2);
				row.createCell(12).setCellValue(allFee);
				row.createCell(14).setCellStyle(style2);
				row.createCell(14).setCellValue(s);
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