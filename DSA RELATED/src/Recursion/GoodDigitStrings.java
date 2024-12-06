package Recursion;
public class GoodDigitStrings {
    private static final int MOD = 1000000007;

    public int countGoodDigitStrings(int n) {
        return countGoodDigitStringsRec(n, 0);
    }

    private int countGoodDigitStringsRec(int n, int index) {
        // Base case: If we've filled all positions, return 1
        if (index == n) {
            return 1;
        }

        // Count of good strings starting at the current index
        long count = 0;

        if (index % 2 == 0) {
            // Even index: We can place 0, 2, 4, 6, or 8
            for (int digit : new int[]{0, 2, 4, 6, 8}) {
                count += countGoodDigitStringsRec(n, index + 1);
                count %= MOD;  // Take modulo to avoid overflow
            }
        } else {
            // Odd index: We can place 2, 3, 5, or 7
            for (int digit : new int[]{2, 3, 5, 7}) {
                count += countGoodDigitStringsRec(n, index + 1);
                count %= MOD;  // Take modulo to avoid overflow
            }
        }

        return (int) count;
    }

    public static void main(String[] args) {
        GoodDigitStrings solution = new GoodDigitStrings();
        
        System.out.println(solution.countGoodDigitStrings(1)); // Output: 5
        System.out.println(solution.countGoodDigitStrings(4)); // Output: 400
        System.out.println(solution.countGoodDigitStrings(50)); // Output: 564908303
    }
}
