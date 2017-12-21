package com.ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.user.UserBiz;
import com.vo.User;

public class Detail implements ActionListener{

	Main main;
	String id;
	UserBiz<User, String> biz;
	User user;	
	
	Frame frame;
	Panel p1,p2;
	TextField tf_id,tf_pwd,tf_name;
	Button bt1,bt2;
	
	public Detail() {
		
	}
	public Detail(String id, 
			UserBiz<User, String> biz,Main main) {
		this.id = id;
		this.biz = biz;
		this.main = main;
		
		try {
			user = biz.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		frame = new Frame();
		frame.setLayout(new GridLayout(2, 1));
		p1 = new Panel();p2 = new Panel();
		tf_id = new TextField(15);
		tf_pwd = new TextField(15);
		tf_name = new TextField(15);
		bt1 = new Button("수정");
		bt2 = new Button("삭제");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		p1.add(tf_id);p1.add(tf_pwd);p1.add(tf_name);
		p2.add(bt1);p2.add(bt2);
		
		frame.add(p1);frame.add(p2);

		frame.setSize(450, 200);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				//frame.dispose();
			}
		});
		
		
		tf_id.setText(user.getId());
		tf_pwd.setText(user.getPwd());
		tf_name.setText(user.getName());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bt1)) {
			String id = tf_id.getText();
			String pwd = tf_pwd.getText();
			String name = tf_name.getText();
			User user = new User(id, pwd, name);
			try {
				biz.modify(user);
				main.display();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(e.getSource().equals(bt2)) {
			try {
				biz.remove(id);
				main.display();
				frame.setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
}







