package CollegePractice;

public class Div {

	public static void main(String[] args) {
		System.out.println(ans(17,5));
	}
	static int sum(int n) {
		return n* (n+1)/2;
	}
	static int ans(int num,int div) {
		return sum(div-1) * (num/div) + sum(num%div);
	}

}
