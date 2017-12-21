package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.User;

public class UserDao<K,V> extends Dao<K, V> {

	@Override
	public void insert(Connection con, K obj) throws Exception {
		PreparedStatement pstmt = null;
		User user = (User)obj;
		try {
			pstmt = 
			con.prepareStatement(Sql.insertUser);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
	}

	@Override
	public void delete(Connection con, V id) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.deleteUser);
			pstmt.setString(1, id.toString());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}			
	}

	@Override
	public void update(Connection con, K obj) throws Exception {
		PreparedStatement pstmt = null;
		User user = (User)obj;
		try {
			pstmt = 
			con.prepareStatement(Sql.updateUser);
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public K select(Connection con, V id) throws Exception {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectUser);
			pstmt.setString(1, id.toString());
			rset = pstmt.executeQuery();
			rset.next();
			String dbid = rset.getString("ID");
			String pwd = rset.getString("PWD");
			String name = rset.getString("NAME");
			user = new User(dbid, pwd, name);
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (K)user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<K> select(Connection con) throws Exception {
		ArrayList<User> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectallUser);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				User user = null;
				String dbid = rset.getString("ID");
				String pwd = rset.getString("PWD");
				String name = rset.getString("NAME");
				user = new User(dbid, pwd, name);
				list.add(user);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (ArrayList<K>)list;
	}

}








