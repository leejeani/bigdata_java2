package generic2;

public class BoxTest2 {

	public static void main(String[] args) {
		FBox<Fruit> box = new FBox<>();
		box.add(new Apple());
		box.add(new Grape());
		
		Juicer.makeJuice(box);
	}

}
