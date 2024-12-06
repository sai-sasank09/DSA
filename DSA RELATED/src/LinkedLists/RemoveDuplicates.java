package LinkedLists;

import LinkedLists.InsertGCD.ListNode;

public class RemoveDuplicates {
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
	 public ListNode deleteDuplicates(ListNode head) {
	        ListNode curr= head;
	        ListNode newNode=new ListNode(0,head);
	        ListNode prev=newNode;
	        while (head !=null && head.next != null){
	            if (head.val == head.next.val){
	                while (head.next !=null && head.val == head.next.val){
	                    head= head.next;
	                }
	                prev.next= head.next;
	            }
	            else{
	                prev= prev.next;
	                System.out.println(prev.val);
	            }
	            head=head.next;

	        }
	        return newNode.next;
	        
	        
	    }
	 public void printList(ListNode head) {
	        while (head != null) {
	            System.out.print(head.val + " -> ");
	            head = head.next;
	        }
	        System.out.println("null");
	    }
	 public static void main(String args[]) {
		 RemoveDuplicates obj= new RemoveDuplicates();
		 	ListNode head = obj.new ListNode(1);
	        head.next = obj.new ListNode(1);
	        head.next.next = obj.new ListNode(2);
	        head.next.next.next = obj.new ListNode(3);
	        head= obj.deleteDuplicates(head);
	        obj.printList(head);
	 }
}
