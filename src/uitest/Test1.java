package uitest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test1 implements ActionListener{

	Frame frame;
	Button b1,b2,b3,b4,b5;
	Panel p1,p2;
	List list;
	TextField tf;
	
	public Test1() {
		makeUi();
	}
	public void makeUi() {
		b1 = new Button("ADD");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		frame = new Frame();
		p1 = new Panel();
		p2 = new Panel();
		list = new List();
		tf = new TextField(10);
		
		p1.setBackground(Color.yellow);
		p2.setBackground(Color.cyan);
		p1.add(tf);p1.add(b1);p1.add(b2);
		p2.add(b3);p2.add(b4);p2.add(b4);
		frame.setLayout(new GridLayout(3, 1));
		frame.add(p1);
		frame.add(p2);
		frame.add(list);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(b1)) {
			String tfstr = tf.getText();
			list.add(tfstr);
		}else if(e.equals(b2)) {
			
		}
	}

}






