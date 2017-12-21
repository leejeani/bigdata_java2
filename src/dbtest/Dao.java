package dbtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Dao {
	HashMap<Object,Object> db;
	
	public Dao() {
		db = new HashMap<>();
	}

	public void insert(Object obj) 
			throws DuplicatedIDException{
		// ID �ߺ� üũ
		User user = (User)obj;
		String id = user.getId();
		if(db.containsKey(id)) {
			throw new DuplicatedIDException();
		}else {
			db.put(id, user);
			System.out.println("�Է� ����");
		}
		
	}
	public void delete(Object obj) 
			throws IDNotFoundException{
		if(db.containsKey(obj)) {
			db.remove(obj);
			System.out.println("���� �Ϸ�");
		}else {
			throw new IDNotFoundException();
		}
	}
	public void update(Object obj) 
			throws IDNotFoundException{	
		User user = (User)obj;
		if(db.containsKey(user.getId())) {
			db.put(user.getId(),user);
			System.out.println("���� �Ϸ�");
		}else {
			throw new IDNotFoundException();
		}
	}
	public Object select(Object obj) 
			throws IDNotFoundException{
		// User ��ü�� ����� ���� �Ѵ�.
		User user = null;
		if(db.containsKey(obj)) {
			user = (User) db.get(obj);
		}else {
			throw new IDNotFoundException();
		}
		return user;
	}
	public ArrayList<Object> select() {
		// DB���� User ��ü�� ������
		// ArrayList�� ��Ƽ� ���� �Ѵ�.
		ArrayList<Object> list 
		= new ArrayList<>();
		Set<Object> keys = db.keySet();
		for(Object key:keys) {
			User user = (User) db.get(key);
			list.add(user);
		}
		return list;
	}
	
}





