package com.test;

import com.user.UserBiz;

public class UserDeleteTest {

	public static void main(String[] args) {
		UserBiz biz = new UserBiz();
		try {
			biz.remove("id44");
			System.out.println("���� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
