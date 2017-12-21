package generic3;

import java.util.ArrayList;

public abstract class Dao<T,V> {
	
	public abstract void insert(T obj);
	public abstract void delete(V id);
	public abstract T get(V id);
	public abstract ArrayList<T> get();
	
	public void connect() {
		System.out.println("Connect");
	}
	public void close() {
		System.out.println("Close");
	}
}
