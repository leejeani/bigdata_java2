package db3;

public class SelectUserTest {

	public static void main(String[] args) {
		Dao dao = new UserDao();
		User user = null;
		try {
			user = (User) dao.select("id22");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
