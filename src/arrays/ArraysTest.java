package arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {
		int a [] = {2,1,5,4,3};
		Arrays.sort(a);
		System.out.println(Arrays.binarySearch(a, 2));
		for(int i :a) {
			System.out.println(i);
		}
		
		Integer [] ii = {1,2,3,4,5};
		List list = new ArrayList(Arrays.asList(ii));
		list.add(6);
		System.out.println(list);
//		System.out.println(Arrays.toString(a));
//		int b [] = null;
//		b = Arrays.copyOfRange(a, 2,4);
//		System.out.println(Arrays.toString(b));
//		Arrays.fill(a, 9);
//		System.out.println(Arrays.toString(a));
		
		
	}

}





