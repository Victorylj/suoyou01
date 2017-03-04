package com.sky.blue.comm.page;

import java.sql.*;

public class Conn {
	public Conn(){}
	//这个是连接数据库的代码，也可以通过连接池等技术实现。
	String driverClass="org.gjt.mm.mysql.Driver";
	String url = "jdbc:mysql://localhost/test?user=root&password=root&useUnicode=true&characterEncoding=gb2312";
	String username="root";
	String password="pwd";
	Connection conn=null;       //初始化
	
	public Connection getConnection()
	{
		 try {
			Class.forName(driverClass);  //加载驱动
		//	System.out.println("jiazaichenggong");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url);  //建立连接conn     
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}
}