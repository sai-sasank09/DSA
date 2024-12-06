package Stack;
import java.util.*;
public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num="1432219";
		int k=3;
		System.out.println(removeKDigits(num,k));
	}
	static String removeKDigits(String num,int k) {
		
		Stack<Character> stk= new Stack<>();
		
			for (int i=0;i<num.length();i++) {
				char ch=num.charAt(i);
				while (!stk.isEmpty() && stk.peek() > ch && k>0) {
					stk.pop();
					k--;
				}
				
				stk.push(ch);
			}
			  while (k > 0 && !stk.isEmpty()) {
		            stk.pop();
		            k--;
		        }
//			  System.out.println(stk.get(1));
			StringBuilder str= new StringBuilder();
			for (int i=stk.size()-1;i>=0;i--) {
				str.append(stk.pop());
			}
		
		
		
		return str.reverse().toString();
	}
}
