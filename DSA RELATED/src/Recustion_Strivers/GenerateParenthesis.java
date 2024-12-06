package Recustion_Strivers;
import java.util.*;
public class GenerateParenthesis {

	public static void main(String[] args) {
		
		int n=3;
		ArrayList<String> lst= new ArrayList<>();
//		StringBuilder current= new StringBuilder();
		generateParenthesis(0,0,n,"",lst);
		System.out.println(lst);
	}

	private static void generateParenthesis(int open, int close, int max, String current, ArrayList<String> lst) {
	
		if(current.length() == max*2) {
			lst.add(current);
		}
		
		
		if(open<max) {
			generateParenthesis(open+1,close,max,current+ "(",lst);
			
		}
		if(close<open) {
			generateParenthesis(open, close+1, max, current+")", lst);
		}
		
	}

}
