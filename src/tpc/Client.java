package tpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	boolean flag = true;
	String address = "70.12.107.160";
	Socket socket;
	Sender sender;
	Receiver receiver;
	ClientUI ui;
	
	
	public Client(ClientUI ui){
		this.ui = ui;
	}
	
	public void connect() throws Exception {
		socket = new Socket(address, 8888);
		ui.label.setText("Connected !!");
		sender = new Sender(socket);
		receiver = new Receiver(socket);
		receiver.start();	
	}
	public void disconnect() throws Exception {
		
	}
	public void sendMsg(String msg) {
		Thread t = new Thread(sender);
		sender.setSendMsg(msg);
		t.start();
	}
	
	class Sender implements Runnable{
		Socket socket;
		OutputStream out;
		DataOutputStream outw;
		String sendMsg;
		public Sender(Socket socket) throws IOException {
			this.socket = socket;
			out = socket.getOutputStream();
			outw = new DataOutputStream(out);
		}
		public void setSendMsg(String sendMsg) {
			this.sendMsg = sendMsg;
		}
		@Override
		public void run() {
			try {
				if(outw != null) {
					outw.writeUTF(sendMsg);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	class Receiver extends Thread{
		Socket socket;
		InputStream in;
		DataInputStream inr;
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			inr = new DataInputStream(in);
		}
		@Override
		public void run() {
			while(inr != null) {
				try {
					String str = inr.readUTF();
					if(str.trim().equals("q")) {
						sendMsg("okq");
						ui.label.setText("Server Disconnect");
						break;
					}
					if(str.trim().equals("okq")) {
						ui.label.setText("Response OK");
						break;
					}
					ui.list.add("[server] "+str,0);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				
				Thread.sleep(100);
				socket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	
	
}






