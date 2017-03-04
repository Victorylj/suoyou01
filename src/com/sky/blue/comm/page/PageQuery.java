package com.sky.blue.comm.page;


import java.sql.*;
import javax.servlet.http.*;

public class PageQuery { 

	int Offset; // 记录偏移量 
	int Total; // 记录总数 

	int MaxLine; // 记录每页显示记录数 
	ResultSet rs; // 读出的结果 

	int TPages; // 总页数 
	int CPages; // 当前页数 

	String PageQuery; // 分页显示要传递的参数
	String Query; // query 语句
	String QueryPart; // " FROM " 以后的 query 部分 

	String FilePath;

	PagedbClass db; // object of dbclass

//constructer do nothing
	public PageQuery() {
// 每页显示十行
		MaxLine = 30; 
		db = new PagedbClass(); 
	} 

//********读取记录*************** 
//　主要工作函数，根据所给的条件从表中读取相应的记录 

	public ResultSet myQuery(String query, HttpServletRequest req) throws SQLException { 

		String query_part, os;
		int begin, offset;

		// 截取 " FROM " 以后的 query 语句
		begin = query.indexOf(" FROM ");
		query_part = query.substring(begin, query.length()).trim(); 

// 计算偏移量
		os = req.getParameter("offset");
		if (os == null) Offset = 0;
		else Offset = Integer.parseInt(os);

// 获取文件名
		FilePath = req.getRequestURI(); 

		Query = query;
		QueryPart = query_part; 

// 计算总的记录条数
		String SQL = "SELECT Count(*) AS total " + this.QueryPart; 
		rs = db.executeQuery(SQL); 
		if (rs.next()) 
			Total = rs.getInt(1); 

// 设置当前页数和总页数
		TPages = (int)Math.ceil((double)this.Total/this.MaxLine); 
		CPages = (int)Math.floor((double)Offset/this.MaxLine+1); 

// 根据条件判断，取出所需记录
		if (Total > 0) { 
			SQL = Query + " LIMIT " + Offset + " , " + MaxLine; 
			rs = db.executeQuery(SQL); 
		} 
		
		return rs; 
	}
	public void close(){
		db.closedb();
	}

// 显示总页数
	public int getTotalPages() { 
		return TPages;
	}

//显示当前所在页数
	public int getCurrenPages() { 
		return CPages;
	} 

//**********显示翻页提示栏************* 
// 显示首页、下页、上页、尾页
	public String PageLegend() { 

		String str = ""; 
		int first, next, prev, last;
		first = 0; 
		next = Offset + MaxLine; 
		prev = Offset - MaxLine; 
		last = (this.TPages - 1) * MaxLine; 
		if(Offset >= MaxLine) 
			str += " <A href=" + FilePath + "?offset=" + first + ">首页</A> "; 
		else str += " 首页 ";
		if(prev >= 0) 
			str += " <A href=" + FilePath + "?offset=" + prev + ">前页</A> "; 
		else str += " 前页 ";
		if(next < Total) 
			str += " <A href=" + FilePath + "?offset=" + next + ">后页</A> "; 
		else str += " 后页 ";
		if(TPages != 0 && CPages < TPages) 
			str += " <A href=" + FilePath + "?offset=" + last + ">尾页</A>"; 
		else str += " 尾页 ";

		str += " 页次：" + getCurrenPages() + "/" + getTotalPages() + "页 ";
		str += MaxLine + "条/页 " + "共" + Total + "条";
		String pageNum;
		return str;
	}
}
