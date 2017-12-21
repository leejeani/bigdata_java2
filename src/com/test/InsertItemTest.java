package com.test;

import com.item.ItemDao;
import com.vo.Item;

public class InsertItemTest {

	public static void main(String[] args) {
		ItemDao dao = new ItemDao();
		Item item = 
		new Item(200, "Tank2", 20000, 3.5);
		try {
			dao.insert(item);
			System.out.println("입력 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
