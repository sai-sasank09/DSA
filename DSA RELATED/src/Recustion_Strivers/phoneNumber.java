package Recustion_Strivers;
import java.util.*;
public class phoneNumber {
	
	public static final String[] phoneNum=  {"","","abc","def","ghj","jkl","mno","pqrs","tuv","wxyz" };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits="23";
		 List<String> lst= new ArrayList<>();
		 StringBuilder current= new StringBuilder();
	        func(current,digits,lst,0);
	        System.out.println(lst);
	}
	public static void func(StringBuilder current,String digits,List<String> lst,int ind) {
		
		if(ind==digits.length()) {
			lst.add(current.toString());
			return;
		}
		
		String letters= phoneNum[digits.charAt(ind)-'0'];
//		System.out.println(letters);
		//{2,3}
		for(char lett:letters.toCharArray()) {
			current.append(lett);
			func(current,digits,lst,ind+1);
			current.deleteCharAt(current.length()-1);
		}
		
		
		
	}

}
