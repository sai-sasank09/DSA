package DP;

public class Dominos_Trominos {
	int M = 1000000007;   // The modulo value
    int[] t = new int[1001];   // Array to store results for different n values

    // Helper function using recursion with memoization
    public int solve(int n) {
        // Base cases
        if (n == 1 || n == 2) {
            return n; // If n is 1 or 2, just return n
        }
        if (n == 3) {
            return 5; // If n is 3, return the known result (5 ways)
        }

        // If we have already calculated this value, return it
        if (t[n] != -1) {
            return t[n];
        }

        // Recursive formula to compute the result with modulo
        t[n] = (2 * solve(n - 1) % M + solve(n - 3) % M) % M;
        
        // Return the computed value
        return t[n];
    }

    // Main function to call the solve function
    public int numTilings(int n) {
        // Initialize the array to store memoized values (initially all -1)
        for (int i = 0; i < t.length; i++) {
            t[i] = -1;
        }
        
        // Start the recursion and return the result for `n`
        return solve(n);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dominos_Trominos obj= new Dominos_Trominos();
		System.out.println(obj.numTilings(5));
	}

}
