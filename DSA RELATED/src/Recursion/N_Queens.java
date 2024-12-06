package Recursion;
import java.util.*;
public class N_Queens {

	public static void main(String[] args) {
		
		String[][] matrix= {{" "," "," "," "},
				{" "," "," "," "},
				{" "," "," "," "},
				{" "," "," "," "}};
		int row= matrix.length;
//		int col= matrix[0].length;
		int[] lowerDiagonal= new int[10];
		int[] horizontal= new int[10];
		int[] upperDiagonal= new int[10];
		 NQueens(matrix,row,0,lowerDiagonal,horizontal,upperDiagonal);
	}
	public static void printMatrix(String[][] matrix,int row,int col) {
		System.out.println("This is the result");
		for(int i=0;i<row;i++) {
		
			for (int j=0;j<col;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	public static void NQueens(String[][] matrix,int row,int col,int[] lowerDiagonal,int[] horizontal,int[] upperDiagonal) {
		
//		for (int j=0;j<col;j++) {
			
			if (col>=row) {
				printMatrix(matrix,row,row);
				
				return;
			}
			else {
				for (int i=0;i<row;i++) {
//					boolean valid= IsValid(matrix, i, col);
					if (upperDiagonal[row-1+col-i]==0 && lowerDiagonal[i+col]==0 && horizontal[i]==0) {
						matrix[i][col]="Q";
						lowerDiagonal[i+col]=1;
						horizontal[i]=1;
						upperDiagonal[matrix.length-1+col-i]=1;
						NQueens(matrix,row,col+1,lowerDiagonal,horizontal,upperDiagonal);
						matrix[i][col]=" ";
						lowerDiagonal[i+col]=0;
						horizontal[i]=0;
						upperDiagonal[row-1+col-i]=0;
					}
				}
			}		
		}
	
//	private static boolean IsValid(String[][] matrix, int row, int col) {
//		int i=row;
//		int j=col;
////		
////		while (i>=0 && j>=0) {
////			if (matrix[i][j]=="Q") {
////				
////				return false;
////			}
////			j--;
////		}
////		 i=row;
////		j=col;
////		while (i>=0 && j>=0) {
////			if (matrix[i][j]=="Q") {
////				return false;
////			}
////			i--;
////			j--;
////		}
//		i=row;
//		j=col;
//		while (i<matrix.length && j>=0) {
//			if(matrix[i][j]=="Q") {
//				return false;
//			}
//			i++;
//			j--;
//		}
//		
//		
//		return true;
//	}

}
