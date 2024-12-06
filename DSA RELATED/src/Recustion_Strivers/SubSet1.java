package Recustion_Strivers;
import java.util.*;
public class SubSet1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3};
		ArrayList<Integer> sumArr= new ArrayList<>();
		findSubSet(0,0,arr,sumArr);
		Collections.sort(sumArr);
		System.out.println(sumArr);
		
	}

	private static void findSubSet(int ind, int sum,int[] arr, ArrayList<Integer> sumArr) {
		// TODO Auto-generated method stub
		if(ind>=arr.length) {
			sumArr.add(sum);
			return;
		}
//		sum += arr[ind];
		findSubSet(ind+1,sum+arr[ind],arr,sumArr);
//		sum -= arr[ind];
		findSubSet(ind+1,sum,arr,sumArr);
				
		
	}

}
