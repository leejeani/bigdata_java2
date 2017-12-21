package collection;

import java.util.HashSet;
import java.util.Random;

public class SetTest {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		// 1~45까지의 숫자 중에서
		// 6개의 숫자를 랜돔하게 추출 하여
		// 출력 하시오
		
		Random random = new Random();
		while(true) {
			int data = random.nextInt(45)+1;
			set.add(data);
			if(set.size() == 6) {
				break;
			}
		}
		
		for(Integer i:set) {
			System.out.print(i+" ");
		}
	}

}






