package Trees;

public class BinarySearchTree {

	public class Node {
		private int value;
		private int height;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value=value;
		}
		private int getValue() {
			return value;
		}
	}
	private Node root;
	public BinarySearchTree() {
		
	}
	public int getHeight(Node node) {
		if(node==null) {
			return -1;
		}
		return node.height;
	}
	public boolean isEmpty() {
		return root==null;
	}
	public void display(Node node) {
		if (node==null){
			return;
		}
		display(node,"Root Node");
		
	}
	public void display(Node node, String details) {
		if (node==null) return ;
		System.out.println(details+ node.getValue());
		
		display(node.left,"Left child of "+ node.getValue() + ":");
		display(node.right,"Right child of "+ node.getValue() + ":");
		
		
		
	}
	
	
	
	
}
