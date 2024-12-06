package CollegePractice;

public class StairCase {
	public static void main(String args[]) {
		System.out.println(count(6));
	}
	static int fib(int n) {
		if (n<=1) {
			return 1;
		}
		return fib(n-1)+ fib(n-2);
	}
	static int count(int n) {
		return fib(n);
	}
}
