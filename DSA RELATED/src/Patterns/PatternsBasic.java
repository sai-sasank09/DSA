package Patterns;

public class PatternsBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n=5;
//		starPattern(5);
//		hollowSquare(5);
//		diagonal(5);
//		rightAngled(5);
//		reverseRight(5);
//		hollowRight(5);
//		reverseRight(5);
//		pyramid(5);
//		reversePyramid(5);
		rightInvert(5);
	}
	static void reversePyramid(int n) {
		for (int i=n;i>=1;i--) {
			for (int j=n-i;j>=1 ;j--) {
				System.out.print(" ");
			}
			for (int j=2*i-1;j>=1;j--) {
				System.out.print("*");
			}
			for (int j=n-i;j>=1 ;j--) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	static void pyramid(int n) {
		for (int i=1;i<=n;i++) {
			for (int j=1;j<= n -i;j++) {
				System.out.print(" ");
			}
			for (int j=1;j<=2*i-1;j++) {
				System.out.print("*");
			}
			for (int j=1;j<= n -i;j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	static void reverseRight(int n) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<=n-i-1;j++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void rightInvert(int n) {
		for (int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i=n-2;i>=0;i--) {
			for (int j=0;j<=i;j++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void rightAngled(int n) {
		for (int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	static void hollowRight(int n) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<=i;j++) {
				if (j==0 || i==n-1 || i==j)
				System.out.print("* ");
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void starPattern(int n) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	public static void hollowSquare(int n) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if ((i==0) || (i==n-1)||(j==0 || j==n-1) ){
					System.out.print("* ");
				}
				
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	
	static void diagonal(int n) {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (i==j) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

}
