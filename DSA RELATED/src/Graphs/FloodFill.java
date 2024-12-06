package Graphs;

public class FloodFill {
	
	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int iniColor=image[sr][sc];
		int[][] ans =image;
		int delRow[]= {-1,0,1,0};
		int delCol[]= {0,1,0,-1};
		dfs(sr,sc,ans,image,color,delRow,delCol,iniColor);
		return ans;
    }

	private void dfs(int sr, int sc, int[][] ans,
			int[][] image, int color, int[] delRow, int[] delCol,int iniColor) {
		ans[sr][sc]= color;
		int m= image.length;
		int n=image[0].length;
		for (int i=0;i<4;i++) {
			int nrow= delRow[i]+ sr;
			int ncol= delCol[i]+sc;
			if (nrow>=0 && ncol>=0 && nrow<m && ncol<n &&image[nrow][ncol]==iniColor&& ans[nrow][ncol]!=color) {
				dfs(nrow,ncol,ans,image,color,delRow,delCol,iniColor);
			}
		}
		
	}
	
}
