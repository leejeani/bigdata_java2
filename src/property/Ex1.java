package property;

import java.util.Enumeration;
import java.util.Properties;

public class Ex1 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("ip", "100");
		prop.setProperty("protocol", "http");
		prop.setProperty("name", "naver");


		@SuppressWarnings("rawtypes")
		Enumeration e = prop.propertyNames();
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = prop.getProperty(key);
			System.out.println(key+" "+value);
		}
		
		System.out.println("-------------------");
		System.out.println(prop.getProperty("1"));
		System.out.println(prop.getProperty("port","1000"));
		
		System.out.println(prop);
		prop.list(System.out);
	}

}





