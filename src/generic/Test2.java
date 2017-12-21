package generic;

import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("ab");
		list.add("cf");
		for(String s:list) {
			System.out.println(s.toUpperCase());
		}
	}

}





