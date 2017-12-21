package com.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<K,V> {
	public void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(ResultSet rset) {
		if(rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void insert(Connection con, K obj) throws Exception;
	public abstract void delete(Connection con,V id) throws Exception;
	public abstract void update(Connection con,K obj) throws Exception;
	public abstract K select(Connection con,V id) throws Exception;
	public abstract ArrayList<K> select(Connection con) throws Exception;
	
	
}









