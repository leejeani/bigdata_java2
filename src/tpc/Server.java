package tpc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	boolean flag = true;

	ServerSocket serverSocket;
	Receiver  receiver;
	Sender sender;
	ServerUI ui;
	
	public Server(ServerUI ui) {
		this.ui = ui;
	}
	Runnable r = new Runnable() {
		@Override
		public void run() {
			ui.label.setText("Server Ready !!");
			try {
				Socket socket = serverSocket.accept();
				ui.label.setText("Connected !!");
				receiver  = new Receiver(socket);
				receiver.start();
				sender = new Sender(socket);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	};
	public void ready(){
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("Ready Server");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread t = new Thread(r);
		t.start();
	}
	
	public void disconnect() {
		
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
						ui.label.setText("[client disconnect ..] ");
						break;
					}
					if(str.trim().equals("okq")) {
						ui.label.setText("Response OK");
						break;
					}
					ui.list.add("[client] "+str,0);
	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(100);
				socket.close();
				serverSocket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}





