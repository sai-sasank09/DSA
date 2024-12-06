package Recustion_Strivers;
import java.util.*;
public class Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		ArrayList<ArrayList<Integer>> lst= new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> minList=new ArrayList<>();
		
		subSeq(arr,0,lst,minList);
//		Set<ArrayList<Integer>> sett= new HashSet<>();
//		for (ArrayList<Integer> ars: lst) {
//			sett.add(ars);
//		}
		System.out.println(lst);
	}

	private static void subSeq(int[] arr, int i, ArrayList<ArrayList<Integer>> lst,ArrayList<Integer> minList) {
		if (i>=arr.length) {
//			System.out.println(lst);
		
			lst.add(new ArrayList<>(minList));
			
			return;
		}
		minList.add(arr[i]);
		subSeq(arr,i+1,lst,minList);
		minList.remove(minList.size()-1);
		subSeq(arr,i+1,lst,minList);
		
	}
	

}
