package Maps;
import java.util.*;
public class EqualPairs {
	 public static int equalPairs(int[][] grid) {
	        
	        HashMap<String, Integer> rowMap = new HashMap<>();
	        
	        // Store row patterns in the map
	        for (int[] g : grid) {
	            StringBuilder rowStr = new StringBuilder();
	            for (int val : g) {
	                rowStr.append(val).append(",");
	            }
	            // Remove the trailing comma
	            rowStr.setLength(rowStr.length() - 1);
	            rowMap.put(rowStr.toString(), rowMap.getOrDefault(rowStr.toString(), 0) + 1);
	        }
	        
	        int count = 0;
	        
	        // Compare column patterns with the row patterns in the map
	        for (int j = 0; j < grid[0].length; j++) {
	            StringBuilder colStr = new StringBuilder();
	            for (int i = 0; i < grid.length; i++) {
	                colStr.append(grid[i][j]).append(",");
	            }
	            // Remove the trailing comma
	            colStr.setLength(colStr.length() - 1);
	            count += rowMap.getOrDefault(colStr.toString(), 0);
	        }
	        
	        return count;
	    }
	public static void main(String[] args) {
		
		int[][] grid= {{3,1,2,2},
						{1,4,4,5},
						{2,4,2,2},
						{2,4,2,2}};
		
		System.out.println(equalPairs(grid));
		
	}
				

	

}
