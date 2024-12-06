package Stack;
import java.util.*;
public class PostfixToInfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postfix="ab+cd-*";
				
		String ans=postFixToInfix(postfix);
		System.out.println(ans);
	}
	static String postFixToInfix(String str) {
		Stack<String> stk= new Stack<>();
		for (int i=0;i<str.length();i++) {
//			System.out.println(stk);
			char ch=str.charAt(i);
			if ((ch>='A' && ch<='Z') || (ch >= 'a' &&ch<= 'z' )|| (ch>= '0' && ch<= '9') ) {
				stk.push(str.substring(i,i+1));
			}
			else {
				String t1= stk.peek();
				stk.pop();
				String t2=stk.peek();
				stk.pop();
				String val= "(" + t2+ str.substring(i,i+1) + t1 + ")";
				stk.push(val);
			}
		}
		
		return stk.peek();
	}

}
