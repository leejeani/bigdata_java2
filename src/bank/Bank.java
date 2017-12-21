package bank;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Bank extends WindowAdapter 
implements ActionListener{

	Frame f;
	List list1,list2,list3;
	Button bt;
	Panel p;
	Account acc = new Account(1000);
	
	
	public Bank() {
		f = new Frame();
		list1 = new List();
		list2 = new List();
		list3 = new List();
		bt = new Button("START");
		p = new Panel();
		
		
		p.setLayout(new GridLayout(1, 3));
		p.add(list1);p.add(list2);p.add(list3);
		
		f.add(bt, "North");f.add(p, "Center");
		f.setSize(600, 300);
		f.setVisible(true);
		
		f.addWindowListener(this);
		bt.addActionListener(this);
	}
	
	
	class WTh extends Thread{
		String name = "Widthdraw";
		boolean stop = false;
		
		public void setStop(boolean stop) {
			this.stop = stop;
		}
		
		@Override
		public void run() {
			while(acc.getBalance() >= 0) {
				try {
					Thread.sleep(90);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if(!stop) {
					int money = (int)(Math.random()*9+1)*100;
					acc.withdraw(money);
					list1.add(name+" withdraw : "+money,0);
					list2.add(acc.toString(),0);
					
				}
			}
		}
	};
	
	class DTh extends Thread{
		String name = "Deposit";
		boolean stop = false;
		
		public void setStop(boolean stop) {
			this.stop = stop;
		}
		
		@Override
		public void run() {
			while(acc.getBalance() >= 0) {
				try {
					Thread.sleep(90);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				if(!stop) {
					int money = (int)(Math.random()*9+1)*100;
					acc.deposit(money);
					list3.add(name+" deposit : "+money,0);
					list2.add(acc.toString(),0);
					
				}
			}
		}
	};
	
	
	public static void main(String[] args) {
		Bank b = new Bank();
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		f.setVisible(false);
		f.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WTh wt = new WTh();
		DTh dt = new DTh();
		dt.setDaemon(true);
		wt.setDaemon(true);
		dt.start();
		wt.start();
		boolean flag = true;
		while(acc.getBalance() >= 0) {
			
			if(acc.getBalance() >= 10000) {
				System.out.println("change");
				//notify();
				wt.setStop(false);
				dt.setStop(true);
				flag = true;
				list3.removeAll();
			}else if(acc.getBalance() < 10000 && 
					acc.getBalance() >=5000) {
				if(flag) {
					wt.setStop(false);
					dt.setStop(true);
				}else {
					wt.setStop(true);
					dt.setStop(false);
				}
			}else if(acc.getBalance() < 5000){
				System.out.println("change2");
				//notify();
				wt.setStop(true);
				dt.setStop(false);
				flag = false;
				list1.removeAll();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException ee) {
				ee.printStackTrace();
			}
		}
		
	}

}










