package Recursion;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int n=5;
			int ans=nFactorial(n);
			System.out.println(ans);
	}

	static int nFactorial(int n) {
		if (n==1) {
			return 1;
		}
		
		
		return n * nFactorial(n-1);
		
		
		
		
	}

}
