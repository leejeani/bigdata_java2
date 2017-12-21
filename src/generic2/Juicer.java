package generic2;

public class Juicer {
	public static void makeJuice(FBox<? extends Fruit> box) {
		System.out.println(box.toString());
	}
}
