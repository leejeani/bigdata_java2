package thread2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ui extends WindowAdapter 
implements ActionListener{
	
	Frame f;
	Panel p1,p2,p3,p1_sub,p2_sub,p3_sub;
	Button p1_bt1,p1_bt2,p2_bt1,p2_bt2,p3_bt1,p3_bt2,
	p1_bt3,p2_bt3,p3_bt3;
	List list1,list2,list3;
	
	public Ui() {
		makeui();
	}
	

	private void makeui() {
		f = new Frame();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p1_sub = new Panel();
		p2_sub = new Panel();
		p3_sub = new Panel();
		list1 = new List();
		list2 = new List();
		list3 = new List();	
		p1_bt1 = new Button("Start");	
		p1_bt2 = new Button("Clear");
		p2_bt1 = new Button("Start");	
		p2_bt2 = new Button("Clear");
		p3_bt1 = new Button("Start");	
		p3_bt2 = new Button("Clear");
		p1_bt3 = new Button("Stop");
		p2_bt3 = new Button("Stop");
		p3_bt3 = new Button("Stop");
		
		p1_sub.add(p1_bt1);
		p1_sub.add(p1_bt2);
		p1_sub.add(p1_bt3);
		p2_sub.add(p2_bt1);
		p2_sub.add(p2_bt2);
		p2_sub.add(p2_bt3);
		p3_sub.add(p3_bt1);
		p3_sub.add(p3_bt2);
		p3_sub.add(p3_bt3);
		
		
		f.setLayout(new GridLayout(1, 3));
		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		p3.setLayout(new BorderLayout());
		p1.add(p1_sub, "North");
		p1.add(list1, "Center");
		p2.add(p2_sub, "North");
		p2.add(list2, "Center");
		p3.add(p3_sub, "North");
		p3.add(list3, "Center");
		
		p1.setBackground(Color.cyan);
		p2.setBackground(Color.yellow);
		p3.setBackground(Color.pink);
		
		f.add(p1);f.add(p2);f.add(p3);
		
		f.setSize(800, 500);
		f.setVisible(true);
		
		f.addWindowListener(this);
		p1_bt1.addActionListener(this);
		p1_bt2.addActionListener(this);
		p2_bt1.addActionListener(this);
		p2_bt2.addActionListener(this);
		p3_bt1.addActionListener(this);
		p3_bt2.addActionListener(this);
		
		p1_bt3.addActionListener(this);
		p2_bt3.addActionListener(this);
		p3_bt3.addActionListener(this);
		
	}
	
	

	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		f.setVisible(false);
		f.dispose();
	}
	
	class T1 extends Thread{
		int count = 0;
		boolean br = false;
		boolean su = false;
		public void restart() {
			br = false;
			su = false;
			System.out.println(su+" restart "+br+count);

		}
		public void sus() {
			su = true;
			System.out.println(su+" sus "+br+count);
		}
		@Override
		public void run() {
			w:
			while(true) {
				System.out.println("while");
				if(br == false) {
					for(int i=count;i<10000;i++) {
						list1.add("list1:"+i);
						count = i;
						if(su) {
							br = true;
							break;
						}
						if(count == 9999) {
							br = true;
							break w;
						}
					}
				}
			}
			
		}
	}
	
	class T2 extends Thread{
		@Override
		public void run() {
			for(int i=0;i<10000;i++) {
				list2.add("list2:"+i);
				if(isInterrupted()) {
					break;
				}
			}			
		}
	}
	
	class T3 extends Thread{
		@Override
		public void run() {
			for(int i=0;i<10000;i++) {
				list3.add("list3:"+i);
				if(isInterrupted()) {
					break;
				}
			}			
		}
	}
	
	T1 t1;
	T2 t2;
	T3 t3;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(p1_bt1)) {
			t1 = new T1();
			t1.start();
		}else if(e.getSource().equals(p1_bt2)) {
			list1.removeAll();
		}else if(e.getSource().equals(p2_bt1)) {
			t2 = new T2();
			t2.start();
		}else if(e.getSource().equals(p2_bt2)) {
			list2.removeAll();
		}else if(e.getSource().equals(p3_bt1)) {
			t3 = new T3();
			t3.start();
		}else if(e.getSource().equals(p3_bt2)) {
			list3.removeAll();
		}else if(e.getSource().equals(p1_bt3)) {
			t1.sus();
		}else if(e.getSource().equals(p2_bt3)) {
			t1.restart();
		}else if(e.getSource().equals(p3_bt3)) {
			t3.interrupt();
		}
	}
	
	
	public static void main(String[] args) {
		Ui ui = new Ui();
	}

}




