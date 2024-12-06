package Recursion;

public class WordSearch {
	 public static boolean exist(char[][] board, String word) {
	        StringBuilder str= new StringBuilder();
	        int m=board.length;
	        int n=board[0].length;

	        for (int i=0;i<m;i++){
	            for (int j=0;j<n;j++){
	                if (board[i][j]== word.charAt(0) && func(board,word,i,j,str)){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    public static boolean func(char[][] board, String word, int  i,int j, StringBuilder str){

	        if (word.length()== str.length()){
	            return true;
	        }

	        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(str.length())) {
	        return false;
	    }

	        str.append(board[i][j]);
	        char visited= board[i][j];
	        board[i][j] = '1';

	        boolean found= func(board,word,i+1,j,str) || 
	                        func(board,word,i,j+1,str) ||
	                         func(board,word,i-1,j,str) || 
	                        func(board,word,i,j-1,str);

	        str.deleteCharAt(str.length()-1);
	        board[i][j]=visited;


	        return found;


	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board= {{'A','B','C','E'},
						{'S','F','C','S'},
						{'A','D','E','E'}};
		String word= "ABCCED";
		System.out.println(exist(board,word));
	}

}

   
    

