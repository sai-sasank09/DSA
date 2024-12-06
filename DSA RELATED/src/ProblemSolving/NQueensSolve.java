package ProblemSolving;

public class NQueensSolve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] matrix= {{" "," "," "," "},
				{" "," "," "," "},
				{" "," "," "," "},
				{" "," "," "," "}};
		
		NQueens(matrix,0);
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
	public static void NQueens(String[][] matrix,int col) {
		
		if (col>=4) {
			printMatrix(matrix,4,4);
			return ;
		}
		
		else {
			for (int row=0;row<matrix.length;row++) {
				boolean IsValid= isValids(matrix,row,col);
				if (IsValid) {
					matrix[row][col]="Q";
					NQueens(matrix,col+1);
					matrix[row][col]=" ";
					
				}
			}
		}
		
		
	}
	public static boolean isValids(String[][] matrix, int row, int col) {
		int i=row;
		int j=col;
		
		while(i>=0 && j>=0) {
			if(matrix[i][j]=="Q") {
				return false;
			}
			j--;
		}
		
		i=row;
		j=col;
		while (i<matrix.length && j>=0) {
			if (matrix[i][j]=="Q") {
				return false;
			}
			j--;
			i++;
		}
		i=row;
		j=col;
		while(i>=0 && j>=0) {
			if(matrix[i][j]=="Q") {
				return false;
			}
			i--;
			j--;
		}
		
		
		return true;
	}

}
