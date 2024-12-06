package Trees;
import java.util.*;

import Trees.PopulatingNextRightPointer.Node;
public class DFSStack {

	void dfsStack(Node node) {
	    if(node == null) {
	      return;
	    }
	    Stack<Node> stack = new Stack<>();
	    stack.push(node);

	    while(!stack.isEmpty()) {
	      Node removed = stack.pop();
	      System.out.print(removed.val + " ");
	      if(removed.right != null) {
	        stack.push(removed.right);
	      }
	      if(removed.left != null) {
	        stack.push(removed.left);
	      }
	    }
	  }
}
