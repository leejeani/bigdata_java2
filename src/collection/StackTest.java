package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.search("b"));
		
		Queue<String> qu = new LinkedList<>();
		qu.add("a");
		qu.add("b");
		qu.add("c");
		System.out.println(qu.size());
		System.out.println(qu.peek());
	}

}









