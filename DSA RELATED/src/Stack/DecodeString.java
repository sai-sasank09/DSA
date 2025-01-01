package Stack;
import java.util.*;
public class DecodeString {
	 public static String decodeString(String s) {
	        Stack<Character> stk= new Stack<>();
	        for (int i=0;i<s.length();i++){
	            char ch=s.charAt(i);
	           
	            if (ch==']'){
	                StringBuilder str1= new StringBuilder();
	                while (!stk.isEmpty() && stk.peek()!='['){
	                str1.insert(0,stk.pop());
	                }
	                System.out.println(str1);
	                stk.pop();
	            StringBuilder num= new StringBuilder();
	            while (!stk.isEmpty() && Character.isDigit(stk.peek())){
	                num.insert(0,stk.pop());
	            }
	            
	            int count= Integer.parseInt(num.toString());
	            String repeat= str1.toString().repeat(count);
	             for (char c : repeat.toCharArray()) {
	                    stk.push(c);
	                }
	            }
	            else{
	                stk.push(s.charAt(i));
	            }
	            
	        }
	       StringBuilder result = new StringBuilder();
	       System.out.println(stk);
	        while (!stk.isEmpty()) {
	            result.insert(0, stk.pop());
	        }
	        
	        return result.toString();
	    }
	public static void main(String[] args) {
	System.out.println(decodeString("2[abc]3[cd]ef"));

	}

}
