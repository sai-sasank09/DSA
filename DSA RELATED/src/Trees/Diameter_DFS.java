package Trees;
import java.util.*;
public class Diameter_DFS {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	int diameter=0;
	public int diameterOfBinaryTree(TreeNode root) {
		height(root);
		return diameter;
	}
	int height(TreeNode node) {
		if (node==null) return 0;
		int leftH= height(node.left);
		int rightH= height(node.right);
		int dia= leftH+ rightH;
		diameter= Math.max(diameter, dia);
		return Math.max(leftH, rightH)+1;
	}
}
