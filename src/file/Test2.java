package file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {

	public static void main(String[] args) throws IOException {
		File f1 = new File("C:\\java2\\day13");
		File f2 = new File("C:\\java2\\day13\\bbb.txt");
		
		System.out.println(f2.getAbsolutePath());
		System.out.println(f2.getName());
		System.out.println(f2.getPath());
		System.out.println(f2.length());
		
		File newFile = 
			new File("C:\\java2\\day13\\myfile.txt");
		newFile.createNewFile();
		
		File newDir =
			new File("C:\\java2\\day13\\myfolder");
		newDir.mkdirs();
		
		
		
		File [] files = f1.listFiles();
		System.out.println(files.length);
		
		SimpleDateFormat sdf = 
		new SimpleDateFormat("yyyy-MM-DD HH:mma");
		
		
		for(File file:files) {
			String fdate = 
			sdf.format(new Date(file.lastModified()));
			System.out.print(fdate);
			System.out.print(" "+file.length());
			System.out.print(" "+file.getName());
			if(file.isDirectory()) {
				System.out.print("[DIR] ");	
			}
			System.out.println("");
		}
		
	}

}





