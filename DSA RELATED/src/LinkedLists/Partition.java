package LinkedLists;


public class Partition {
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
	 public ListNode partition(ListNode head, int x) {
	        ListNode less= new ListNode(0);
	        ListNode dumL= less;
	        ListNode high= new ListNode(0);
	        ListNode dumH= high;
	        ListNode curr= head;
	        while (curr!=null){
	            if (curr.val < x) {
	                dumL.next = curr;
	                dumL = dumL.next;
	            } else {
	                dumH.next = curr;
	                dumH = dumH.next;
	            }
	            curr=curr.next;
	        }
	        dumH.next=null;
	        dumL.next= high.next;
	        return less.next;
	    }
	 public void printList(ListNode head) {
	        while (head != null) {
	            System.out.print(head.val + " -> ");
	            head = head.next;
	        }
	        System.out.println("null");
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partition obj= new Partition();
		 	ListNode head = obj.new ListNode(1);
	        head.next = obj.new ListNode(4);
	        head.next.next = obj.new ListNode(3);
	        head.next.next.next = obj.new ListNode(2);
	        head.next.next.next.next= obj.new ListNode(5);
	        head.next.next.next.next.next= obj.new ListNode(2);
	        head= obj.partition(head,3);
	        obj.printList(head);
	}

}
