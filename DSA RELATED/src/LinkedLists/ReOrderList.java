package LinkedLists;

public class ReOrderList {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 }
	 
	 public void reorderList(ListNode head) {
		 
		 if (head == null || head.next == null ) {
			 return;
		 }
		 ListNode mid= middleNode(head);
		 
		 ListNode secondHead= reverseList(mid);
		 
		 ListNode firstHead= head;
		 
		 while (firstHead != null && secondHead != null) {
			 ListNode temp = firstHead.next;
			 firstHead.next= secondHead;
			 firstHead= temp;
			 
			 temp= secondHead.next;
			 secondHead.next = firstHead;
			 secondHead = temp;
			 
		 }
		 if (firstHead != null) {
			 firstHead.next = null;
		 }  
	 }
	 public ListNode middleNode(ListNode head){
		    ListNode f= head;
		    ListNode s= head;
		    while(f!=null && f.next != null){
		        s=s.next;
		        f=f.next.next;

		    }
		    return s;
		  }
	 
	 
	 public ListNode reverseList(ListNode head) {
	    	if(head== null) {
	    		return head;
	    	}
	    	ListNode prev=null;
	    	ListNode present= head;
	    	ListNode next= present.next;
	    	while (present != null) {
	    		present.next= prev;
	    		prev= present;
	    		present=next;
	    		if(next != null) {
	    			next=next.next;
	    		}
	    	}
	    	return prev;	
	    }
	 
}
