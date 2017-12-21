package tpc;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientUI implements ActionListener{

	Frame frame;
	Panel panel;
	List list;
	TextField tf;
	Button bt1,bt2,bt3;
	Label label;
	Client client;
	
	
	public ClientUI() {
		makeui();
		client = new Client(this);
	}
		
	private void makeui() {
		frame = new Frame("Client");
		panel = new Panel();
		list = new List();
		label = new Label();
		tf = new TextField(10);
		bt1 = new Button("Send");
		bt2 = new Button("Connect");
		bt3 = new Button("Close");
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
		panel.add(tf);
		panel.add(bt1);panel.add(bt2);panel.add(bt3);
		label.setForeground(Color.RED);
		frame.add(panel, "North");
		frame.add(list, "Center");
		frame.add(label, "South");
		
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bt1)) {
			String msg = tf.getText();
			list.add("[client] "+msg,0);
			client.sendMsg(msg);
		}else if(e.getSource().equals(bt2)) {
			try {
				client.connect();
			} catch (Exception e1) {
				label.setText("Connect Error !!");
			}
		}else if(e.getSource().equals(bt3)) {
			client.sendMsg("q");
		}
	}
	
	
	
	public static void main(String[] args) {
		ClientUI client = new ClientUI();
	}

}





