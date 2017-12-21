package tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TpcClient {

	public static void main(String[] args) {
		String server = "70.12.107.160";
		Socket socket = null; 
		try {
			socket = new Socket(server, 7777);
			System.out.println(server+" 연결 성공");
			
			InputStream in = socket.getInputStream();
			InputStreamReader inr =
				new InputStreamReader(in);
			BufferedReader br = 
				new BufferedReader(inr);
			String str = br.readLine();
			System.out.println(str);
			
			br.close();
			inr.close();
			in.close();
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}








