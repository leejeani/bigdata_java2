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
		
		// list1에서 데이터를 읽어서 
		Iterator<String> it = list1.iterator();
		// list2에 넣는다.
		while(it.hasNext()) {
			String str = it.next();
			list2.add(str);
			it.remove();
		}
		// 단 list1에서는 삭제 한다.
		// list2에 내용을 출력 하시오
		Iterator<String> it2 = 
				list2.iterator();
		while(it2.hasNext()) {
			String str = it2.next();
			System.out.println(str);
		}

		
		
		
	}

}






