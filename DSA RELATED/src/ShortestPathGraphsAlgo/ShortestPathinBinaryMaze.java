package ShortestPathGraphsAlgo;
import java.util.*;

public class ShortestPathinBinaryMaze {
    class Tuple {
        int first, second, third;

        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) {
            return -1;
        }

        Queue<Tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0, source[0], source[1]));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int dis = it.first;
            int r = it.second;
            int c = it.third;

            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m &&
                    grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    
                    dist[newr][newc] = dis + 1;
                    if (newr == destination[0] && newc == destination[1]) {
                        return dis + 1;
                    }
                    q.add(new Tuple(dis + 1, newr, newc));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathinBinaryMaze spm = new ShortestPathinBinaryMaze();
        
        int[][] grid = {
            {1, 1, 0, 1},
            {1, 1 , 1, 1},
            {1, 0, 1, 0},
            {0, 1, 1, 1}
        };
        
        int[] source = {0, 0};
        int[] destination = {3, 2};

        int result = spm.shortestPath(grid, source, destination);
        System.out.println("Shortest path length: " + result);
    }
}
