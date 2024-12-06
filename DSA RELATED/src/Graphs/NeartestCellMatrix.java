package Graphs;
import java.util.*;
public class NeartestCellMatrix {
	class Pair{
		int first,second,third;
		Pair(int first, int second, int third){
			this.first=first;
			this.second=second;
			this.third=third;
		}
	}
	
	 public int[][] updateMatrix(int[][] mat) {
		 int m=mat.length;
		 int n=mat[0].length;
		 boolean[][] visit= new boolean[m][n];
		 int[][] dist= new int[m][n];
		 Queue<Pair> q= new LinkedList<>();
		 for (int i=0;i<m;i++) {
			 for(int j=0;j<n;j++) {
				 if (mat[i][j]==1) {
					 q.add(new Pair(i,j,0));
					 visit[i][j]=true;	 
				 }
			 }
		 }
		 int[] delRow= {-1,0,1,0};
		 int[] delCol= {0,1,0,-1};
		 
		 while (!q.isEmpty()) {
			 int row= q.peek().first;
			 int col=q.peek().second;
			 int step= q.peek().third;
			 q.poll();
			 dist[row][col]=step;
			 for (int i=0;i<4;i++) {
				 int nrow= row + delRow[i];
				 int ncol=col+ delCol[i];
				 if (nrow >=0  && ncol >=0 && nrow<n && ncol<m 
						 && visit[nrow][ncol] == false) {
					 visit[nrow][ncol]=true;
					 q.add(new Pair(nrow,ncol,step+1));
					 
				 }
			 }
		 }
		 return dist;
	 }
}
