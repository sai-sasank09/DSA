package Recustion_Strivers;
import java.util.*;
public class RatInMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
	        mat.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0)));
	        mat.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1)));
	        mat.add(new ArrayList<>(Arrays.asList(1, 1, 0, 0)));
	        mat.add(new ArrayList<>(Arrays.asList(0, 1, 1, 1)));

	        ArrayList<String> result = findPath(mat);
	        
	        // Print the result
	        if (result.isEmpty()) {
	            System.out.println("No path found!");
	        } else {
	            System.out.println("Paths found:");
	            for (String path : result) {
	                System.out.println(path);
	            }
	        }
	    }
		
	
	public static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        int n=mat.size();
        int[][] vis= new int[n][n];
        ArrayList<String> ans = new ArrayList<>();
        if (mat.get(0).get(0)==1){
            vis[0][0]=1;
            func(0,0,mat,vis,ans,n,"");
        }
        return ans;
    }
    public static void func(int i, int j, ArrayList<ArrayList<Integer>> mat, int[][] vis, ArrayList<String> ans,int n, String s){
        
         if (i == n - 1 && j == n - 1) {
            ans.add(s);
            return;
        }
        //down
        if( i+1 < n && vis[i+1][j] == 0 && mat.get(i+1).get(j)==1){
            vis[i+1][j]=1;
            func(i+1,j,mat,vis,ans,n,s+'D');
            vis[i+1][j]=0;
        }
        // left
        if(j-1 >= 0 && vis[i][j-1]==0 &&  mat.get(i).get(j-1)==1){
            vis[i][j-1]=1;
            func(i,j-1,mat,vis,ans,n,s+'L');
            vis[i][j-1]=0;
        }
        // right
        if(j+1 < n && vis[i][j+1] ==0 &&  mat.get(i).get(j+1)==1){
            vis[i][j+1]=1;
            func(i,j+1,mat,vis,ans,n,s+'R');
            vis[i][j+1]=0;
        }
        //up
        if(i-1 >=0 && vis[i-1][j]==0 &&  mat.get(i-1).get(j)==1){
            vis[i-1][j]=1;
            func(i-1,j,mat,vis,ans,n,s+'U');
            vis[i-1][j]=0;
        }
    }

}
