package com.sky.blue.comm.page;

import java.sql.*;

public class Conn {
	public Conn(){}
	//������������ݿ�Ĵ��룬Ҳ����ͨ�����ӳصȼ���ʵ�֡�
	String driverClass="org.gjt.mm.mysql.Driver";
	String url = "jdbc:mysql://localhost/test?user=root&password=root&useUnicode=true&characterEncoding=gb2312";
	String username="root";
	String password="pwd";
	Connection conn=null;       //��ʼ��
	
	public Connection getConnection()
	{
		 try {
			Class.forName(driverClass);  //��������
		//	System.out.println("jiazaichenggong");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url);  //��������conn     
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}
}