package db3;

public class Main {

	public static void main(String[] args) {
		Dao dao = new UserDao();
		User user = new User("id23", "pwd23", "�̸���");
		try {
			dao.insert(user);
			System.out.println("�Է��� �Ϸ� �Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�Է� �� ����");
		}
	}

}
