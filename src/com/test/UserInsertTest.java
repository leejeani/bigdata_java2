package com.test;

import com.user.UserBiz;
import com.vo.Item;
import com.vo.User;

import oracle.sql.converter.I18CharacterConvertersWrapper;

public class UserInsertTest {

	public static void main(String[] args) {
		UserBiz biz = new UserBiz();
		
		
		for(int i=100;i<=400;i++) {
			try {
				Thread.sleep(90);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			User user = new User("id"+i, "pwd55", "이말숙");
			Item item = new Item("id"+i, "MARINE", 10000);
			user.setItem(item);
			try {
				biz.register(user);
				System.out.println("정상 입력");
			} catch (Exception e) {
				System.out.println("입력 오류");
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

}





