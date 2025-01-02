package Trees;
import java.util.*;
public class MaxLevelSum {
	 static class TreeNode {
	        int val;
	        TreeNode left;
	        TreeNode right;
	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
      
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> maximum= new ArrayList<>();
        maximum.add(root.val);
        q.add(root);
        while(!q.isEmpty()){
            int sizee=q.size();
            int val=0;
            for (int i=0;i<sizee;i++){
                TreeNode curr= q.poll();
                if(curr.left!=null){
                    val+= curr.left.val;
                    q.add(curr.left);
                }
                if(curr.right !=null){
                    val += curr.right.val;
                    q.add(curr.right);
                }
            }
              maximum.add(val);
        }
        System.out.println(maximum);
        int maxi=Integer.MIN_VALUE;
        maximum.remove(maximum.size()-1);
        //Collection.max(maximum);
        for (int i: maximum){
            maxi=Math.max(maxi,i);
        }
        
        return maximum.indexOf(maxi)+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  MaxLevelSum solution = new MaxLevelSum();

	        // Construct the example binary tree
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.right.right = new TreeNode(6);

	        // Test the function
	        int result = solution.maxLevelSum(root);
	        System.out.println("Level with Maximum Sum: " + result); 
	}

}
