package com.test;

import com.item.ItemDao;
import com.user.UserDao;
import com.vo.Item;
import com.vo.User;

public class TRTest {

	public static void main(String[] args) {
		UserDao userdao = new UserDao();
		ItemDao itemdao = new ItemDao();
		User user = new User("id99", "pwd99", "이말숙");
		Item item = new Item(88, "88item", 1000, 3.5);
		
		try {
			userdao.insert(user);
			itemdao.insert(item);
			System.out.println("입력 완료");
		} catch (Exception e) {
			System.out.println("입력 오류");
		}
		
	}

}








