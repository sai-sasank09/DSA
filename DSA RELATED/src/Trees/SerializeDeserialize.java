package Trees;
import java.util.*;
public class SerializeDeserialize {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val){ this.val=val;}
	}
	List<String> serialize= new ArrayList<>();
	  public List<String> serialize(TreeNode root) {
		  List<String> lst= new ArrayList<>();
		  helper(root,lst);
		  return lst;
	    }
	
	void helper(TreeNode node,List<String> lst) {
		if(node==null) {
			lst.add("null");
			return;
		}
		lst.add(String.valueOf(node.val));
		helper(node.left,lst);
		helper(node.right,lst);
	}
	TreeNode deserialize(List<String> lst) {
		Collections.reverse(lst);
		
		TreeNode node= helper2(lst);
		return node;
	}
	TreeNode helper2(List<String> lst) {
		String val=lst.remove(lst.size()-1);
		if(val.charAt(0)=='n') return null;
		TreeNode node= new TreeNode(Integer.parseInt(val));
		return node;
	}
}
