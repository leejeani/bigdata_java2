package com.test;

import java.util.ArrayList;

import com.item.ItemDao;

public class ItemSelectAllTest {

	public static void main(String[] args) {
		ItemDao dao = new ItemDao();
		ArrayList<Object> list = null;
		
		try {
			list = dao.select();
			for(Object obj:list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}







