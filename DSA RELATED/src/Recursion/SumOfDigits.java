package Recursion;

public class SumOfDigits {

	public static void main(String[] args) {
		int n= 13425;
		int ans=DigitSum(n,0);
		int ansProduct= DigitProduct(n,1);
		System.out.println(ans);
		System.out.println(ansProduct);
		
	}

	private static int DigitProduct(int n, int product) {
		// TODO Auto-generated method stub
		if (n==0) {
			return product;
		}
		
		int rem= n%10;
		product= product*rem;
//		System.out.println(sum);
		return DigitProduct(n/10,product);
	}

	private static int DigitSum(int n,int sum) {
		// TODO Auto-generated method stub
		if (n==0) {
			return sum;
		}
		
		int rem= n%10;
		sum= sum+rem;
//		System.out.println(sum);
		return DigitSum(n/10,sum);
		
	}

}
