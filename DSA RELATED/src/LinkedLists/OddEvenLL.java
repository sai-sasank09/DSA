package LinkedLists;

public class OddEvenLL {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenC = even;

        // Rearrange nodes into odd and even positions
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // Attach the even list at the end of the odd list
        odd.next = evenC;

        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OddEvenLL ll = new OddEvenLL();

        // Create a test linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = ll.new ListNode(1);
        head.next = ll.new ListNode(2);
        head.next.next = ll.new ListNode(3);
        head.next.next.next = ll.new ListNode(4);
        head.next.next.next.next = ll.new ListNode(5);

        System.out.println("Original List:");
        ll.printList(head);

        // Rearrange the list into odd-even
        head = ll.oddEvenList(head);

        System.out.println("List after rearranging:");
        ll.printList(head);
    }
}
