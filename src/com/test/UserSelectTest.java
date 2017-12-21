package com.test;

import com.user.UserBiz;
import com.vo.User;

public class UserSelectTest {

	public static void main(String[] args) {
		UserBiz biz = new UserBiz();
		
		User user = null;
		try {
			user = (User)biz.get("id44");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}








