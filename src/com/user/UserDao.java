package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.User;

public class UserDao extends Dao {

	public UserDao() {
		super();
	}
	
	@Override
	public void insert(Object obj) throws Exception {
		User user = (User)obj;
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.insertUser);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPwd());
		pstmt.setString(3, user.getName());
		pstmt.executeUpdate();
		close(pstmt);
		close(con);
	}

	@Override
	public void delete(Object obj) throws Exception {
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.deleteUser);
		pstmt.setString(1, obj.toString());
		pstmt.executeUpdate();
		close(pstmt);
		close(con);
	}

	@Override
	public void update(Object obj) throws Exception {
		User user = (User)obj;
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.updateUser);
		pstmt.setString(1, user.getPwd());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getId());
		pstmt.executeUpdate();
		close(pstmt);
		close(con);
	}

	@Override
	public Object select(Object obj) throws Exception {
		// ID�� �Է� �˴ϴ�.
		// User ��ü�� ���� 
		// User ���� ���ش�.
		User user = null;
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.selectUser);
		pstmt.setString(1, obj.toString());
		ResultSet rset = 
				pstmt.executeQuery();
		rset.next();
		String id = rset.getString("ID");
		String pwd = rset.getString("PWD");
		String name = rset.getString("NAME");
		
		user = new User(id, pwd, name);
		
		close(rset);
		close(pstmt);
		close(con);
		
		return user;
	}

	@Override
	public ArrayList<Object> select() throws Exception {
		// ��ü ����� ������ ��ȸ �Ѵ�.
		// ArrayList<Object> ��Ƽ� �����Ѵ�.
		ArrayList<Object> list = 
				new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(Sql.selectAllUser);
		ResultSet rset = 
				pstmt.executeQuery();
		while(rset.next()) {
			User user = null;
			String id = rset.getString("ID");
			String pwd = rset.getString("PWD");
			String name = rset.getString("NAME");
			user = new User(id, pwd, name);
			list.add(user);
		}
		
		close(rset);
		close(pstmt);
		close(con);
		return list;
	}

}








