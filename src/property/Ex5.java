package property;

import java.util.Properties;

public class Ex5 {

	public static void main(String[] args) {
		Properties prop = System.getProperties();
		System.out.println(prop.getProperty("java.version"));
		System.out.println(prop.getProperty("user.language"));
		prop.list(System.out);
		
	}

}
