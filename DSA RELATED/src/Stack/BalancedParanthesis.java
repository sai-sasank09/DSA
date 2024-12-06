package Stack;
import java.util.*;

public class BalancedParanthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(isBalanced(input));
        }
        
        scanner.close();
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                // Push open brackets onto the stack
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop(); // Pop the top element
                
                // Check if the closing bracket matches the top of the stack
                if ((ch == ')' && top != '(') || 
                    (ch == '}' && top != '{') || 
                    (ch == ']' && top != '[')) {
                    return false; // Mismatch found
                }
            }
        }
        
        // If the stack is empty, all brackets matched
        return stack.isEmpty();
    }
}
