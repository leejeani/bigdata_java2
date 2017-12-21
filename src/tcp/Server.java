package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server extends Thread{
	boolean flag = true;
	ArrayList<DataOutputStream> list;
	ServerSocket serverSocket;
	Sender sender;
	
	public Server() {
		list = new ArrayList<>();
		try {
			InetAddress id2 = null;
			id2 = InetAddress.getLocalHost();
			
			System.out.println(id2.getHostAddress());
			System.out.println(id2.getHostName());
			System.out.println(id2.toString());
			serverSocket = new ServerSocket(9999);
			//serverSocket.setSoTimeout(3000);
			System.out.println("Ready Server"+serverSocket.getLocalPort());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run(){
		sender = new Sender();
		while(true) {
			try {
				System.out.println("Ready ..");
				Socket socket = serverSocket.accept();
				//socket.setSoTimeout(3000);
				System.out.println(socket.getInetAddress());
				System.out.println("Connected ..");
				Receiver  receiver  = new Receiver(socket);
				receiver.start();
			}catch(Exception e) {
				System.out.println("time out ..");
				break;
			}
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
							dout.flush();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
	
	public void sendMsg(String msg) {
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
			System.out.println("접속자 수:"+list.size());
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
							//sendAllMsg(str);	
						}
				}
			} catch (Exception e) {
			} finally {
				list.remove(outw);
				if(outw != null) {
					try {
						outw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("접속자 감소:"+list.size());
			}
			
		}
	}
	
	
	
	public static void main(String args[]) {
		Server server = null;
		try {
			server = new Server();
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			@SuppressWarnings("resource")
			Scanner scanner = 
				new Scanner(System.in);
			System.out.println("서버 입력 하세요:");
			
			String str = scanner.nextLine();
			server.sendMsg(str);
		}
	}
	
}





