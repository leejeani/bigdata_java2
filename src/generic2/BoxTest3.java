package generic2;

public class BoxTest3 {

	public static void main(String[] args) {
		Box2<Apple, Grape> box = 
				new Box2<>();
		box.setItem1(new Apple());
		box.setItem2(new Grape());
		box.toString();
	}
}
