package com.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao {
	String id = "test2";
	String pwd = "test2";
	String address = 
	"jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	public Dao() {
		// 1. Oracle JDBC Driver Loading
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		// 2. Connect to Oracle Database
		try {
			con = DriverManager.getConnection(address, 
					id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("접속 오류");
		}
		return con;
	}
	
	public void close(ResultSet rset) {
		if(rset != null) {
			try {
			rset.close();
			}catch(Exception e) {}
		}
	}
	
	public void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(Exception e) {}
		}
	}
	
	public void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			}catch(Exception e) {}
		}
	}
	
	
	public abstract void insert(Object obj)
			throws Exception;
	public abstract void delete(Object obj)
			throws Exception;
	public abstract void update(Object obj)
			throws Exception;
	public abstract Object select(Object obj)
			throws Exception;
	public abstract ArrayList<Object> select()
			throws Exception;
	
	
}







