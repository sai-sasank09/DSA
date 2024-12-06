package Arrays;

class NextPermutation {
	
	public static void main(String args[]) {
		int[] nums= {2,4,5,3,1,6};
		nextPermutation(nums);
		for (int num:nums)
		System.out.print(" "+num);
	}
    static void swap(int[] nums,int a, int b){
       
       int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
       
    }
    static void reverse(int[] arr, int start,int end){
       while (start<end){
        swap(arr,start,end);
        start++;
        end--;
       }
    }
    static void nextPermutation(int[] nums) {
        int ind = -1;
        int n=nums.length;
        
        for (int i=n-2;i>=0;i--){
            if (nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
         if (ind==-1){
                reverse(nums,0,n-1);
                return;
            }
            for (int i=n-1;n>ind;i--){
                if(nums[ind] < nums[i]){
                    swap(nums,ind,i);
                    break;
                }
            }
            reverse(nums,ind+1,n-1);
    }
    
    
    
    
    
    
}
