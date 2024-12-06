package Trees;

public class DeleteNodeInBST {
	class TreeNode{
		TreeNode left,right;
		int val;
	}
	public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root,key);
    }
    static TreeNode helper(TreeNode node, int key){
        if (node==null){
            return null;
        }
      if (key < node.val){
        node.left= helper(node.left,key);
      }
      else if (key > node.val) {
        node.right=helper(node.right,key);
      }
      else {
        if (node.left==null) {
            return node.right;
        }
        else if (node.right==null) {
            return node.left;
        }
        else {
            TreeNode temp= findMinNode(node.right);
            node.val=temp.val;
            node.right= helper(node.right,temp.val);
        }
      }
      return node;
    }
      static TreeNode findMinNode(TreeNode root){
        while (root.left !=null){
            root=root.left;

        }
        return root;
      }
}
