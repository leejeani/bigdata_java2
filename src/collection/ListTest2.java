package collection;

import java.util.ArrayList;

public class ListTest2 {

	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id00", "pwd01", "james"));
		list.add(new User("id01", "pwd02", "james"));
		list.add(new User("id02", "pwd03", "james"));
		list.add(new User("id03", "pwd04", "james"));
		
		for(int i=0;i<list.size();i++) {
			User user = list.get(i);
			System.out.println(user.getId());
		}
	}

}







