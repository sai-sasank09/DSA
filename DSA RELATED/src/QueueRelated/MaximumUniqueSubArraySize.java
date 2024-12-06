package QueueRelated;
import java.util.*;
public class MaximumUniqueSubArraySize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt(); //size of subarray
		
		int[] arr= new int[n];
		
		for (int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
			
		}
		Deque<Integer> deq= new ArrayDeque<Integer>();
		
		HashSet<Integer> uniqueSet= new HashSet<>();
		
		int maxUniqueCount=0;
		for (int i=0;i<m;i++) {
			deq.add(arr[i]);
			uniqueSet.add(arr[i]);
			
		}
		
		maxUniqueCount= uniqueSet.size();
		
		for (int i=m;i<n;i++) {
			int eleRem= deq.remove();
			if(!deq.contains(eleRem)) {
				uniqueSet.remove(eleRem);
			}
			
			int elemAdd= arr[i];
			deq.add(elemAdd);
			uniqueSet.add(elemAdd);
			
			maxUniqueCount= Math.max(maxUniqueCount, uniqueSet.size());
			
			
		}
		System.out.println(maxUniqueCount);
		
		

	}

}
