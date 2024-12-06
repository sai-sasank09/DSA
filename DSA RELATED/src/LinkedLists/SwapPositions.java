package LinkedLists;

public class SwapPositions {
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

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head; // Return as is if the list is empty or has only one node
        }

        ListNode first = head;
        ListNode second = head;
        ListNode current = head;

        // Move `first` pointer to the k-th node from the start
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // Move `second` pointer to the k-th node from the end
        while (current.next != null) {
            current = current.next;
            if (k > 1) {
                k--;
            } else {
                second = second.next;
            }
        }

        // Swap the values of the two nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

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
        SwapPositions sp = new SwapPositions();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = sp.new ListNode(1);
        head.next = sp.new ListNode(2);
        head.next.next = sp.new ListNode(3);
        head.next.next.next = sp.new ListNode(4);
        head.next.next.next.next = sp.new ListNode(5);

        System.out.println("Original List:");
        sp.printList(head);

        // Swapping the k-th node from the start and end
        int k = 2;
        head = sp.swapNodes(head, k);

        System.out.println("List after swapping:");
        sp.printList(head);
    }
}
