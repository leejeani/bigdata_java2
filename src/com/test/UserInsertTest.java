package com.test;

import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;

import oracle.sql.converter.I18CharacterConvertersWrapper;

public class UserInsertTest {

	public static void main(String[] args) {
		UserBiz biz = new UserBiz();
		User user = new User("id55", "pwd55", "�̸���");
		Item item = new Item("id55", "MARINE", 10000);
		user.setItem(item);
		
		try {
			biz.register(user);
			System.out.println("���� �Է�");
		} catch (Exception e) {
			System.out.println("�Է� ����");
			e.printStackTrace();
		}
		
	}

}





