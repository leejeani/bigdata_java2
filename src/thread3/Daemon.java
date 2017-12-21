package thread3;

public class Daemon implements Runnable{

	boolean autoSave = false;
	
	
	public void setAutoSave(boolean autoSave) {
		this.autoSave = autoSave;
	}

	public Daemon() {
		
	}
	
	@Override
	public void run() {
		while(true) {
			//System.out.println("Daemon ..");
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(autoSave) {
				save();
			}
		}
	}

	private void save() {
		System.out.println("Auto Save .....");
	}
	
}






