package Strings;

public class Integer_Word {
	static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	static   String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	static   String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static   String[] places = {"", "Thousand", "Million", "Billion"};
	 
	    public  static String numberToWords(int num) {
	        if(num==0){
	            return "Zero";
	        }

	        StringBuilder result = new StringBuilder();
	        int ind=0;
	        while (num > 0){
	            int part= num % 1000;
	            if(part != 0){
	                result.insert(0,helper(part) + places[ind] + " ");
	            }
	            num/=1000;
	            ind++;
	        }
	        return result.toString().trim();
	       
	    }
	    public  static String helper(int num){
	               if (num == 0) return "";
	        else if (num < 10) return ones[num] + " ";
	        else if (num==10) return tens[1]+" ";
	        else if (num < 20) return teens[(num-11)] + " ";
	        else if (num < 100) return tens[num / 10] + " " + helper(num % 10);
	        else return ones[num / 100] + " Hundred " + helper(num % 100);

	    }
	    public static void main(String args[]) {
	    	System.out.println(numberToWords(12345));
	    }
}
