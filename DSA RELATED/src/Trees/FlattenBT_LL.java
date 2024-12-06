package Trees;
import java.util.*;
import Trees.SortedArrayToBST.TreeNode;

public class FlattenBT_LL {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){
			this.val=val;
		}
	}
	static Queue<TreeNode> qq= new LinkedList<>();
	    public void flatten(TreeNode root) {
	       flattenLL(root);
	       if (qq.isEmpty()) return;
	     
	       TreeNode curr= qq.poll();
	       while (!qq.isEmpty()){
	        curr.left=null;
	        curr.right=qq.poll();
	        curr=curr.right;
	       }
	   
	    }
	 public void flattenLL(TreeNode root){
	         if (root==null) return ;
	        qq.offer(root);
	        flattenLL(root.left);
	        flattenLL(root.right);
	 }
	 
	 public void flattenList(TreeNode root) {
		 if (root==null) {
			 return;
		 }
		 TreeNode current= root;
		 while (current !=null) {
			 if (current.left !=null) {
				 TreeNode temp=current.left;
				 while (temp.right !=null) {
					 temp=temp.right;
				 }
				 temp.right=current.right;
				 current.right=current.left;
				 current.left=null;
			 }
			 current=current.right;
		 }
		 
	 }
	 
	 
	 
    public static void main(String args[]) {
    	FlattenBT_LL ft= new FlattenBT_LL();
    	TreeNode root= ft.new TreeNode(1);
    	root.left=ft.new TreeNode(2);
    	root.right=ft.new TreeNode(5);
    	root.left.left=ft.new TreeNode(3);
    	root.left.right=ft.new TreeNode(4);
    	root.right.right= ft.new TreeNode(6);
    	ft.flatten(root);
    	for (TreeNode el: qq) {
    		System.out.println(el.val);
    	}
    }
}
