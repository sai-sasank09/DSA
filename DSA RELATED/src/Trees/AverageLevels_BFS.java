package Trees;
import java.util.*;

import Trees.BFS.TreeNode;

public class AverageLevels_BFS {
	  class TreeNode {
	        int val;
	        TreeNode left;
	        TreeNode right;

	        TreeNode(int val) {
	            this.val = val;
	        }
	    }
	 public List<Double> averageOfLevels(TreeNode root) {
	        List<Double> result= new ArrayList<>();
	        if (root==null){
	            return result;
	        }
	        Queue<TreeNode> queue= new LinkedList<>();
	        queue.offer(root);
	        while (!queue.isEmpty()){
	            int levelSize= queue.size();
	            double averageLevel= 0;
	            for(int i=0;i<levelSize;i++){
	                TreeNode currNode= queue.poll();
	                averageLevel += currNode.val;
	                if (currNode.left != null){
	                    queue.offer(currNode.left);
	                }
	                if (currNode.right != null){
	                    queue.offer(currNode.right);
	                }

	            }
	            averageLevel = averageLevel/ levelSize;
	            result.add(averageLevel);
	        }
	        return result;
	    }
}
