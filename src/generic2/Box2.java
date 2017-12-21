package generic2;

public class Box2<T,V> {
	T item1;
	V item2;
	public T getItem1() {
		return item1;
	}
	public void setItem1(T item1) {
		this.item1 = item1;
	}
	public V getItem2() {
		return item2;
	}
	public void setItem2(V item2) {
		this.item2 = item2;
	}
	@Override
	public String toString() {
		return "Box2 [item1=" + item1 + ", item2=" + item2 + "]";
	}
	
}
