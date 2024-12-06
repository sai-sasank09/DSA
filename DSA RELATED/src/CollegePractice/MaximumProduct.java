package CollegePractice;

public class MaximumProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maximumProduct(10));
	}

	private static int maximumProduct(int num) {
		if(num%3==0) {
			double result= Math.pow(3, num/3);
			return (int)result;
		}
		if(num %3==2) {
			double result= Math.pow(3, num/3) *2;
			return (int)result;
		}
		if(num %3==1) {
			double result= Math.pow(3, num/3 -1) * 4;
			return (int)result;
		}
		return -1;
	}

}
