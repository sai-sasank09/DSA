package Trees;
import java.util.*;
public class SD {
	class TreeNode{
		TreeNode left,right;
		int val;
		TreeNode(int val) {
			this.val=val;
		}
	}
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> lst = new ArrayList<>();
        helperSerialize(root, lst);
        return String.join(",", lst); // Join the list into a single string with commas
    }

    // Helper function for serializing the tree
    private void helperSerialize(TreeNode node, List<String> lst) {
        if (node == null) {
            lst.add("null");
            return;
        }
        lst.add(String.valueOf(node.val)); // Add current node's value
        helperSerialize(node.left, lst);   // Recur for left subtree
        helperSerialize(node.right, lst);  // Recur for right subtree
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Convert the string back to a list
        List<String> lst = new LinkedList<>(Arrays.asList(data.split(",")));
        return helperDeserialize(lst);
    }

    // Helper function for deserializing the tree
    private TreeNode helperDeserialize(List<String> lst) {
        String val = lst.remove(0); // Take the first element (root)
        if (val.equals("null")) {
            return null; // If "null", return null node
        }
        TreeNode node = new TreeNode(Integer.parseInt(val)); // Create the node
        node.left = helperDeserialize(lst); // Recur for left subtree
        node.right = helperDeserialize(lst); // Recur for right subtree
        return node;
    }
}



   

