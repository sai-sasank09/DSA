package Graphs;
import java.util.*;
class Pair{
	int row;
	int col;
	int time;
		Pair(int row,int col,int time){
		this.row=row;
		this.col=col;
		this.time=time;
		}
	
	}
public class RottenOrangesBFS {
	public int rottenOranges(int[][] matrix) {
		int m=matrix.length;
		int n=matrix[0].length;
		Queue<Pair> queue= new LinkedList<>();
		int[][] visited= new int[m][n];
		int cntFresh=0;
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				if(matrix[i][j]==2) {
					queue.add(new Pair(i,j,0));
					visited[i][j]=2;
				}
				else {
					visited[i][j]=0;
				}
				if(matrix[i][j] == 1)  cntFresh++;
			}
		}
		
		int drow[]= {-1,0,1,0};
		int dcol[]= {0,1,0,-1};
		int tm=0;
		int cnt=0;
		while (!queue.isEmpty()) {
			int r=queue.peek().row;
			int c=queue.peek().col;
			int t=queue.peek().col;
			queue.poll();
			for (int i=0;i<4;i++) {
				int nrow= r+ drow[i];
				int ncol=c+ dcol[i];
				if (nrow>=0 && nrow<m && ncol>=0 && ncol <n &&
						visited[nrow][ncol]==0 && matrix[nrow][ncol]==1) {
					queue.add(new Pair(nrow,ncol,t+1));
					visited[nrow][ncol]=2;
					cnt++;
				}
			}
		}
		if (cnt != cntFresh) {
			return -1;
		}
		return tm;
	}
	
}
