package set;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {

	public static void main(String[] args) {
		Set<User> set = new HashSet<>();
		set.add(new User("id01", "pwd01", "james"));
		set.add(new User("id01", "pwd01", "james"));
		
		System.out.println(set);
		
	}

}



