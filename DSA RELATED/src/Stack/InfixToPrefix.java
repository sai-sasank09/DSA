package Stack;

import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        String str = "a+b+c*(d+e)^f*g";
        String reversed = "";

        // Reverse the original expression
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        // Convert the reversed infix expression to prefix
        String prefix = infixToPrefix(reversed);
        System.out.println(prefix);
    }

    public static int prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPrefix(String exp) {
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder(); // Use StringBuilder for efficiency

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If the character is an operand, add it to the result
            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            }
            // If the character is '(', push it to stack
            else if (ch == ')') {
                stk.push(ch);
            }
            // If the character is ')', pop until '(' is found
            else if (ch == '(') {
                while (!stk.isEmpty() && stk.peek() != ')') {
                    ans.append(stk.pop());
                }
                stk.pop(); // Remove ')'
            } else { // Operator
                while (!stk.isEmpty() && prec(ch) <= prec(stk.peek())) {
                    ans.append(stk.pop());
                }
                stk.push(ch);
            }
        }

        // Pop all remaining operators from the stack
        while (!stk.isEmpty()) {
            if (stk.peek() == ')') {
                return "Invalid Expression"; // Invalid if unmatched parenthesis
            }
            ans.append(stk.pop());
        }

        // Reverse the output to get prefix notation
        String prefix = ans.reverse().toString();
        return prefix;
    }
}
