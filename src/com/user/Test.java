package com.user;

import java.util.ArrayList;

import com.vo.User;

public class Test {

	public static void main(String[] args) {
		UserBiz<User, String> biz =
				new UserBiz<>();
		ArrayList<User> list = null; 
		try {
			list = biz.get();
			for(User u : list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		for(int i=0;i<50;i++) {
//			User user = 
//				new User("id2"+i, "pwd2"+i, "ÀÌ¸»¼÷");
//			
//			try {
//				Thread.sleep(100);
//				biz.register(user);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} //end for
	}

}






