package property;

import java.util.ArrayList;
import java.util.Collections;

public class Ex6 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		ArrayList list = new ArrayList();
		
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println(list);
		Collections.rotate(list, 2);
		System.out.println(list);
		Collections.swap(list, 0,3);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		Collections.replaceAll(list, 1, 9);
		System.out.println(list);
		
	}

}









