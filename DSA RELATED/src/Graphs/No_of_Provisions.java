package Graphs;

public class No_of_Provisions {
    public static void main(String[] args) {
        // Example input for connected provinces
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        
        int result = findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result);
    }

  
    public static int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visit = new boolean[isConnected.length];
        
        for (int i = 0; i < isConnected.length; i++) {
            if (!visit[i]) {  
                count++;       
                dfs(i, isConnected, visit); 
            }
        }

        return count;  // Return the total number of provinces
    }

    // DFS method to explore all connected nodes
    public static void dfs(int node, int[][] connect, boolean[] visit) {
        visit[node] = true;  
        for (int i = 0; i < connect.length; i++) {
           
            if (connect[node][i] == 1 && !visit[i]) {
                dfs(i, connect, visit); 
            }
        }
    }
}

