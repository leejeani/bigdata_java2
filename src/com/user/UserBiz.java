package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.vo.User;

public class UserBiz<T,V> extends Biz<T, V> {

	UserDao<T,V> dao;
	
	public UserBiz() {
		dao = new UserDao<>();
	}
	
	@Override
	public void register(T obj) throws Exception {
		Connection con = getConnection();
		try {
			dao.insert(con, obj);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public void remove(V id) throws Exception {
		Connection con = getConnection();
		try {
			dao.delete(con, id);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}		
	}

	@Override
	public void modify(T obj) throws Exception {
		Connection con = getConnection();
		try {
			dao.update(con, obj);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(V id) throws Exception {
		T user = null;
		Connection con = getConnection();
		try {
			user = dao.select(con, id);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return user;
	}

	@Override
	public ArrayList<T> get() throws Exception {
		ArrayList<T> list = null;
		Connection con = getConnection();
		try {
			list = dao.select(con);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return list;
	}

}










