package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.User;

public class UserDao extends Dao {

	  @Override
	    public void insert(Connection con, Object obj) throws Exception {
	        User user = (User)obj;            
	        PreparedStatement pstmt = null;        
	        // 예외처리 중요
	        try {
	            pstmt = con.prepareStatement(Sql.insertUser);
	            pstmt.setString(1, user.getId());
	            pstmt.setString(2, user.getPwd());
	            pstmt.setString(3, user.getName());
	            pstmt.executeUpdate(); // DB에 반응이 일어나지 않는다.
	        }catch(Exception e) {
	            throw e;
	        }finally {
	            close(pstmt);            
	        }        
	    }
	 
	    @Override
	    public void delete(Connection con, Object obj) throws Exception {
	        PreparedStatement pstmt = null;        
	        try {
	            pstmt = con.prepareStatement(Sql.deleteUser);
	            pstmt.setString(1, (String)obj);
	            pstmt.executeUpdate();
	        } catch (Exception e) {
	            throw e;
	        }finally {
	            close(pstmt);
	        }
	    }
	 
	    @Override
	    public void update(Connection con, Object obj) throws Exception {
	        User user = (User)obj;
	        PreparedStatement pstmt = null;
	        try {
	            pstmt = con.prepareStatement(Sql.updateUser);
	            pstmt.setString(1, user.getPwd());
	            pstmt.setString(2, user.getName());
	            pstmt.setString(3, user.getId());
	            pstmt.executeUpdate();
	        } catch (Exception e) {
	            throw e;
	        } finally {
	            close(pstmt);
	        }
	    }
	    @Override
	    public Object select(Connection con, Object obj) throws Exception {
	        User user = null;
	        PreparedStatement pstmt = null;
	        ResultSet rSet = null;
	        try {
	            pstmt = con.prepareStatement(Sql.selectUser);
	            pstmt.setString(1, (String)obj);
	            rSet = pstmt.executeQuery();
	            rSet.next();
	            String id = rSet.getString("ID");
	            String pwd = rSet.getString("PWD");
	            String name = rSet.getString("NAME");
	            user = new User(id, pwd, name);            
	        } catch (Exception e) {
	            throw e;
	        }finally {
	            close(pstmt);
	            close(rSet);
	        }        
	        return user;
	    }
	 
	    @Override
	    public ArrayList<Object> select(Connection con) throws Exception {
	        ArrayList<Object> list = new ArrayList<>();        
	        PreparedStatement pstmt = null;
	        ResultSet rSet = null;
	        try {
	            pstmt = con.prepareStatement(Sql.selectAllUser);
	            rSet = pstmt.executeQuery();
	            while(rSet.next()) {
	                User user = null;
	                String id = rSet.getString("ID");
	                String pwd = rSet.getString("PWD");
	                String name = rSet.getString("NAME");                
	                user = new User(id, pwd, name);
	                list.add(user);
	            }
	        } catch (Exception e) {
	            throw e;
	        }finally {
	            close(pstmt);
	            close(rSet);
	        }        
	        return list;
	    }

}
