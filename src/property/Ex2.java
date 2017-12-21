package property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Ex2 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		String fileName = "data.txt";
		try {
			prop.load(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String server = prop.getProperty("server");
		String port = prop.getProperty("port");
		String id = prop.getProperty("id");
		String pwd = prop.getProperty("pwd");
		String protocol = prop.getProperty("protocol","http");
		
		if(protocol != null) {
			System.out.println(protocol+server+"俊 立加 己傍 ");	
		}else {
			System.out.println(protocol+server+"俊 立加 角菩 ");
		}
		
	}

}










