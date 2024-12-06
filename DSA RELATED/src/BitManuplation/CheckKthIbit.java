package BitManuplation;

public class CheckKthIbit {
	static boolean checkKthBit(int n, int k) {
        // Your code here
        String s= Integer.toBinaryString(n);
        for (int i=s.length()-1;i>=0;i--){
           
            if (k==0){
                if (s.charAt(i)=='1'){
                    return true;
                }
            }
             k--;
        }
        return false;
    }
	static boolean checkKthBitLeftShift(int n, int k) {
	    // Shift 1 to the left by k positions and perform bitwise AND with n
	    return (n & (1 << k)) != 0;
	}
	static boolean checkKthBitRightShift(int n, int k) {
	    // Shift n to the right by k positions and check the least significant bit (LSB)
	    return ((n >> k) & 1) != 0;
	}


	public static void main(String[] args) {
		System.out.println(checkKthBit(13,2));
	}

}
