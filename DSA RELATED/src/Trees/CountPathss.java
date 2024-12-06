package Trees;
import java.util.*;

public class CountPathss {

    // Tree node structure
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    // Function to count paths
    int countPaths(Node node, int sum) {
        List<Integer> path = new LinkedList<>();
        return helper(node, sum, path);
    }

    // Helper function to count paths
    int helper(Node node, int sum, List<Integer> path) {
        if (node == null) return 0;

        path.add(node.val);
        int count = 0;
        int s = 0;

        // Check current path sums
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {
            s += itr.previous();
            if (s == sum) {
                count++;
            }
        }

        // Recursively check in the left and right subtree
        count += helper(node.left, sum, path) + helper(node.right, sum, path);

        // Backtrack
        path.remove(path.size() - 1);

        return count;
    }

    // Main method with raw data
    public static void main(String[] args) {
        CountPathss cp = new CountPathss();

        // Creating a binary tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);

        // Given sum to find
        int sum = 8;

        // Count paths with sum
        int result = cp.countPaths(root, sum);
        System.out.println("Number of paths with sum " + sum + " is: " + result);
    }
}
