package thread;

public class T1 {

	public static void main(String[] args) {
		System.out.println("start iexplore");
		double sum = 0;
		for(int i=0;i<1000000000;i++) {
			System.out.println("start1:"+i);
			sum += i;
		}
		System.out.println(sum);
		double sum2 = 0;
		for(int i=0;i<1000000000;i++) {
			System.out.println("start2:"+i);
			sum2 += i;
		}
		System.out.println(sum2);
		System.out.println("end iexplore");
	}

}
