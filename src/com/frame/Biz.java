package com.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Biz {

	public Biz() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		String id = "test2";
		String pwd = "test2";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null;
		try {
			con = 
			DriverManager.getConnection(url, id, pwd);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void register(Object obj) 
	throws Exception;
	public abstract void remove(Object obj) 
	throws Exception;
	public abstract void modify(Object obj) 
	throws Exception;
	public abstract Object get(Object obj) 
	throws Exception;
	public abstract ArrayList<Object> get() 
	throws Exception;
}
















