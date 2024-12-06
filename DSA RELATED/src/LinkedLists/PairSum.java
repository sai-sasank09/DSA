package LinkedLists;

//import LinkedLists.Partition.ListNode;
import java.util.*;

public class PairSum {
	 public class ListNode {
	        int val;
	        ListNode next;

	        ListNode() {}

	        ListNode(int val) {
	            this.val = val;
	        }

	        ListNode(int val, ListNode next) {
	            this.val = val;
	            this.next = next;
	        }
	    }
	 public int pairSum(ListNode head) {
	        Stack<ListNode> stk = new Stack<>();
	        ListNode f=head, s= head;
	        while (f!=null && f.next!=null){
	            stk.push(s);
//	            System.out.println("s"+s.val);
	            s=s.next;
	           // System.out.println("f"+f.val);
	            f=f.next.next;
	        }
	        System.out.println(s.val);
	        int maxy=0;
	        while (s!=null){
	        maxy= Math.max(maxy, s.val + stk.pop().val); 
	        s=s.next;
	        }
	        return maxy;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PairSum obj= new PairSum();
	 	ListNode head = obj.new ListNode(5);
        head.next = obj.new ListNode(3);
        head.next.next = obj.new ListNode(2);
        head.next.next.next = obj.new ListNode(7);
        head.next.next.next.next= obj.new ListNode(8);
        head.next.next.next.next.next= obj.new ListNode(9);
        System.out.println(obj.pairSum(head));
	}

}
