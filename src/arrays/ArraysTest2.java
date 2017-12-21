package arrays;

import java.util.Arrays;

public class ArraysTest2 {

	public static void main(String[] args) {
		String str[] = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));
		Arrays.sort(str,String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(str));
	}

}






