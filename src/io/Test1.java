package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.annotation.processing.Filer;

public class Test1 {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("0823.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("abcd");
		bw.write("1234");
		bw.newLine();
		bw.write("ÇÑ±Û");
		bw.close();
		fw.close();
		
		FileReader fr = new FileReader("0823.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		while((line = br.readLine()) != null ) {
			System.out.println(line);
		}
		
		fr.close();
	}

}










