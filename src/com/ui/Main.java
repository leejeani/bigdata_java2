package com.ui;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import com.product.ProductBiz;
import com.user.UserBiz;
import com.vo.Product;
import com.vo.User;

public class Main{
	
	boolean flag = true;
	Thread t1 = null;
	Thread t2 = null;
	
	Frame frame;
	List list1,list2;
	UserBiz<User, String> uBiz;
	ProductBiz<Product, Integer> pBiz;
	ArrayList<User> ulist = null;
	ArrayList<Product> plist = null;
	
	public Main() {
		uBiz = new UserBiz<>();
		pBiz = new ProductBiz<>();
		
		frame = new Frame();
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				flag = false;
				frame.setVisible(false);
				frame.dispose();
				System.exit(0);
			}
		});
		list1 = new List();
		list1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int index = list1.getSelectedIndex();
				User user = ulist.get(index);
				String id = user.getId();
				// 새로운 창을 뛰워서
				// id 정보로 조회 후
				// 상세 정보를 새로운 창에 뛰우시오
				new Detail(id,uBiz,Main.this);
				
			}
		});
		list2 = new List();
		frame.setLayout(new GridLayout(1, 2));
		frame.add(list1);frame.add(list2);
		frame.setSize(400, 700);
		frame.setVisible(true);
		display();
	}
	
	
	
	public void display() {
		t1 = new Thread(r1);
		t1.start();
		int i=1;
		while(flag) {
			t2 = new Thread(r2);
			t2.start();
			i++;
			if(i==3) {
				break;
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}



	Runnable r1 = new Runnable() {
		
		@Override
		public void run() {
			
			try {
				ulist = uBiz.get();
				list1.removeAll();
				for(User u:ulist) {
					String str = 
					u.getId()+" "+u.getName();
					list1.add(str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
	};

	Runnable r2 = new Runnable() {
		
		@Override
		public void run() {
			
			try {
				plist = pBiz.get();
				list2.removeAll();
				for(Product p:plist) {
					String str = 
					p.getId()+" "+p.getName()
					+" "+p.getPrice()+" "+p.getRegdate();
					list2.add(str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

}





