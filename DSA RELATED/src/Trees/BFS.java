package Trees;
//findrightSuccessor  also
import java.util.*;

public class BFS {
    // TreeNode class representing the structure of a binary tree node
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Method to perform level order traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
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

        return result;  
    }
    
    
    public static TreeNode findSuccessor(TreeNode root, int key) {
    	if (root==null) {
    		return null;
    	}
    	 Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);  // Start with the root node

         while (!queue.isEmpty()) {
             int levelSize = queue.size(); 
                 TreeNode currNode = queue.poll();
                 // Remove from queue
                 if (currNode.left != null) {
                     queue.offer(currNode.left);
                 }
                 if (currNode.right != null) {
                     queue.offer(currNode.right);
                 }
                 if (currNode.val == key) {
                	 break;
                 }
         }
        

         return queue.peek();
    	
    }
    
    
    
    

    // Main method to test the BFS level order traversal
    public static void main(String[] args) {
        BFS bfs = new BFS();

        // Creating a sample tree:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6
        TreeNode root = bfs.new TreeNode(1);
        root.left = bfs.new TreeNode(2);
        root.right = bfs.new TreeNode(3);
        root.left.left = bfs.new TreeNode(4);
        root.left.right = bfs.new TreeNode(5);
        root.right.right = bfs.new TreeNode(6);

        // Perform level order traversal
        List<List<Integer>> result = bfs.levelOrder(root);

        // Print the result
//        System.out.println("Level order traversal:");
//        for (List<Integer> level : result) {
//            System.out.println(level);
//        }
        
        System.out.println(findSuccessor(root,4).val);
    }
}
