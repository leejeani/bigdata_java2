package db3;

import java.util.ArrayList;

public class SelectAllUserTest {

	public static void main(String[] args) {
		Dao dao = new UserDao();
		ArrayList<Object> list = null;

		try {
			list = dao.select();
			for(Object obj:list) {
				User user = (User)obj;
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}






