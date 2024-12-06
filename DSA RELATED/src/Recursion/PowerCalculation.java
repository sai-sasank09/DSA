package Recursion;


public class PowerCalculation {

    public static double pow(double x, int n) {
        // Base case: Any number to the power of 0 is 1
        if (n == 0) {
            return 1;
        }

        // If n is negative, we can handle it by computing the power of the positive exponent
        if (n < 0) {
            return 1 / pow(x, -n);
        }

        // Recursive step: x^n = x * x^(n-1)
        return x * pow(x, n - 1);
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = 3;
        System.out.println(x + "^" + n + " = " + pow(x, n)); // Output: 2.0^3 = 8.0
    }
}
