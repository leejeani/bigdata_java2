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
		// ArrayList�� User ��ü��
		// 5�� �����.
		// ArrayList�� ��ü ����ȭ �Ͽ�
		// userarray.ser�� ���� �Ѵ�.
		// ���� �� �����͸� �о
		// ȭ�鿡 ��� �Ѵ�.

		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "�̸���"));
		list.add(new User("id02", "pwd02", "������"));
		list.add(new User("id03", "pwd03", "�踻��"));

		FileOutputStream fos = new FileOutputStream("userarray.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(list);
		oos.close();
		bos.close();
		fos.close();
		System.out.println("���� ����");

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

