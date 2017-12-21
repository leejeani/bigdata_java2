package tcp2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
	boolean flag = true;
	ArrayList<DataOutputStream> list;
	ServerSocket serverSocket;
	Sender sender;
	
	public Server() {
		list = new ArrayList<>();
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("Ready Server");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void start() throws Exception{
		sender = new Sender();
		while(true) {
			System.out.println("Ready ..");
			Socket socket = serverSocket.accept();
			System.out.println(socket.getInetAddress());
			System.out.println("Connected ..");
			Receiver  receiver  = new Receiver(socket);
			receiver.start();
		}
	}
	
	class Sender implements Runnable{
		
		String sendMsg;
		
		public void setSendMsg(String sendMsg) {
			this.sendMsg = sendMsg;
		}
		@Override
		public void run() {
			try {
				if(list.size() != 0) {
					for(DataOutputStream dout:list) {
						if(dout != null) {
							dout.writeUTF(sendMsg);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	
	
	
	public void sendAllMsg(String msg) {
		Thread t = new Thread(sender);
		sender.setSendMsg(msg);
		t.start();
	}
	class Receiver extends Thread{
		Socket socket;
		InputStream in;
		DataInputStream inr;
		OutputStream out;
		DataOutputStream outw;
		public Receiver(Socket socket) throws IOException {
			this.socket = socket;
			in = socket.getInputStream();
			inr = new DataInputStream(in);
			out = socket.getOutputStream();
			outw = new DataOutputStream(out);
			list.add(outw);
			System.out.println("立加磊 荐:"+list.size());
		}
		@Override
		public void run() {
			try {
				while(inr != null) {
						String str = inr.readUTF();
						System.out.println(str);
						if(str.equals("q")) {
							if(list.contains(outw)) {
								list.remove(outw);
								outw.close();
							}
						}else {
							sendAllMsg(str);	
						}
				}
			} catch (Exception e) {
				System.out.println("立加磊 皑家:"+list.size());
			}
			
		}
	}
	
	
	
	public static void main(String args[]) {
		try {
			new Server().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}





