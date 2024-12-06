package Trees;
import java.util.*;

public class Distancebtw2Nodes {

    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Nodes to find distance between
        int node1 = 4;
        int node2 = 7;

        // Find distance between the nodes
        int distance = findDistanceBetweenNodes(root, node1, node2);
        
        // Print the result
        System.out.println("Distance between nodes " + node1 + " and " + node2 + " is: " + distance);
    }

    public static int findDistanceBetweenNodes(TreeNode root, int node1, int node2) {
        // Find the Lowest Common Ancestor (LCA)
        TreeNode lca = findLCA(root, node1, node2);
        
        // If LCA is found, calculate distance from LCA to both nodes
        int distance1 = findDistanceFromLCA(lca, node1, 0);
        int distance2 = findDistanceFromLCA(lca, node2, 0);
        
        return distance1 + distance2;
    }
    
    // Helper function to find LCA of two nodes
    private static TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null) return null;
        
        // If either node1 or node2 is found, return the root
        if (root.val == node1 || root.val == node2) {
            return root;
        }
        
        // Recurse on left and right subtree
        TreeNode leftLCA = findLCA(root.left, node1, node2);
        TreeNode rightLCA = findLCA(root.right, node1, node2);
        
        // If both left and right LCA are non-null, root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        
        // Otherwise return the non-null side
        return leftLCA != null ? leftLCA : rightLCA;
    }
    
    // Helper function to find distance from LCA to the node
    private static int findDistanceFromLCA(TreeNode root, int node, int distance) {
        if (root == null) return -1; // Node not found
        
        // If the current node is the one we're looking for, return the distance
        if (root.val == node) {
            return distance;
        }
        
        // Search in left or right subtree
        int left = findDistanceFromLCA(root.left, node, distance + 1);
        int right = findDistanceFromLCA(root.right, node, distance + 1);
        
        // If either side returns a valid distance, return it
        if (left != -1) return left;
        if (right != -1) return right;
        
        return -1; // Node not found in this path
    }
}

// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
