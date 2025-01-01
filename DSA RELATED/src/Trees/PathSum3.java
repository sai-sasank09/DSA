package Trees;

public class PathSum3 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    int cnt = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // Start DFS from every node in the tree, not just the root node
        dfs(root, targetSum);
        return cnt;
    }

    void dfs(TreeNode node, int target) {
        if (node == null) {
            return;
        }

        // Start exploring paths from the current node
        helper(node, target);
        
        // Recur for the left and right subtrees
        dfs(node.left, target);
        dfs(node.right, target);
    }

    void helper(TreeNode node, int target) {
        if (node == null) {
            return;
        }

        // If the current node's value matches the target, increment count
        if (node.val == target) {
            cnt++;
        }

        // Recursively check paths in left and right subtrees with the updated target
        helper(node.left, target - node.val);
        helper(node.right, target - node.val);
    }

    public static void main(String[] args) {
        PathSum3 solution = new PathSum3();

        // Constructing the binary tree as per the given array
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);

        int targetSum = 0;
        System.out.println(solution.pathSum(root, targetSum));  // Expected count of paths
    }
}
