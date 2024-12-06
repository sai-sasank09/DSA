package Graphs;

public class NoOfEnclaves {
	  public int numEnclaves(int[][] grid) {
	        int m= grid.length;
	        int n=grid[0].length;
	        boolean[][] visit= new boolean[m][n];
	        for(int i=0;i<m;i++){
	            if (grid[i][0]==1) dfs(i,0,visit,grid);
	            if (grid[i][n-1]==1) dfs(i,n-1,visit,grid);
	        }    
	        for (int j=0;j<n;j++){
	            if (grid[0][j]==1) dfs(0,j,visit,grid);
	            if (grid[m-1][j]==1) dfs(m-1,j,visit,grid);
	        }
	        int count=0;
	        for (int i=0;i<m;i++){
	            for (int j=0;j<n;j++){
	                if (grid[i][j]==1 && !visit[i][j]){
	                    count++;
	                }
	            }
	        }
	        return count;

	    }
	    public static void dfs(int row,int col,boolean[][] visit,int[][] grid){
	        visit[row][col]=true;
	       
	        int[] delRow = {-1, 1, 0, 0};
	        int[] delCol = {0, 0, -1, 1};
	       for (int i=0;i<4;i++){
	        int nrow= delRow[i]+row;
	        int ncol=delCol[i]+col;
	        if (nrow>=0 &&  nrow< grid.length && ncol>=0 &&
	             ncol < grid[0].length && visit[nrow][ncol]==false && grid[nrow][ncol]==1){
	            dfs(nrow,ncol,visit,grid);
	        }
	       }
	    }
}
