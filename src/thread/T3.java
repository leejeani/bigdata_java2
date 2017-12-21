package thread;

class TCalc extends Thread{
	String name;
	public TCalc() {}
	public TCalc(String name) {
		this.name = name;
	}
	public void run() {
		for(int i=0;i<1000;i++) {
			
			System.out.println(name+" "+i);
			Thread.yield();
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			
		}
	}
}


class TCalc2 implements Runnable{
	String name;
	public TCalc2() {}
	public TCalc2(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(name+" "+i);
			Thread.yield();
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}		
	}
	
	
}

public class T3 {

	public static void main(String[] args) {
		TCalc tc1 = new TCalc("calc1");
		TCalc tc2 = new TCalc("calc2");
		
		Runnable r1 = new TCalc2("clac3");
		Thread tc3 = new Thread(r1);
		
		tc1.start();
		//tc2.start();
		tc3.start();

	}

}










