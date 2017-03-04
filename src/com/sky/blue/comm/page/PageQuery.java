package com.sky.blue.comm.page;


import java.sql.*;
import javax.servlet.http.*;

public class PageQuery { 

	int Offset; // ��¼ƫ���� 
	int Total; // ��¼���� 

	int MaxLine; // ��¼ÿҳ��ʾ��¼�� 
	ResultSet rs; // �����Ľ�� 

	int TPages; // ��ҳ�� 
	int CPages; // ��ǰҳ�� 

	String PageQuery; // ��ҳ��ʾҪ���ݵĲ���
	String Query; // query ���
	String QueryPart; // " FROM " �Ժ�� query ���� 

	String FilePath;

	PagedbClass db; // object of dbclass

//constructer do nothing
	public PageQuery() {
// ÿҳ��ʾʮ��
		MaxLine = 30; 
		db = new PagedbClass(); 
	} 

//********��ȡ��¼*************** 
//����Ҫ�������������������������ӱ��ж�ȡ��Ӧ�ļ�¼ 

	public ResultSet myQuery(String query, HttpServletRequest req) throws SQLException { 

		String query_part, os;
		int begin, offset;

		// ��ȡ " FROM " �Ժ�� query ���
		begin = query.indexOf(" FROM ");
		query_part = query.substring(begin, query.length()).trim(); 

// ����ƫ����
		os = req.getParameter("offset");
		if (os == null) Offset = 0;
		else Offset = Integer.parseInt(os);

// ��ȡ�ļ���
		FilePath = req.getRequestURI(); 

		Query = query;
		QueryPart = query_part; 

// �����ܵļ�¼����
		String SQL = "SELECT Count(*) AS total " + this.QueryPart; 
		rs = db.executeQuery(SQL); 
		if (rs.next()) 
			Total = rs.getInt(1); 

// ���õ�ǰҳ������ҳ��
		TPages = (int)Math.ceil((double)this.Total/this.MaxLine); 
		CPages = (int)Math.floor((double)Offset/this.MaxLine+1); 

// ���������жϣ�ȡ�������¼
		if (Total > 0) { 
			SQL = Query + " LIMIT " + Offset + " , " + MaxLine; 
			rs = db.executeQuery(SQL); 
		} 
		
		return rs; 
	}
	public void close(){
		db.closedb();
	}

// ��ʾ��ҳ��
	public int getTotalPages() { 
		return TPages;
	}

//��ʾ��ǰ����ҳ��
	public int getCurrenPages() { 
		return CPages;
	} 

//**********��ʾ��ҳ��ʾ��************* 
// ��ʾ��ҳ����ҳ����ҳ��βҳ
	public String PageLegend() { 

		String str = ""; 
		int first, next, prev, last;
		first = 0; 
		next = Offset + MaxLine; 
		prev = Offset - MaxLine; 
		last = (this.TPages - 1) * MaxLine; 
		if(Offset >= MaxLine) 
			str += " <A href=" + FilePath + "?offset=" + first + ">��ҳ</A> "; 
		else str += " ��ҳ ";
		if(prev >= 0) 
			str += " <A href=" + FilePath + "?offset=" + prev + ">ǰҳ</A> "; 
		else str += " ǰҳ ";
		if(next < Total) 
			str += " <A href=" + FilePath + "?offset=" + next + ">��ҳ</A> "; 
		else str += " ��ҳ ";
		if(TPages != 0 && CPages < TPages) 
			str += " <A href=" + FilePath + "?offset=" + last + ">βҳ</A>"; 
		else str += " βҳ ";

		str += " ҳ�Σ�" + getCurrenPages() + "/" + getTotalPages() + "ҳ ";
		str += MaxLine + "��/ҳ " + "��" + Total + "��";
		String pageNum;
		return str;
	}
}
