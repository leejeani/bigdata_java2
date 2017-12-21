package thread4;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UiTest extends WindowAdapter
implements ActionListener{

	Frame f;
	Button bt1,bt2,bt3,bt4,bt5,bt6;	
	MyThread r = new MyThread();
	Thread t;
	
	public UiTest() {
		f = new Frame();
		f.setLayout(new GridLayout(1, 6));
		bt1 = new Button("Interrupt");
		bt2 = new Button("Suspend");
		bt3 = new Button("Resume");
		bt4 = new Button("Stop");
		bt5 = new Button("Start");
		bt6 = new Button("Restart");
		
		f.add(bt1);f.add(bt2);f.add(bt3);f.add(bt4);
		f.add(bt5);f.add(bt6);
		f.setSize(500, 100);
		f.setVisible(true);
		f.addWindowListener(this);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
	}
	
	public static void main(String[] args) {
		UiTest ui = new UiTest();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		f.setVisible(false);
		f.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bt1)) {
			t.interrupt();
		}else if(e.getSource().equals(bt2)) {
			t.suspend();
		}else if(e.getSource().equals(bt3)) {
			t.resume();
		}else if(e.getSource().equals(bt4)) {
			t.stop();
		}else if(e.getSource().equals(bt5)) {
			t = new Thread(r);
			t.start();
		}else if(e.getSource().equals(bt6)) {
			
		}
	}

}







