package thread4;

public class MyThread extends Thread{

	@Override
	public void run() {
		int i = 0;
		while(!isInterrupted()) {
			i++;
			System.out.println("Get Data ..."+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // end while
		System.out.println("The End ...");
	}

}
