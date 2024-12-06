package GreedyApproach;

public class LemonadeChange {
	 public static  boolean lemonadeChange(int[] bills) {
	        int f=0;
	        int t=0;
	        int twe=0;
	        for (int i=0;i<bills.length;i++){
	            if (bills[i]==5){
	                f++;
	            }
	            else if (bills[i]==10){
	               if (f>0){
	                f--;
	                t++;
	               }
	               else return false;
	            }
	            else {
	                if (f>0 && t>0){
	                    f--;
	                    t--;
	                }
	                else if (f >= 3){
	                    
	                    f -= 3;  
	                }
	                else return false;
	            }   
	        }
	        return true;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,5,5,10,20};
		System.out.println(lemonadeChange(arr));

	}

}
