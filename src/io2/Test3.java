package io2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test3 {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("write2.txt");
		fw.write("안녕하십니까?");
		fw.write("1234567 8910");
		fw.write("abcdef");
		fw.close();
		
		FileReader fr = new FileReader("write2.txt");
		int data = 0;
		while((data = fr.read()) != -1) {
			System.out.print((char)data);
		}
		fr.close();
	}

}










