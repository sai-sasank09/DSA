package Stack;

import java.util.Stack;

public class PrefixToInfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prefix="*+pq-mn";
		System.out.println(preFixToInfix(prefix));
	}

	private static String preFixToInfix(String str) {
		Stack<String> stk= new Stack<>();
		for (int i=str.length()-1;i>=0;i--) {
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
				String val= "(" + t1+ str.substring(i,i+1) + t2 + ")";
				stk.push(val);
			}
		}
		return stk.peek();
	}
	

}
