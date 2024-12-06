package Queue;
import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        
        int n=nums.length;
        int[] res= new int[n-k+1];
        Deque<Integer> dq= new LinkedList<>();
        for (int i=0;i<n;i++) {
        	if (!dq.isEmpty() && dq.peekFirst() == i-k) {
        		dq.pollFirst();
        	}
        	while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        		dq.pollLast();
        	}
        	dq.offerLast(i);
        	if (i>=k-1) {
        		res[i-k+1]= nums[dq.peekFirst()];
        	}
        }
        
        

//        int n = nums.length;
//        int[] res = new int[n - k + 1];
//        Deque<Integer> deque = new LinkedList<>();
//        
//        for (int i = 0; i < n; i++) {
//            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
//                deque.pollFirst();
//            }
//            
//            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
//                deque.pollLast();
//            }
//            
//            deque.offerLast(i);
//            
//            if (i >= k - 1) {
//                res[i - k + 1] = nums[deque.peekFirst()];
//            }
//        }
//        
        return res;
    }

    public static void main(String[] args) {
       
        
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        int[] result = maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}