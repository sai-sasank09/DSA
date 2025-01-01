package Trees;
import java.util.*;

public class GoodNodes {
    
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    int cnt = 0;

    // Main method to count good nodes
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val);
        return cnt;
    }

    // Helper method to recursively count good nodes
    void helper(TreeNode root, int maxVal) {
        if (root == null) return;

        // A good node is one whose value is >= max value seen on the path to it
        if (root.val >= maxVal) {
            cnt++;
        }
        
        // Recursively check the left and right child
        int newMaxVal = Math.max(root.val, maxVal);
        helper(root.left, newMaxVal);
        helper(root.right, newMaxVal);
    }

    // Example to test the functionality
    public static void main(String[] args) {
        GoodNodes solution = new GoodNodes();

        // Test case 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println("Good nodes count: " + solution.goodNodes(root));  // Output: 4

        // Test case 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(4);
        System.out.println("Good nodes count: " + solution.goodNodes(root2));  // Output: 3
    }
}
