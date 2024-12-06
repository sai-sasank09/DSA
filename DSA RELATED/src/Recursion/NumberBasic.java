package Recursion;

public class NumberBasic {
	static void Number(int n) {
		// base condition
		if (n==6) {
			return;
		}
		// body
		System.out.println(n);
		
		// recursive calls
		
		Number(n+1);
		
	}
	public static void main(String[] args) {
		Number(1);

	}

}
