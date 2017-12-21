package collection;

import java.util.Stack;

public class StackTest2 {
	static Stack<String> back = new Stack<>();
	static Stack<String> forword = new Stack<>();
	
	public static void main(String[] args) {
		back.push("4.naver");
		back.push("3.daum");
		back.push("2.google");
		back.push("1.nate");
		printStatus();
		goBack();
		printStatus();
		goBack();
		printStatus();
		goForword();
		printStatus();
	}
	public static void goBack() {
		String page = back.pop();
		forword.push(page);	
	}
	public static void goForword() {
		String page = forword.pop();
		back.push(page);
	}
	public static void printStatus() {
		System.out.println(back);
		System.out.println(forword);
		System.out.println("현재화면"+back.peek());
	}

}



