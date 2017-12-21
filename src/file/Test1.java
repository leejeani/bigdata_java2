package file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test1 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = 
				new RandomAccessFile("zzz.txt", "rw");
		
		String st = "ÇÑ±Û";
		st = 
		new String(st.getBytes("KSC5601"),"8859_1");
		rf.writeBytes(st);
		
		
		rf.seek(0);
		String str = "";
		while((str = rf.readLine()) != null) {
			str = 
			new String(str.getBytes("8859_1"),"KSC5601");
			System.out.print(str);
		}
		
		
		rf.close();
	}

}






