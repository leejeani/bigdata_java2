package com.ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.user.UserBiz;
import com.vo.User;

public class Login implements ActionListener{
	
	UserBiz<User, String> biz;
	
	Frame frame;
	TextField tf_id, tf_pwd;
	Button btn;
	Label label;
	
	public Login() {
		biz = new UserBiz<>();
		frame = new Frame();
		frame.setLayout(new GridLayout(1, 4));
		frame.setSize(400, 100);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		tf_id = new TextField();
		tf_pwd = new TextField();
		btn = new Button("LOGIN");
		btn.addActionListener(this);
		label = new Label("Status");
				
		frame.add(tf_id);
		frame.add(tf_pwd);
		frame.add(btn);
		frame.add(label);
		frame.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = tf_id.getText().trim();
		String pwd = tf_pwd.getText().trim();
		
		// get�� ���� Id�� �Է��Ѵ�.
		// id�� ���� �ϸ� user ��ü�� ������ �´�.
		// ������ �� user ��ü�� pwd�� �Է��� pwd
		// �� �� �Ѵ�.
		User dbuser = null;
		
		try {
			dbuser = biz.get(id);
			if(dbuser.getPwd().equals(pwd)) {
				frame.setVisible(false);
				frame.dispose();
				Main main = new Main();
			}else {
				label.setText("Invalid Password.");
				tf_pwd.setText("");
			}
		} catch (Exception e1) {
			//e1.printStackTrace();
			label.setText("Not exists");
			tf_id.setText("");
			tf_pwd.setText("");
		}
		
	}

}










