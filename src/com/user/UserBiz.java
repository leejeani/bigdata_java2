package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.frame.Dao;
import com.item.ItemDao;
import com.vo.Item;
import com.vo.User;

public class UserBiz extends Biz{
	
	Dao userDao,itemDao;
	
	public UserBiz() {
		super();
		userDao = new UserDao();
		itemDao = new ItemDao();
	}

	@Override
	public void register(Object obj) throws Exception {
		User user = (User)obj;
		Item item = user.getItem();
		Connection con = getConnection();
		try {
			userDao.insert(con, obj);
			itemDao.insert(con, item);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);	
		}
	}

	@Override
	public void remove(Object obj) throws Exception {
		Connection con = getConnection();
		try {
			userDao.delete(con, obj);
			itemDao.delete(con, obj);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);	
		}		
	}

	@Override
	public void modify(Object obj) throws Exception {
		User user = (User)obj;
		Item item = user.getItem();
		Connection con = getConnection();
		try {
			userDao.update(con, obj);
			itemDao.update(con, item);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);	
		}		
	}

	@Override
	public Object get(Object obj) throws Exception {
		User user = null;
		Item item = null;
		Connection con = getConnection();
		try {
			user = (User)userDao.select(con, obj);
			item = (Item)itemDao.select(con, obj);
			user.setItem(item);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		
		return user;
	}

	@Override
	public ArrayList<Object> get() throws Exception {
		ArrayList<Object> list = null;
		Connection con = getConnection();
		try {
			list = userDao.select(con);
			for(Object u:list) {
				User user = (User)u;
				String id = user.getId();
				Item item = 
				(Item)itemDao.select(con, id);
				user.setItem(item);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		
		return list;
	}

}










