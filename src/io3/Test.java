package io3;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Test {
	
	Frame f;
	Button b1;
	Label label;
	InputThread it;
	OutputThread ot;
	TextField tf;
	List list;
	
	public Test() {
		f = new Frame();
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.setVisible(false);
				f.dispose();
			}
		});
		b1 = new Button("send");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start();
			}
		});
		label = new Label("data");
		label.setForeground(Color.red);
		tf = new TextField();
		list = new List();
		f.add(list, "Center");
		f.add(b1, "North");
		f.add(tf, "South");
		f.setSize(300, 300);
		f.setVisible(true);

	}
	
	
	public void start() {
		it = new InputThread();
		ot = new OutputThread();
		it.connect(ot.getOutput());
		it.start();
		ot.start();
	}
	// input
	class InputThread extends Thread {
		PipedReader input = new PipedReader();
		StringBuffer sb = new StringBuffer();
		public PipedReader getInput() {
			return input;
		}
		public void connect(PipedWriter pw) {
			try {
				input.connect(pw);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			int data = 0;
			try {
				while((data = input.read()) != -1) {
					sb.append((char)data);
				}
				list.add(sb.toString(),0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};
	
	// output
	class OutputThread extends Thread {
		PipedWriter output = new PipedWriter();
		
		public PipedWriter getOutput() {
			return output;
		}

		public void setOutput(PipedWriter output) {
			this.output = output;
		}
		public void connect(PipedReader input) {
			try {
				output.connect(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			String msg = tf.getText();
			try {
				output.write(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	};
}






