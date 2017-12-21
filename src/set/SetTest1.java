package set;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest1 {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(10);
		set.add(10);
		set.add(37);
		set.add(29);
		set.add(48);
		set.add(90);
		set.add(68);
		set.add(1);
		System.out.println(set);
		
		SortedSet<Integer> ss1 = set.headSet(50);
		SortedSet<Integer> ss2 = set.tailSet(50);
		
		System.out.println(ss1);
		System.out.println(ss2);
	}

}






