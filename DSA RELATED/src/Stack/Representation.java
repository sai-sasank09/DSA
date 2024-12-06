package Stack;
import java.util.ArrayDeque;
import java.util.Deque;
public class Representation {

	

	
	    public static void main(String[] args) {
	        // Create an ArrayDeque as a stack
	        Deque<Integer> stack = new ArrayDeque<>();

	        // Push elements onto the stack
	        stack.push(10);
	        stack.push(20);
	        stack.push(30);

	        // Print the stack
	        System.out.println("Stack: " + stack);

	        // Peek at the top element
	        System.out.println("Top element: " + stack.peek());

	        // Pop an element from the stack
	        int poppedElement = stack.pop();
	        System.out.println("Popped element: " + poppedElement);

	        // Print the stack after popping
	        System.out.println("Stack after pop: " + stack);

	        // Check if the stack is empty
	        if (stack.isEmpty()) {
	            System.out.println("The stack is empty.");
	        } else {
	            System.out.println("The stack is not empty.");
	        }
	    }
	


}
