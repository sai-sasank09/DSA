package CollegePractice;
import java.util.*;
public class Subarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5, 4, -1, 7, 8};
		ArrayList<ArrayList<Integer>> subarr= new ArrayList<>();
		System.out.println(Arrays.toString(maxSum(arr)));
	}

	private static int[] maxSum(int[] arr) {
		// TODO Auto-generated method stub
		int maxy=0;
		ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
		
//		for (int i=0;i<arr.length;i++) {
//			
//			for (int j=i;j<arr.length;j++) {
//				int sum=0;
//				for (int k=i;k<=j;k++) {
//					sum=sum+arr[k];
//				}
//				maxy=Math.max(maxy, sum);
//			
//				
//				
//			}
////			System.out.print(sum+" ");
//		}
//		maxy=arr[0];
//		int maxy1=arr[0];
//		for (int i=1;i<arr.length;i++) {
//			maxy=Math.max(arr[i], maxy+arr[i]);
//			maxy1=Math.max(maxy, maxy1);
//		}
//		
//		
//		return maxy1;
		
		
		
		for (int i=0;i<arr.length;i++) {
			ArrayList<Integer> ls= new ArrayList<>();
			for (int j=i;j<arr.length;j++) {
				
				ls.add(arr[j]);
				
				ans.add(new ArrayList<>(ls));
				
			}
		}
		System.out.println(ans);
		
		return null;
	}

}
