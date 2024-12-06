package Stack;
import java.util.*;

public class InbuiltExample {
	public static void main(String args[]) {
		Stack<Integer> stack= new Stack<>();
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		System.out.println(stack);
		stack.pop();
		stack.pop();
		for (int num : stack) {
			stack.set(0,50);
		}
		System.out.println(stack);
	
	}
}
