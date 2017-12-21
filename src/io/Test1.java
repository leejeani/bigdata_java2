package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fio = null;
		FileOutputStream foo = null;
		try {
			fio = new FileInputStream("C:\\java2\\day12\\src\\test.txt");
			foo = new FileOutputStream("write.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File Not found");
		}
		System.out.println(fio.available());
		int data = 0;
		while((data=fio.read()) != -1) {
			foo.write(data);
		}
		fio.close();
		foo.close();
	}

}





