package LinkedLists;

public class RotateList {
    public static class ListNode {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        if (k % len == 0) {
            return head;
        }
        k = k % len;
        ListNode newTail = findNthNode(head, len - k);
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }

    public ListNode findNthNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int cnt = 1;
        while (head.next != null) {
            if (cnt == k) return head;
            cnt++;
            head = head.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();

        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Rotate the list to the right by 2 positions
        int k = 2;
        head = rotateList.rotateRight(head, k);

        System.out.println("Rotated List:");
        printList(head);
    }
}
