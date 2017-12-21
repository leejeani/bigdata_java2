package db3;

public class Main {

	public static void main(String[] args) {
		Dao dao = new UserDao();
		User user = new User("id23", "pwd23", "이말숙");
		try {
			dao.insert(user);
			System.out.println("입력이 완료 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입력 시 오류");
		}
	}

}
