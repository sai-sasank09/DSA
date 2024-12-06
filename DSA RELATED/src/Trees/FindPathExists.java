package Trees;

import Trees.PopulatingNextRightPointer.Node;

public class FindPathExists { 

	boolean findPath(Node node,int[] arr) {
		if (node==null) return arr.length==0;
		return helper(node,arr,0);
	}
	boolean helper(Node node, int[] arr, int i) {
		if (node==null) return false;
		if(i>=arr.length || node.val != arr[i]) return false;
		if (node.left ==null && node.right == null && i==arr.length-1) {
			return true;
		}
		return helper(node.left,arr,i+1) || helper(node.right,arr,i+1);
	}
}
