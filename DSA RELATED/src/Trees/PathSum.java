package Trees;

import Trees.SD.TreeNode;

public class PathSum {
	class TreeNode{
		TreeNode left,right;
		int val;
		TreeNode(int val) {
			this.val=val;
		}
	}
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root==null) return false;
		if (root.val==targetSum && root.left == null && root.right==null) {
			return true;
		}
		return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}
