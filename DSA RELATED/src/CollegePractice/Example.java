package CollegePractice;
import java.util.*;
public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {1,1,2,3,4,2,3,4,5};
		
		HashMap<Integer,Integer> mpp= new HashMap<>();
		
		for (int num:arr) {
			mpp.put(num, mpp.getOrDefault(num, 0)+1);
		}
		System.out.println(mpp);
		
		for (Map.Entry<Integer,Integer> entry: mpp.entrySet()) {
			if (entry.getValue() >1) {
				System.out.println(entry.getKey());
			}
		}
	}

}
