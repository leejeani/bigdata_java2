package thread3;

public class Test {

	public static void main(String[] args) {
		Daemon d = new Daemon();
		Thread t = new Thread(d);
		t.setDaemon(true);
		t.start();
		
		for(int i=0;i<30;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
			if(i%7 == 0) {
				d.setAutoSave(true);
			}else {
				d.setAutoSave(false);
			}
		}
		
	}

}
