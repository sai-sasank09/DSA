package ShortestPathGraphsAlgo;
import java.util.*;

public class FloydWarshallAlgo {
    public void shortestDistance(int[][] mat) {
        int n = mat.length;
        
        // Initialize matrix: replace -1 with infinity and set diagonal elements to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = (int) 1e9;  // Use a large number to represent infinity
                }
                if (i == j) {
                    mat[i][j] = 0;  // Distance from a node to itself is 0
                }
            }
        }

        // Floyd-Warshall Algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        // Convert large values (infinity) back to -1 to represent no path
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == (int) 1e9) {
                    mat[i][j] = -1;  // No path
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a sample graph matrix
        // -1 represents no direct path between nodes
        int[][] mat = {
            {0, 4, -1, -1, -1},
            {-1, 0, 3, -1, -1},
            {-1, -1, 0, 2, 2},
            {-1, -1, -1, 0, 3},
            {-1, -1, -1, -1, 0}
        };

        FloydWarshallAlgo fw = new FloydWarshallAlgo();
        fw.shortestDistance(mat);

        // Print the shortest distance matrix
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == (int) 1e9) {
                    System.out.print("INF ");  // No path
                } else {
                    System.out.print(mat[i][j] + " ");
                }
            }
            System.out.println();
        }
       
    }
}
