package Recursion;

public class Nto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int ans=Nto1(n);
		System.out.println(ans);
	}
	static int Nto1(int n) {
		
		if (n==1) {
			return 1;
		}
		
		
		System.out.println(n);
		
		return Nto1(n-1);
		
		
		
		
	}
}
