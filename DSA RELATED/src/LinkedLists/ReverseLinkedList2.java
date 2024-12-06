package LinkedLists;

public class ReverseLinkedList2 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	public ListNode reverseBetween(ListNode head, int left, int right) {
        
		if (left== right) {
			return head;
		}
		
		ListNode current=head;
		ListNode prev= null;
		
		for (int i=0; current!= null && i< left-1;i++) {
			prev=current;
			current=current.next;
			
		}
		ListNode last= prev;
		ListNode newEnd= current;
		
		ListNode next= current.next;
		
		for (int i=0;current!=null &&i<right-left+1;i++) {
			current.next=prev;
			prev=current;
			current=next;
			if(next!=null) {
				next=next.next;
			}
			
		}
		if(last!=null) {
			last.next=prev;
		}
		else {
			head=prev;
		}
		
		newEnd.next=current;
		return head;
        
    }
	
	
	 public ListNode reverseKGroup(ListNode head, int k) {
	     if (k<=1 || head == null) {
	    	 return head;
	     }

			ListNode current=head;
			ListNode prev= null;
		 while (true) {
				ListNode last= prev;
				ListNode newEnd= current;
				
				ListNode next= current.next;
				
				for (int i=0;current!=null &&i<k;i++) {
					current.next=prev;
					prev=current;
					current=next;
					if(next!=null) {
						next=next.next;
					}
					
				}
				if(last!=null) {
					last.next=prev;
				}
				else {
					head=prev;
				}
				
				newEnd.next=current;
			if (current == null) {
				break;
			}
			prev= newEnd;
		 }
		 return head;
		 
	}
	
	
	
	
	
	public ListNode deleteMiddle(ListNode head) {

        if(head==null || head.next== null){
            return null;
        }
        ListNode slow=head;
        ListNode fast= head;
        ListNode prev=null;

        while (fast != null && fast.next != null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null){
            prev.next= slow.next;
        }
        return head;

    }
	
	
	
	
}
