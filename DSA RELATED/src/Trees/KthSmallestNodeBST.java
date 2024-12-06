package Trees;
import java.util.*;
public class KthSmallestNodeBST {
class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
}
ArrayList<Integer> lst= new ArrayList<>();
	public int kthSmallest(TreeNode root, int k) {
	    // traversal(root);
	    
	    //  Collections.sort(lst);
	    // System.out.println(lst);
	    // return lst.get(k-1);
	    return helper(root,k).val;
	}
	int count=0;
	public TreeNode helper(TreeNode node,int k){
	
	    if (node==null) return null;
	
	    TreeNode left= helper(node.left,k);
	    if (left !=null){
	        return left;
	    }
	    count++;
	
	    if (count==k) return node;
	
	    return helper(node.right,k);
	}
	public void traversal(TreeNode node){
		if (node==null) return ;
		traversal(node.left);
		traversal(node.right);
		lst.add(node.val);
		   
	}
}
