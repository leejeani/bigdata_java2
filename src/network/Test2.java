package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test2 {

	public static void main(String[] args) throws IOException {
		URL url = null;
		String address = "https://www.naver.com/index.html";

		url = new URL(address);
		
		InputStreamReader is = 
			new InputStreamReader(url.openStream());
		BufferedReader br = new BufferedReader(is);
		
		String str = "";
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		is.close();
		
	}

}





