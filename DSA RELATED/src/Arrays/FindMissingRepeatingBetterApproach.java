package Arrays;
import java.util.HashMap;
public class FindMissingRepeatingBetterApproach {
	public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 2}; // Example input array
        int n = 5; // Size of the array
        
        int[] result = findTwoElement(a, n);
        System.out.println("Repeating number: " + result[0]);
        System.out.println("Missing number: " + result[1]);
    }
    
    public static int[] findTwoElement(int a[], int n) {
        int[] hash = new int[n + 1]; // hash array

        // Update the hash array:
        for (int i = 0; i < n; i++) {
            hash[a[i]]++;
        }

        // Find the repeating and missing number:
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeating = i;
            } else if (hash[i] == 0) {
                missing = i;
            }

            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        
        int[] ans = {repeating, missing};
        return ans;
    }
}


