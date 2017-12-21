package tcp2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	boolean flag = true;
	String address = "70.12.107.160";
	Socket socket;
	
	public Client() throws UnknownHostException, IOException {
		
		while(true) {
			
			try {
			socket = new Socket(address, 8888);
			}catch(ConnectException e) {
				System.out.println("Connect Server Fail !!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				continue;
			}	
			System.out.println("Connected Server ..");
			break;
		}
	}
	
	@SuppressWarnings("resource")
	public void start() throws Exception {
		new Receiver(socket).start();
		Sender sender = new Sender(socket);
		while(true) {
			Scanner scanner = 
				new Scanner(System.in);
			System.out.println("클라이언트 입력 하세요:");
			
			String str = scanner.nextLine();
			if(str.trim().equals("q")) {
				Thread t = new Thread(sender);
				sender.setSendMsg("q");
				t.start();
				flag = false;
				scanner.close();
				break;
			}
			Thread t = new Thread(sender);
			sender.setSendMsg(str);
			t.start();
		}
		Thread.sleep(1000);
		socket.close();
		
		//System.exit(0);
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
			try {
				while(inr != null) {
						String str = inr.readUTF();
						System.out.println(str);
						if(str.trim().equals("q")) {
							break;
						}
				}
			} catch (Exception e) {
				System.out.println("종료");
			}finally {
				if(socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		}
	}
	
	
	
	public static void main(String args[]) {
		try {
			new Client().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}






