package Trees;

public class MaxPathSum_IMP {
	class TreeNode{
		TreeNode left,right;
		int val;
	}
	
	int ans=Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
	
	int helper(TreeNode node) {
		if (node==null) return 0;
		int left= helper(node.left);
		int right=helper(node.right);
		left=Math.max(0, left);
		right=Math.max(0, right);
		int pathSum= left+right+node.val; 
		ans=Math.max(ans, pathSum);
		
		return Math.max(left,right) + node.val;
		
	}
}
