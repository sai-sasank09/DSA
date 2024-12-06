package Trees;
import java.util.*;
public class SpecialNodes {
//	Problem statement
//	In a binary tree, a special node is a node that is the only child of its parent.
//	The root of the tree is not special because it does not have a parent node.
//	Node ‘1’ is always the root of the binary tree.
//	Return an array/list containing the values of all special nodes in the tree.
	   class TreeNode<T> {
           public T data;
           public TreeNode<T> left;
           public TreeNode<T> right;

           TreeNode(T data) {
               this.data = data;
               left = null;
               right = null;
           }
       }
	 public static ArrayList<Integer> findSpecialNodes(TreeNode<Integer> root) {
		    // Write your code here.
		    ArrayList<Integer> lst= new ArrayList<>();
		    helper(root,lst);
		    return lst;
		  }
		  public static void helper(TreeNode<Integer> node,ArrayList<Integer> lst){
		    if (node==null) return;
		    if (node.left != null && node.right == null){
		      lst.add(node.left.data);
		    }
		    if (node.right != null && node.left==null) {
		      lst.add(node.right.data);
		    }
		    helper(node.left,lst);
		  
		    helper(node.right,lst);
		  }
}
