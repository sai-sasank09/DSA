package Arrays;

public class BalancedSubset {

	public static void main(String[] args) {
		int[] arr= {5,10,3,6,9,12};
		int ans= balancedSubset(arr);
		System.out.println(ans);
	}
	private static int balancedSubset(int[] arr) {
		int maxy=Integer.MIN_VALUE;
		int SpecialNum= -1;
		for (int i=0;i<arr.length;i++) {
			int count=0;
			for (int j=0;j<arr.length;j++) {
				if (arr[j]% arr[i]==0 ) {
					count++;
				}
			}
			if (count> maxy) {
			maxy=Math.max(maxy, count);
			SpecialNum=arr[i];
			}}
		return SpecialNum;
	}
}
