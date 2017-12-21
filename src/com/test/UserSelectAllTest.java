package com.test;

import java.util.ArrayList;

import com.user.UserBiz;

public class UserSelectAllTest {

	public static void main(String[] args) {
		UserBiz biz = new UserBiz();
		ArrayList<Object> list = null;
		
		try {
			list = biz.get();
			for(Object u:list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}







