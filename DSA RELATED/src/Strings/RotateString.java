package Strings;

public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rotateString("abcde","cdeab"));
	}
	public static boolean rotateString(String s, String goal) {
		
		String concated= s+s;
		
		
		return concated.contains(goal);
    }


}
