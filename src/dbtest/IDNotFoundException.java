package dbtest;

public class IDNotFoundException extends Exception {
	public IDNotFoundException(){
		super("IDNotFoundException Exception ...");
	}
	public IDNotFoundException(String str){
		super(str);
	}
}
