package Arrays;

public class InversionCount {
	 static long inversionCount(long arr[], int n) {
	        
	        long count = 0;
	        
	        // Time complexity is O(n2)
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = i + 1; j < n; j++) {
	                if (arr[i] > arr[j]) {
	                    count++;
	                    System.out.println("("+ arr[i]+ ","+ arr[j] + ")");
	                }
	            }
	        }
	        
	        return count;
	    }
	 
	 public static void main(String args[]) {
	long[] arr= {2,4,1,3,5};
	int n= arr.length;
		 long ans=inversionCount(arr,n);
		System.out.println(ans);
	 }
	 
}

    // Function to count inversions in the array.
   
