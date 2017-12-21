package generic3;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		UserDao<User, String> dao = new UserDao<>();
		User u = new User("id01", "pwd01", "james");
		dao.insert(u);
		dao.delete("id01");
		
		User getu = null;
		getu = dao.get("id01");
		System.out.println(getu);
		
		ArrayList<User> list = null;
		list = dao.get();
		
		for(User us:list) {
			System.out.println(us);
		}
		
	}

}





