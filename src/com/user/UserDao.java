package com.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.exception.DuplicatedIDException;
import com.exception.IDNotFoundException;
import com.frame.Dao;
import com.vo.User;

public class UserDao extends Dao {

	public UserDao() {
		db = new HashMap<>();
	}
	
	@Override
	public void insert(Object obj) throws DuplicatedIDException {
		User user = (User)obj;
		if(db.containsKey(user.getId())) {
			throw new DuplicatedIDException();
		}else {
			db.put(user.getId(), user);	
			complete("입력이 ");
		}
	}

	@Override
	public void delete(Object obj) throws IDNotFoundException {
		if(db.containsKey(obj)) {
			db.remove(obj);
			complete("삭제 ");
		}else {
			throw new IDNotFoundException();
		}
	}

	@Override
	public void update(Object obj) throws IDNotFoundException {
		User user = (User)obj;
		if(db.containsKey(user.getId())) {
			db.put(user.getId(),user);
			complete("수정 ");
		}else {
			throw new IDNotFoundException();
		}
	}

	@Override
	public Object select(Object obj) throws IDNotFoundException {
		User user = null;
		if(db.containsKey(obj)) {
			user = (User) db.get(obj);	
			complete("한건조회 ");
		}else {
			throw new IDNotFoundException();
		}
		return user;
	}

	@Override
	public ArrayList<Object> select() throws Exception {
		ArrayList<Object> list = 
				new ArrayList<>();
		Set<Object> keys = db.keySet();
		for(Object key:keys) {
			list.add(db.get(key));
		}
		return list;
	}

}








