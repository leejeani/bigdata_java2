package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println("Ready Server ..");
			System.out.println(ia.getHostAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true) {
			try {
				System.out.println("Ready to Client");
				Socket socket = serverSocket.accept();
				System.out.println(socket.getInetAddress()+" �� ���� �Ͽ����ϴ�.");
				
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter outw = 
						new OutputStreamWriter(out);
				outw.write("����...");
				System.out.println("���� ���� �Ϸ�");
				outw.close();
				
				
				socket.close();
				System.out.println("End to Client Service");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}





