package Strings;

public class MaximumNestingDepthOfParenthesis {
	public static void main(String args[]) {
		int ans= maxDepth("(1)+((2))+(((3)))");
		System.out.println(ans);
	}
	 public static int maxDepth(String s) {
	        char[] arr= s.toCharArray();
	        int count=0;
	        int maxy=  0;
	        for (int i=0;i<arr.length;i++){
	           
	            if (arr[i]== '(' ){
	                count++;
	               
	                maxy= Math.max(maxy, count);
	            
	            }
	            else if (arr[i]== ')'){
	                count--;
	            }
	        }
	        return maxy;
	    }
}

   
