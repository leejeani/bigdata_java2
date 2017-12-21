package com.user;

import java.util.ArrayList;

import com.exception.DuplicatedIDException;
import com.exception.IDNotFoundException;
import com.frame.Biz;
import com.frame.Dao;
import com.vo.User;

public class UserBiz implements Biz {
	
	Dao dao;
	
	public UserBiz() {
		dao = new UserDao();
	}

	@Override
	public void register(Object obj) throws DuplicatedIDException {
		try {
			dao.insert(obj);	
		}catch(DuplicatedIDException e) {
			throw e;
		}
	}

	@Override
	public void remove(Object obj) throws IDNotFoundException {
		try {
			dao.delete(obj);
		}catch(IDNotFoundException e) {
			throw e;
		}
	}

	@Override
	public void modify(Object obj) throws IDNotFoundException {
		try {
			dao.update(obj);
		}catch(IDNotFoundException e) {
			throw e;
		}
	}

	@Override
	public Object get(Object obj) throws IDNotFoundException {
		User user = null;
		user = (User) dao.select(obj);
		return user;
	}

	@Override
	public ArrayList<Object> get() throws Exception {
		return dao.select();
	}

}






