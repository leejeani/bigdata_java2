package generic2;

import java.util.ArrayList;

public class BoxTest {

	public static void main(String[] args) {
		Box<Apple> box1 = new Box<>();
		Box<String> box2 = new Box<>();
		Box<Fruit> box3 = new Box<>();
		
		box1.add(new Apple());
		box1.add(new Apple());
		
		System.out.println(box1.size());
		
		ArrayList<Apple> list = box1.getList();
		for(Apple apple:list) {
			System.out.println(apple.getSweetness());
		}
		
		
		box3.add(new Apple());
		box3.add(new Grape());
		
		ArrayList<Fruit> list2 = box3.getList();
		for(Fruit f:list2) {
			System.out.println(f.toString());
		}
	}

}







