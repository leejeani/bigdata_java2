package collection;

import java.util.HashSet;
import java.util.Random;

public class SetTest {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		// 1~45������ ���� �߿���
		// 6���� ���ڸ� �����ϰ� ���� �Ͽ�
		// ��� �Ͻÿ�
		
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






