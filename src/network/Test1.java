package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress id = null;
		id = InetAddress.getByName("www.naver.com");
		
		System.out.println(id.getHostAddress());
		System.out.println(id.getHostName());
		System.out.println(id.toString());
		
		InetAddress id2 = null;
		id2 = InetAddress.getLocalHost();
		
		System.out.println(id2.getHostAddress());
		System.out.println(id2.getHostName());
		System.out.println(id2.toString());
		
		
		
		
	}

}



