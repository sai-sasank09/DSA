package Trees;

public class LongestZigZag {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    int count = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, true);   // Start from the root and move left.
        helper(root, 0, false);  // Start from the root and move right.
        return count; // Return the global maximum ZigZag path.
    }

    void helper(TreeNode node, int len, boolean isLeft) {
        if (node == null) return;

        count = Math.max(count, len); // Update the global maximum count.

        if (isLeft) {
            // If we are moving left, next direction must be to right child.
            helper(node.left, len + 1, false);  // Continue Zig-Zag to left.
            helper(node.right, 1, true);        // Reset and move right.
        } else {
            // If we are moving right, next direction must be to left child.
            helper(node.right, len + 1, true);  // Continue Zig-Zag to right.
            helper(node.left, 1, false);        // Reset and move left.
        }
    }

    public static void main(String[] args) {
        // Example Test case
        LongestZigZag solution = new LongestZigZag();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        int result = solution.longestZigZag(root);
        System.out.println("Longest ZigZag Path Length: " + result); // Expected output: 3
    }
}
