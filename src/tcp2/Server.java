package tcp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket serverSocket;
	
	public Server() {
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("Ready Server");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() throws Exception {
		while(true) {
			System.out.println("Server Running ..");
			Socket socket = serverSocket.accept();
			System.out.println("Connected Client..");
			
			Sender sender = new Sender(socket);
			sender.start();
		}
	}
	
	class Sender extends Thread{
		Socket socket;
		OutputStream out;
		OutputStreamWriter outw;
		public Sender(Socket socket) throws IOException {
			this.socket = socket;
			out = socket.getOutputStream();
			outw = new OutputStreamWriter(out);
		}
		@Override
		public void run() {
			try {
				outw.write("1±â°¡ ¾È³ç ... ");
				outw.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}




