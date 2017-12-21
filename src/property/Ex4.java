package property;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Ex4 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("name", "ÀÌ¸»¼÷");
		prop.setProperty("id", "id01");
		prop.setProperty("age", "30");
		
		try {
			prop.store(new FileOutputStream("person.txt"), 
					"Person Information");
			prop.storeToXML(new FileOutputStream("person.xml"), 
					"Person Information");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}









