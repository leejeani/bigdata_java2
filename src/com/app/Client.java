package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Client {

	public static void main(String[] args) throws IOException {
		String address = 
		"http://70.12.107.160/test/sa";
		address += "?id=id01&pwd=pwd01";
		URL url = new URL(address);
		InputStream is = url.openStream();
		InputStreamReader ir = 
				new InputStreamReader(is);
		BufferedReader br = new BufferedReader(ir);
		String str = "";
		str = br.readLine();
		System.out.println(str);
	}

}








