package LinkedLists;

import LinkedLists.Middleoflist.ListNode;

public class InsertGCD {
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
	 public ListNode insertGreatestCommonDivisors(ListNode head) {
	        if (head==null) return null;
	        if (head.next == null) return head;
	        ListNode curr= head;
	        while (curr!=null && curr.next!=null){
	            int g= gcd(curr.val,curr.next.val);
	            ListNode gcdd= new ListNode(g);
	            gcdd.next=curr.next;
	            curr.next=gcdd;
	            curr=gcdd.next;
	        }
	        return head;
	    }
	    public int gcd(int a , int b){
	        while (b!=0){
	            int temp=b;
	            b=a%b;
	            a=temp;
	        }
	        return a;
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
			InsertGCD obj= new InsertGCD();
		 	ListNode head = obj.new ListNode(18);
	        head.next = obj.new ListNode(6);
	        head.next.next = obj.new ListNode(10);
	        head.next.next.next = obj.new ListNode(3);
	        head= obj.insertGreatestCommonDivisors(head);
	        obj.printList(head);
	}

}
