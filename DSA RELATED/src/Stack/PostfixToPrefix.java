package Stack;
import java.util.*;
public class PostfixToPrefix {

	public static void main(String[] args) {
		
		String postfix="ab+cde+f^*g*+";
		System.out.println(postFixToPreFix(postfix));
	}

	private static String postFixToPreFix(String str) {
		Stack<String> stk= new Stack<>();
		String ans="";
		for (int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
//			if ((ch >= 'A' && ch<= 'Z') || (ch>='a' && ch<='z') && (ch >=0 && ch<=9)) {
//				stk.push(str.substring(i, i+1));
//			}
			if (Character.isLetterOrDigit(ch)) {
				stk.push(str.substring(i,i+1));
			}
			else {
				String t1=stk.peek();
				stk.pop();
				String t2= stk.peek();
				stk.pop();
				String val= str.substring(i,i+1) + t2+t1;
				stk.push(val);
			}
		}
		return stk.peek();
	}

}
