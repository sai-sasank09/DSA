package Trees;
import java.util.*;
public class ZigZag_Traversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val=val;
		}
		
		
	}
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result= new ArrayList<>();   
	if (root==null) {
        	return result;
        }
	Deque<TreeNode> dq= new LinkedList<>();
	dq.offer(root);
	boolean reverse=false;
	while (!dq.isEmpty()) {
		int levelSize= dq.size();
		List<Integer> lst= new ArrayList<>();
		for (int i=0;i<levelSize;i++) {
			if (!reverse) {
				TreeNode currNode=dq.pollFirst();
				lst.add(currNode.val);
				if (currNode.left != null) {
					dq.offerLast(currNode.left);
				}
				if (currNode.right !=null) {
					dq.offerLast(currNode.right);
				}
			}
			else {
				TreeNode currNode=dq.pollLast();
				lst.add(currNode.val);
				if (currNode.right !=null) {
					dq.offerFirst(currNode.right);
				}
				if (currNode.left != null) {
					dq.offerFirst(currNode.left);
				}	
			}		
		}
		reverse = !reverse;
		result.add(lst);
	}
	return result;
	
    }
}
