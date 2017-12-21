package map;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MapTest2 {

	public static void main(String[] args) {
		HashMap<String, User> db = new HashMap<>();
		// 1. insert
		User user1 = new User("id01", "pwd01", "이말숙");
		db.put(user1.getId(), user1);
		User user2 = new User("id02", "pwd02", "공말숙");
		db.put(user2.getId(), user2);
		User user3 = new User("id03", "pwd03", "장말숙");
		db.put(user3.getId(), user3);
		// 2. update
		User temp = new User("id01","pwd11","이말숙");
		db.put(temp.getId(),temp);
		// 3. select
		User getUser = db.get("id01");
		System.out.println(getUser);
		// 4. delete
		db.remove("id02");
		// 5. select all
		// 모든 사용자 객체를 
		// ArrayList에 담아
		// 출력 하시오
		ArrayList<User> list = 
				new ArrayList<>();
		Set<String> set = db.keySet();
		for(String key:set) {
			User u = db.get(key);
			list.add(u);
		}
		
		// 출력
		for(User u:list) {
			System.out.println(u);
		}
	}

}







