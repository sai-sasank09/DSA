package Trees;

public class InvertTree_swap {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
	}
	 public TreeNode invertTree(TreeNode root) {
	        if (root==null) return null;
	       
	        invertTree(root.left);
	        invertTree(root.right);
	         TreeNode temp=root.left;
	        root.left=root.right;
	        root.right=temp;
	        return root;
	 }
	 public TreeNode invert(TreeNode root) {
		 if (root==null) {
			 return null;
		 }
		 TreeNode left= invert(root.left);
		 TreeNode right= invert(root.right);
		 root.left=right;
		 root.right=left;
		 
		 return root;
	 }
}
