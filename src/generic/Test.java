package generic;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("ab");
		list.add(100);
		for(Object o:list) {
			if(o instanceof String) {
				String str = (String)o;
				System.out.println(str.toUpperCase());
			}else {
				System.out.println(o);
			}
		}
	}

}




