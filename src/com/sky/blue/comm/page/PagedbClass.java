package com.sky.blue.comm.page;


import java.sql.*;


public class PagedbClass {

	Connection con = null; 
	Statement stmt = null;
	ResultSet rs = null; 
	ResultSetMetaData resultsMeta =null;
	int rows = 0;
	public PagedbClass() { 
			con = new Conn().getConnection(); 
	} 
	public ResultSet executeQuery(String sql) throws SQLException{ 
		ResultSet rs = null; 
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); 
			while(rs.next())
				this.rows ++; 
			rs = stmt.executeQuery(sql);
		}
		catch (SQLException e){
			System.out.print("Query:"+e.getMessage());
		} 

		this.rs = rs;
		return rs; 
	}
	public boolean executeUpdate(String sql){ 
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql); 
			return true; 
		}
		catch(SQLException e){
			System.out.print("Update:"+e.getMessage());
			return false;
		}
	}
	public int getColumns(){
		int columns = 0;
		try{
			this.resultsMeta = this.rs.getMetaData();
			columns = this.resultsMeta.getColumnCount();
		}
		catch (SQLException e) {}
		return columns;
	}
	public int getRows(){
		return this.rows;
	}
	public void closedb(){
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}


}
