package Trees;

import Trees.InvertTree_swap.TreeNode;

public class SortedArrayToBST {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){
			this.val=val;
		}
	}
	
	 public TreeNode sortedArrayToBST(int[] nums) {
	        return sortedToBST(nums,0,nums.length-1);
	    }
	     private TreeNode sortedToBST(int[] nums, int start, int end) {
		        if (start > end) {
		            return null;
		        }
		        int mid = (start + end) / 2;
		        TreeNode node = new TreeNode(nums[mid]);
		        node.left = sortedToBST(nums, start, mid - 1);
		        node.right = sortedToBST(nums, mid + 1, end);
		        // node.height = Math.max(height(node.left), height(node.right)) + 1;

		        return node;
		    }
}
