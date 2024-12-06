package LinkedLists;

public class MiddleNode {
	
	 public class ListNode {
		      int val;
		     ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	
	public ListNode middleNode(ListNode head) {
        ListNode temp= head;
        int size= getSize(head);
        System.out.println(size);
        for (int i=0;i<size/2;i++){
            temp= temp.next;
        }
       

            return temp;
    }
    public int getSize(ListNode head){
        ListNode temp= head;
        int count=0;
        while (temp.next != null){
            count++;
            temp= temp.next;
        }
        
        return count+1;
    }
}
