package Arrays;
import java.util.Arrays;
class SetMatrix {
static void markRow(int row,int[][] matrix){
    for (int j=0;j < matrix[0].length;j++){
        
        if (matrix[row][j] != 0){
            matrix[row][j]= -1;
        }
    }
}
static void markColumn(int col,int[][] matrix){
    for (int i=0;i<matrix.length;i++){
        if (matrix[i][col] != 0){
            matrix[i][col]= -1;
        }
    }
}

  static void setZeroes(int[][] matrix) {
        
        for (int i=0;i< matrix.length;i++){
            for (int j=0;j< matrix[0].length;j++){
                if (matrix[i][j]== 0){
                    markRow(i,matrix);
                    markColumn(j,matrix);
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]== -1){
                    matrix[i][j]=0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[][] matrix = {
    		    {1, 1, 1},
    		    {1, 0, 1},
    		    {1, 1, 1}
    		};
    	
    	setZeroes(matrix);
        // Print the updated matrix
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
    
    
    
    






	


