package com.user;

import java.util.ArrayList;

import com.exception.DuplicatedIDException;
import com.exception.IDNotFoundException;
import com.vo.User;

public class Test {

	public static void main(String[] args) {
		User user = new User("id01", "pwd01", "james");
		User user2 = new User("id02", "pwd02", "james");
		User user3 = new User("id03", "pwd03", "james");
		User user4 = new User("id04", "pwd04", "james");
		User user5 = new User("id05", "pwd05", "james");
		
		UserBiz biz = new UserBiz();

		// insert TEST
		try {
			biz.register(user);
			biz.register(user2);
			biz.register(user3);
			biz.register(user4);
			biz.register(user5);
			System.out.println("ȭ��: �Է� �Ϸ�");
		} catch (DuplicatedIDException e) {
			System.out.println("ID �ߺ� �Դϴ�.");
			//e.printStackTrace();
		}
		
		// select TEST
		User getuser = null;
		try {
			getuser = (User) biz.get("id02");
			System.out.println(getuser);
		} catch (IDNotFoundException e) {
			System.out.println("ID�� ã���� �����ϴ�.");
		}

		// delete test
		
		try {
			biz.remove("id02");
		} catch (IDNotFoundException e1) {
			System.out.println("ID�� ã���� �����ϴ�.");
		}
				
		// update test
		
		user3.setPwd("id99");	
		try {
			biz.modify(user3);
		} catch (IDNotFoundException e1) {
			System.out.println("ID�� ã���� �����ϴ�.");
		}
		
		
		// select all
		ArrayList<Object> list = null;
		try {
			list = biz.get();
			for(Object obj:list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			System.out.println("��ȸ����");
		}
		
		
	}

}








