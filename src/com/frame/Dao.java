package com.frame;

import java.util.ArrayList;
import java.util.HashMap;

import com.exception.DuplicatedIDException;
import com.exception.IDNotFoundException;

public abstract class Dao {
	protected HashMap<Object,Object> db;
	public void complete(String str) {
		System.out.println(str+"가 완료되었습니다.");
	}
	public abstract void insert(Object obj)
			throws DuplicatedIDException;
	public abstract void delete(Object obj)
			throws IDNotFoundException;
	public abstract void update(Object obj)
			throws IDNotFoundException;
	public abstract Object select(Object obj)
			throws IDNotFoundException;
	public abstract ArrayList<Object> select()
			throws Exception;
}









