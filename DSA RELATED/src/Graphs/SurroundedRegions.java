package Graphs;

public class SurroundedRegions {

public class Solution{

    public static void replaceOWithX(char board[][]) {
    	int m= board.length;
        int n=board[0].length;
        boolean[][] visit= new boolean[m][n];
        for (int i=0;i<m;i++){
            if (board[i][0]=='O') dfs(i,0,visit,board);
            if (board[i][n-1]=='O') dfs(i,n-1,visit,board);
        }
        for (int j=0;j<n;j++){
            if(board[0][j]== 'O')  dfs(0,j,visit,board);
            if (board[m-1][j]=='O')  dfs(m-1,j,visit,board);
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j]=='O')  board[i][j]='X';
                if (board[i][j]=='*') board[i][j]='O';
            }
        }


    }
    public static void dfs(int row,int col,boolean[][] visit,char[][] board){
        visit[row][col]=true;
         board[row][col]='*';
        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};
       for (int i=0;i<4;i++){
        int nrow= delRow[i]+row;
        int ncol=delCol[i]+col;
        if (nrow>=0 &&  nrow< board.length && ncol>=0 &&
             ncol < board[0].length && visit[nrow][ncol]==false && board[nrow][ncol]=='O'){
            dfs(nrow,ncol,visit,board);
        }
       }
    }
}
}
