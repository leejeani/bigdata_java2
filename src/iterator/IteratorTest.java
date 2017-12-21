package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorTest {

	public static void main(String[] args) {
		ArrayList<String> list 
		= new ArrayList<>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		System.out.println("--------------------");
		
		ListIterator<String> lit
		= list.listIterator();
		while(lit.hasNext()) {
			String str = lit.next();
			System.out.println(str);
			lit.remove();
		}
		while(lit.hasPrevious()) {
			String str = lit.previous();
			System.out.println(str);
		}
		
		
	}

}



