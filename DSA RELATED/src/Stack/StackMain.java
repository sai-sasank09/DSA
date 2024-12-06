package Stack;
import java.util.*;
public class StackMain {

	public static void main(String[] args) throws StackException {
		// TODO Auto-generated method stub
		DyanamicStack stack= new DyanamicStack(5);
		stack.push(5);
		stack.push(15);
		stack.push(25);
		stack.push(35);
		stack.push(45);
		stack.push(45);
		stack.push(45);
		stack.push(45);stack.push(435);
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
	}

}
