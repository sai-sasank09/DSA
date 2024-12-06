package Recursion;
import java.util.*;


class NQueensList {
	
public static void main(String args[]) {
		
		System.out.println(solveNQueens(4));
	}
	
	
	
    public static List<List<String>> solveNQueens(int n) {
        char[][] matrix= new char[n][n];

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]= '.';
            }
        }
        List<List<String>> res= new ArrayList<List<String>>();

        NQueens(0,matrix,res);
        return res;
    }
    static void NQueens(int col, char[][] matrix,List<List<String>> res){

        if (col >= matrix.length){
            res.add(create(matrix));
//            System.out.println("this is res + "+ res);
            return;
        }
        for (int row=0;row<matrix.length;row++){
            boolean isValid= isValidate(matrix,row,col);
            if (isValid){
                matrix[row][col]='Q';
                NQueens(col+1,matrix,res);
                matrix[row][col]='.';
            }
        }
    }
    static List<String> create (char[][] matrix){
        List<String> res= new LinkedList<String>();
        for (int i=0;i<matrix.length;i++){
            String s= new String(matrix[i]);
            res.add(s);
        }
//        System.out.println(res);
        return res;
    }
    static boolean isValidate(char[][] matrix, int row, int col){

            int i=row, j=col;
         
		
		while (i>=0 && j>=0) {
			if (matrix[i][j]=='Q') {
				
				return false;
			}
			j--;
		}
		 i=row;
		j=col;
		while (i>=0 && j>=0) {
			if (matrix[i][j]=='Q') {
				return false;
			}
			i--;
			j--;
		}
		i=row;
		j=col;
		while (i<matrix.length && j>=0) {
			if(matrix[i][j]=='Q') {
				return false;
			}
			i++;
			j--;
		}
		
		
		return true;
	}
 }


