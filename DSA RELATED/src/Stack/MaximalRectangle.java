package Stack;

import java.util.Stack;
import java.util.Scanner;

public class MaximalRectangle {
    // Method to calculate the maximal rectangle in a 2D binary matrix
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];

        // Process each row in the matrix
        for (int i = 0; i < n; i++) {
            // Update the histogram heights for the current row
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;  // Increase height for '1'
                } else {
                    heights[j] = 0;   // Reset height for '0'
                }
            }
            // Calculate the maximal rectangle area for the current histogram
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // Method to calculate the largest rectangle in a histogram
    static int largestRectangleArea(int histo[]) {
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        int n = histo.length;

        for (int i = 0; i <= n; i++) {
            // Calculate area for each rectangle ending at position i
            while (!st.isEmpty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }

        return maxA;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of rows:");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns:");
        int m = sc.nextInt();
        
        char[][] matrix = new char[n][m];
        
        System.out.println("Enter the matrix elements (as '1' or '0'):");
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }
      
        int maxRectangle = maximalRectangle(matrix);
        
        System.out.println("Maximal rectangle area is: " + maxRectangle);
    }
}
