package collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.xml.bind.util.ValidationEventCollector;

public class ListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(10000);
		
		list.add(6);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(10);
		Collections.sort(list);
		//list.remove(0);
		System.out.println(list.size()+" "+list.get(3));
		System.out.println("-----------------------");
		for(Object obj:list) {
			if(obj instanceof User) {
				User temp = (User) obj;
				System.out.println(temp.getId());
			}else {
				System.out.println(obj);	
			}
		} // end for
		
		LinkedList ll = new LinkedList();
		
		
	}

}









