package Trees;

import java.util.Scanner;

public class BinaryTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int val) {
            this.value = val;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.print("Enter the root Node value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to enter the left of " + node.value + " (true/false)? ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the left value of " + node.value + ": ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to enter the right of " + node.value + " (true/false)? ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the right value of " + node.value + ": ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    // New display method for printing the tree structure
    public void display() {
        display(root, 0);
    }

    // Recursive method to print the tree
    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        // Display the right subtree first (so it appears at the top)
        display(node.right, level + 1);

        // Print the current node with indentation based on its level
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|------>" + node.value);
        } else {
            System.out.println(node.value);  // Root node
        }

        // Display the left subtree
        display(node.left, level + 1);
    }

}
