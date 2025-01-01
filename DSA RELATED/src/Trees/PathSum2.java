package Trees;
import java.util.*;
public class PathSum2 {
	 static class TreeNode {
	        int val;
	        TreeNode left;
	        TreeNode right;
	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        List<List<Integer>> ans = new ArrayList<>();
	        List<Integer> lst= new ArrayList<>();
	         helper(root,targetSum,lst,ans);
	         return ans;
	    }
	    void helper(TreeNode node,int target,List<Integer> lst, List<List<Integer>> ans){
	        if (node==null) return ;
	        lst.add(node.val);
	        if (node.left==null && node.right==null && node.val==target){
	           
	            ans.add(new ArrayList<>(lst));
	        }
	        
	        helper(node.left,target-node.val,lst,ans);
	        helper(node.right,target-node.val,lst,ans);
	        lst.remove(lst.size()-1);
	    }
	
		// TODO Auto-generated method 
		public static void main(String[] args) {
		    PathSum2 solution = new PathSum2();
		    TreeNode root = new TreeNode(5);
		    root.left = new TreeNode(4);
		    root.right = new TreeNode(8);
		    root.left.left = new TreeNode(11);
		    root.left.left.left = new TreeNode(7);
		    root.left.left.right = new TreeNode(2);
		    root.right.left = new TreeNode(13);
		    root.right.right = new TreeNode(4);
		    root.right.right.right = new TreeNode(1);

		    int targetSum = 22;
		    List<List<Integer>> result = solution.pathSum(root, targetSum);
		    
		    // Print the result
		    for (List<Integer> path : result) {
		        System.out.println(path);
		    }
		}


	

}
