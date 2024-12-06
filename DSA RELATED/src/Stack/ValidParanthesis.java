package Stack;
import java.util.*;
public class ValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(isBalanced("()[]{}"));
	}
	 public static boolean isBalanced(String s){
	        // Write your code here.
	        Stack<Character> stk= new Stack<>();

	        for (char ch:s.toCharArray()){
	            if (ch=='(' || ch=='{' || ch=='['){
	                stk.push(ch);
	            }
	            else {
	                if (stk.isEmpty()) return false;
	                char pp= stk.pop();
	                if ((ch == ')' && pp=='(') || (ch=='}' && pp=='{') || (ch==']' && pp=='[')) {
	                    continue;}
	                else return false;
	            }
	        }

	        return stk.isEmpty();

	    }

}
