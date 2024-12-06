package Trees;
import java.util.*;
public class LevelOrderTraversal_2 {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
	}
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
          return result;  
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);  
      while (!queue.isEmpty()) {
          int levelSize = queue.size();  
          List<Integer> level = new ArrayList<>();
          for (int i = 0; i < levelSize; i++) {
              TreeNode currNode = queue.poll();  
              level.add(currNode.val);  
              if (currNode.left != null) {
                  queue.offer(currNode.left);
              }
              if (currNode.right != null) {
                  queue.offer(currNode.right);
              }
          }
          result.add(level);  
      }
      Collections.reverse(result);

      return result; 
  }
}
