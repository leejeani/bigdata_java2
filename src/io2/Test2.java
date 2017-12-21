package io2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException {
		// byte stream
		FileInputStream fis = null;
		fis = new FileInputStream("write.txt");
		int data1 = 0;
		int count = 0;
		while((data1 = fis.read()) != -1) {
			count++;
			System.out.print((char)data1);
		}
		fis.close();
		System.out.println("\nCOUNT: "+count);
		System.out.println("----------------------");
		
		// 2byte stream
		FileReader fr = null;
		fr = new FileReader("write.txt");
		int data2 = 0;
		int count2 = 0;
		while((data2 = fr.read()) != -1) {
			count2++;
			System.out.print((char)data2);
		}
		System.out.println(count2);
		fr.close();
	}

}
















