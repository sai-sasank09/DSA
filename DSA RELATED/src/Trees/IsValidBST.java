package Trees;



public class IsValidBST {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){
			this.val=val;
		}
	}
	

	public boolean isValidBST(TreeNode root) {
	    return helper(root,null,null);
	}
	public boolean helper(TreeNode node, Integer min, Integer max) {
		if (node==null) return true;
		if (min!=null && node.val <= min) return false;
		if (max!=null && node.val >= max) return false;
		boolean leftTree=helper(node.left,min,node.val);
		boolean rightTree= helper(node.right,node.val,max);
		return leftTree && rightTree;
	}
	
}
