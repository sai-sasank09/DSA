package Trees;

public class BST {
	public class Node{
		private int value;
		Node left;
		Node right;
		private int height;
		
		Node(int value){
			this.value=value;
//			this.height=0;
		}
		public int getValue() {
			return value;
		}
	}
	private Node root;
	public BST() {
		
	}
	public int height(Node node) {
		if (node==null) return -1;
		return node.height;
	}
	public boolean isEmpty() {
		return (root == null);
	}
	public void insert(int value) {
		root= insert(value,root);
	}
	public Node insert(int value,Node node) {
		if (node==null) {
			node= new Node(value);
			return node;
		}
		if (value < node.value) {
			node.left= insert (value,node.left);
		}
		if (value > node.value) {
			node.right= insert(value,node.right);
		}
		node.height = Math.max(height(node.left), height(node.right))+1;
		
		return node;
	}
//	  public void insert(int[] nums) {
//	        root = sortedArrayToBST(nums, 0, nums.length - 1);
//	    }
	  private Node sortedArrayToBST(int[] nums, int start, int end) {
	        if (start > end) {
	            return null;
	        }
	        int mid = (start + end) / 2;
	        Node node = new Node(nums[mid]);
	        node.left = sortedArrayToBST(nums, start, mid - 1);
	        node.right = sortedArrayToBST(nums, mid + 1, end);
	        node.height = Math.max(height(node.left), height(node.right)) + 1;

	        return node;
	    }
	public void populate(int[] nums) {
		for (int i=0;i<nums.length;i++) {
			this.insert(nums[i]);
		}
	}
	
	
	
	public boolean balanced() {
		return balanced(root);
	}
	public boolean balanced(Node node) {
		if (node==null) {
			return true;
		}
		return (Math.abs(height(node.left)- height(node.right)) <=1) 
				&& balanced(node.left) && balanced(node.right);
		
	}
	public void display() {
		display(this.root,"Root details are ");
	}
	public void display(Node node, String details) {
		if (node==null) {
			return ;
		}
		System.out.println(details + node.value);;;
		display(node.left,"Left child of "+ node.value + ":");
		display(node.right,"Right child of "+node.value+ ":");
	}
	public void preOrder() {
		preOrder(root);
	}
	public void preOrder(Node node) {
		if (node==null) return;
		System.out.println(node.value+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	
	public void inOrder() {
		inOrder(root);
	}
	public void inOrder(Node node) {
		if (node==null) return;
		inOrder(node.left);
		System.out.println(node.value+" ");
		inOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(Node node) {
		if (node==null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value+" ");
	}
	
	
	
	
	
}
