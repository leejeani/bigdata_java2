package com.frame;

import java.util.ArrayList;

import com.exception.DuplicatedIDException;
import com.exception.IDNotFoundException;

public interface Biz {
	public void register(Object obj)
			throws DuplicatedIDException;
	public void remove(Object obj)
			throws IDNotFoundException;
	public void modify(Object obj)
			throws IDNotFoundException;
	public Object get(Object obj)
			throws IDNotFoundException;
	public ArrayList<Object> get()
			throws Exception;
}







