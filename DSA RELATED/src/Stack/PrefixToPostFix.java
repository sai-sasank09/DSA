package Stack;
import java.util.*;
public class PrefixToPostFix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prefix="/-AB*+DEF";
		System.out.println(preFixToPostFix(prefix));
	}

	private static String preFixToPostFix(String str) {
		Stack<String> stk= new Stack<>();
		String ans="";
		for (int i=str.length()-1;i>=0;i--) {
			char ch=str.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				stk.push(str.substring(i,i+1));
			}
			else {
				String t1=stk.peek();
				stk.pop();
				String t2=stk.peek();
				stk.pop();
				String val= t1+t2+str.substring(i,i+1);
				stk.push(val);
			}
		}
		return stk.peek();
	}

}
