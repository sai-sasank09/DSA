package Graphs;
import java.util.*;

public class No_of_Islands {
	class Pair{
		int row,col;
		Pair(int row, int col){
			this.row= row;
			this.col=col;
		}
	}
	 public int numIslands(char[][] grid) {
	  int m=grid.length;
	  int n=grid[0].length;
	  boolean[][] visit= new boolean[m][n];
	  int cnt=0;
	  for (int row=0;row<m;row++) {
		  for (int col=0;col<n;col++) {
			  if (!visit[row][col] && grid[row][col]=='1') {
				  cnt++;
				  bfs(row,col,visit,grid);
			  }
		  }
	  }
	  	return cnt;
	  }

	 private void bfs(int row, int col, boolean[][] visit, char[][] grid) {
			visit[row][col]=true;
			Queue<Pair> q= new LinkedList<>();
			q.add(new Pair(row,col));
			int m=grid.length;
			int n=grid[0].length;
			  int[] delrow = {-1, 1, 0, 0};
	  int[] delcol = {0, 0, -1, 1};

			while (!q.isEmpty()) {
				int nrow= q.peek().row;
				int ncol= q.peek().col;
				q.poll();
				
					for (int i=0; i< 4; i++) {
						int frow= nrow+ delrow[i];
						int fcol= ncol + delcol[i];
						if (frow>=0 && frow<m && fcol>=0 && fcol < n &&
								grid[frow][fcol]=='1' && !visit[frow][fcol]) {
							visit[frow][fcol]=true;
							q.add(new Pair(frow,fcol));
						}
					}
				
			}
			
		}
	 
		
}
