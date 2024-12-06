package Stack;
import java.util.*;
public class InfixToPostfix {

	public static void main(String[] args) {
		System.out.println(infixToPostfix("a+b+c*(d+e)^f*g"));
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
   public static String infixToPostfix(String exp) {
       Stack<Character> stk= new Stack<>();
       String ans= new String("");

       for (int i=0;i<exp.length();i++){
           char ch=exp.charAt(i);
           if (Character.isLetterOrDigit(ch)){
               ans +=ch;
           }
           else if(ch=='('){
               stk.push(ch);
           }
           else if(ch==')'){
               while (!stk.isEmpty() && stk.peek() != '(') {
                   ans += stk.pop();
               }
                 stk.pop();
           }
           else{
               while(!stk.isEmpty() && prec(ch) <= prec(stk.peek())){
                   ans += stk.pop();
               }
               stk.push(ch);
           }
       }
       while (!stk.isEmpty()){
           if(stk.peek() =='(') {
              return "Invalid Expression";
           }
           ans += stk.pop();
       }

       return ans;
   }
}
