package Recursion;

public class FibanocciSeries {
	//base condition
	static int Fibanocci(int n) {
		if (n<2) {
			return n;
		}
		
		return Fibanocci(n-1) + Fibanocci(n-2);
		
	}
	public static void main(String[] args) {
		
		int ans= Fibanocci(2);
		System.out.println(ans);
	}

}
