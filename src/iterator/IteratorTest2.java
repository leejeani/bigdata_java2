package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest2 {

	public static void main(String[] args) {
		ArrayList<String> list1 =
				new ArrayList<>();
		ArrayList<String> list2 =
				new ArrayList<>();

		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		// list1���� �����͸� �о 
		Iterator<String> it = list1.iterator();
		// list2�� �ִ´�.
		while(it.hasNext()) {
			String str = it.next();
			list2.add(str);
			it.remove();
		}
		// �� list1������ ���� �Ѵ�.
		// list2�� ������ ��� �Ͻÿ�
		Iterator<String> it2 = 
				list2.iterator();
		while(it2.hasNext()) {
			String str = it2.next();
			System.out.println(str);
		}

		
		
		
	}

}






