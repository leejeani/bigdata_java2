package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fo = 
				new FileOutputStream("out.txt");
		BufferedOutputStream bos =
				new BufferedOutputStream(fo);
		for(int i='1';i<='z';i++) {
			bos.write(i);
		}
		bos.close();
		fo.close();
	}

}






