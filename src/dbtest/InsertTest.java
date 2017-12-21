package dbtest;

import java.util.ArrayList;

public class InsertTest {

	public static void main(String[] args) {
		Biz biz = new Biz();
		User user = new User("id01", "pwd01", "james");
		User user2 = new User("id02", "pwd02", "james");
		User user3 = new User("id03", "pwd03", "james");
		User user4 = new User("id04", "pwd04", "james");
		User user5 = new User("id05", "pwd05", "james");
		
		// insert test
		try {
			biz.register(user);
			biz.register(user2);
			biz.register(user3);
			biz.register(user4);
			biz.register(user5);
		} catch (DuplicatedIDException e) {
			System.out.println("아이디 중복 에러");
			e.printStackTrace();
		}
		
		// select  test
		User getUser = null;
		try {
			getUser = (User) biz.get("id01");
			System.out.println(getUser);
		} catch (IDNotFoundException e) {
			System.out.println("아이디 가 존재 하지 않습니다.");
			e.printStackTrace();
		}
		
		// select All 
		ArrayList<Object> list = null;
		list = biz.get();
		for(Object obj:list) {
			User getuser = (User)obj;
			System.out.println(getuser);
		}
		// delete test
		try {
			biz.remove("id02");
		} catch (IDNotFoundException e) {
			System.out.println("아이디 가 존재 하지 않습니다.");
			e.printStackTrace();
		}
		// update test 
		user4.setPwd("id99");
		try {
			biz.modify(user4);
		} catch (IDNotFoundException e) {
			System.out.println("아이디 가 존재 하지 않습니다.");
			e.printStackTrace();
		}
		
		
		// select all
		ArrayList<Object> list2 = null;
		list2 = biz.get();
		for(Object obj:list2) {
			User getuser = (User)obj;
			System.out.println(getuser);
		}
		
		
	}

}





