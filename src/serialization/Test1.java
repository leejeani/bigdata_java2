package serialization;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		User user = new User("id01", "pwd01", "이말숙");
		
		FileOutputStream fos = 
			new FileOutputStream("user.ser");
		BufferedOutputStream bos = 
			new BufferedOutputStream(fos);
		ObjectOutputStream oos = 
			new ObjectOutputStream(bos);
		oos.writeObject(user);
		oos.close();
		bos.close();
		fos.close();
		System.out.println("정상 저장");
		
		
		FileInputStream fis = 
		new FileInputStream("user.ser");
		ObjectInputStream ois = 
		new ObjectInputStream(fis);
		User user2 = null;
		user2 = (User) ois.readObject();
		System.out.println(user2);
		
		ois.close();
		fis.close();
	}

}








