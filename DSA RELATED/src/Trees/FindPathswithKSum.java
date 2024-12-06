package Trees;

import java.util.ArrayList;

public class FindPathswithKSum {
    // Definition for the binary tree node
    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        BinaryTreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<ArrayList<Integer>> kPathSum(BinaryTreeNode<Integer> root, int k) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, k, path, paths);
        return paths;
    }

    static void helper(BinaryTreeNode<Integer> node, int targetSum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (node == null) return;

        path.add(node.data);  // Add the current node to the path
        int currentSum = 0; // Initialize the sum

        // Check for all possible paths ending at the current node
        for (int i = path.size() - 1; i >= 0; i--) {
            currentSum += path.get(i);
            if (currentSum == targetSum) {
                paths.add(new ArrayList<>(path.subList(i, path.size()))); // Add the path to the result
            }
        }

        // Recur for left and right subtrees
        helper(node.left, targetSum, path, paths);
        helper(node.right, targetSum, path, paths);

        path.remove(path.size() - 1); // Backtrack to explore other paths
    }

    public static void main(String[] args) {
        FindPathswithKSum finder = new FindPathswithKSum();

        // Creating a binary tree
        BinaryTreeNode<Integer> root = finder.new BinaryTreeNode<>(10);
        root.left = finder.new BinaryTreeNode<>(5);
        root.right = finder.new BinaryTreeNode<>(-3);
        root.left.left = finder.new BinaryTreeNode<>(3);
        root.left.right = finder.new BinaryTreeNode<>(2);
        root.right.right = finder.new BinaryTreeNode<>(11);
        root.left.left.left = finder.new BinaryTreeNode<>(3);
        root.left.left.right = finder.new BinaryTreeNode<>(-2);
        root.left.right.right = finder.new BinaryTreeNode<>(1);

        // Given sum to find
        int sum = 8;

        // Find paths with the given sum
        ArrayList<ArrayList<Integer>> result = kPathSum(root, sum);

        // Print the paths
        System.out.println("Paths with sum " + sum + " are:");
        for (ArrayList<Integer> path : result) {
            System.out.println(path);
        }
    }
}
