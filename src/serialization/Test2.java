package serialization;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// ArrayList에 User 객체를
		// 5개 만든다.
		// ArrayList를 객체 직렬화 하여
		// userarray.ser에 저장 한다.
		// 저장 한 데이터를 읽어서
		// 화면에 출력 한다.

		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "이말숙"));
		list.add(new User("id02", "pwd02", "정말숙"));
		list.add(new User("id03", "pwd03", "김말숙"));

		FileOutputStream fos = new FileOutputStream("userarray.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(list);
		oos.close();
		bos.close();
		fos.close();
		System.out.println("정상 저장");

		FileInputStream fis = new FileInputStream("userarray.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<User> newlist = null;
		newlist = (ArrayList<User>) ois.readObject();
		for(User u: newlist) {
			System.out.println(u);
		}
		ois.close();
		fis.close();

	}

}

