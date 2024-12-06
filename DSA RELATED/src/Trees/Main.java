package Trees;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
//		Scanner sc= new Scanner(System.in);
//		BinaryTree tree= new BinaryTree();
//		tree.populate(sc);
//		tree.display();
//		BST tree= new BST();
//		int[] nums= {5,2,7,1,4,6,9,8,3,10};
//		tree.populate(nums);
////		tree.display();
////		tree.inOrder();
//		AVLtree  tree= new AVLtree();
//		for (int i=0;i<100;i++) {
//			tree.insert(i);
//		}
//		System.out.println(tree.height());
		
		int[] arr= {2,3,4,1,9,0,-2};
		SegmentTree tree= new SegmentTree(arr);
//		tree.display();
		
		System.out.println(tree.query(1, 6));
		
	}
}
