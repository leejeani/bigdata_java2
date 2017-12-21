package thread;

public class T2 {

	public static void main(String[] args) {
		Calc c1 = new Calc("calc1");
		Calc c2 = new Calc("calc2");
		c1.calc();
		c2.calc();
	}

}

class Calc{
	String name;
	public Calc() {}
	public Calc(String name) {
		this.name = name;
	}	
	public void calc() {
		for(int i=0;i<1000;i++) {
			System.out.println(name+":"+ i);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}







