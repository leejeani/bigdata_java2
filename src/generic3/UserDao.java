package generic3;

import java.util.ArrayList;

public class UserDao<T, V> extends Dao<T, V> {

	@Override
	public void insert(T obj) {
		connect();
		User user = (User)obj;
		System.out.println("입력: "+user);
		close();
	}

	@Override
	public void delete(V id) {
		connect();
		System.out.println("삭제: "+id);
		close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(V id) {
		User u = new User("id01", "pwd01", "james");
		return (T)u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> get() {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "james"));
		list.add(new User("id02", "pwd02", "james"));
		return (ArrayList<T>) list;
	}

}








