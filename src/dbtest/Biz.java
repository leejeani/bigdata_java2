package dbtest;

import java.util.ArrayList;

public class Biz {
	Dao dao;
	public Biz() {
		dao = new Dao();
	}
	public void register(Object obj) 
			throws DuplicatedIDException{
		try {
			dao.insert(obj);	
		}catch(DuplicatedIDException e) {
			throw e;
		}
		
	}
	public void remove(Object obj) 
			throws IDNotFoundException{
		try {
			dao.delete(obj);
		}catch(IDNotFoundException e) {
			throw e;
		}
		
	}
	public void modify(Object obj) 
			throws IDNotFoundException{
		try {
			dao.update(obj);		
		}catch(IDNotFoundException e) {
			throw e;
		}
	}
	public Object get(Object obj) 
			throws IDNotFoundException{
		User user = null;
		user = (User) dao.select(obj);
		return  user;
	}
	public ArrayList<Object> get() {
		ArrayList<Object> list = null;
		list = dao.select();
		return list;
	}
}








