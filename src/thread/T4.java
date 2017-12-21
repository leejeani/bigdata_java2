package thread;


class Display{
	String name;
	public Display() {}
	public Display(String name) {
		this.name = name;
	}
	Thread t = new Thread() {
		@Override
		public void run() {
			while(true) {
				System.out.println(name+" ");
			}				
		}
	};
	
	Runnable r= new Runnable() {		
		@Override
		public void run() {
			for(int i=0;i<1000;i++) {
				System.out.println(name+" "+i);
			}				
		}
	};
	public void display() {
		t.start();	
	}

}


public class T4 {

	public static void main(String[] args) {
		Display d1 = new Display("ÀÌÄ¡È£1");
		d1.display();
	}

}









