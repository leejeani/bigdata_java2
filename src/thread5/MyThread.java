package thread5;

public class MyThread extends Thread{

	@Override
	public void run() {
		while(!isInterrupted()) {
			System.out.println("Get Data ...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // end while
		System.out.println("The End ...");
	}

}
