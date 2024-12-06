package Trees;
import java.util.*;
public class SymmetricTree {
	class TreeNode{
		TreeNode left,right;
		int val;
		
	}
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> queue= new LinkedList<>();
		queue.add(root.left);
		queue.add(root.right);
		while (!queue.isEmpty()) {
			TreeNode leftt= queue.poll();
			TreeNode rightt=queue.poll();
			if (leftt==null && rightt ==null) {
				continue;
			}
			if (leftt==null || rightt==null) {
				return false;
			}
			if (leftt.val!=rightt.val) {
				return false;
			}
			queue.add(leftt.left);
			queue.add(rightt.right);
			queue.add(leftt.right);
			queue.add(rightt.left);
		}
		return true;
    }
	
}
