package com.test;

import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;

public class UserUpdateTest {

	public static void main(String[] args) {
		UserBiz biz = new UserBiz();

		User user = new User("id44", "pwd55", "ȫ����");
		Item item = new Item("id44", "Fly", 30000);
		user.setItem(item);
		try {
			biz.modify(user);
			System.out.println("���� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}




