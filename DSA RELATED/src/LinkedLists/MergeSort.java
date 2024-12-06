package LinkedLists;

//import LinkedLists.MergeSortedLL.ListNode;

public class MergeSort {
	
//	 public ListNode sortList(ListNode head) {
//	       if (head ==  null && head.next == null) {
//	    	   return head;
//	       }
//	       
//	    }
//	
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode= new ListNode(0);
        ListNode current= newNode;
        while(list1 != null && list2 != null){
           if(list1.val < list2.val){
            current.next=list1;
            list1=list1.next;
           }
           else{
            current.next= list2;
            list2=list2.next;
           }
           current= current.next;
        }
        if (list1 != null){
            current.next= list1;
        }
        else{
            current.next=list2;
        }
        return newNode.next;
    }
	
	ListNode getMid(ListNode head) {
		ListNode midPrev= null;
		while(head != null && head.next != null) {
			midPrev= (midPrev== null) ? head : midPrev.next;
			head= head.next.next;
			
		}
		ListNode mid=midPrev.next;
		midPrev.next=null;
		return mid;
	}
	
	
	
	
	
	
	
	
	
	
	
	 class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
}
