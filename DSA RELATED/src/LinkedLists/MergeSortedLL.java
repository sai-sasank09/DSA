package LinkedLists;

public class MergeSortedLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists2Pointers(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(0);
        ListNode current = newNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        System.out.println(newNode.next.val);
        return newNode.next;
    }

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeSortedLL obj = new MergeSortedLL();

        // Creating list1: 1 -> 3 -> 5 -> null
        ListNode list1 = obj.new ListNode(1);
        list1.next = obj.new ListNode(3);
        list1.next.next = obj.new ListNode(5);

        // Creating list2: 2 -> 4 -> 6 -> null
        ListNode list2 = obj.new ListNode(2);
        list2.next = obj.new ListNode(4);
        list2.next.next = obj.new ListNode(6);

        System.out.println("List 1:");
        obj.printList(list1);

        System.out.println("List 2:");
        obj.printList(list2);

        // Merging lists using 2-pointer approach
        ListNode mergedList = obj.mergeTwoLists2Pointers(list1, list2);
        System.out.println("Merged List (2-pointer approach):");
        obj.printList(mergedList);

        // Recreating the lists since they were modified by the 2-pointer approach
        list1 = obj.new ListNode(1);
        list1.next = obj.new ListNode(3);
        list1.next.next = obj.new ListNode(5);

        list2 = obj.new ListNode(2);
        list2.next = obj.new ListNode(4);
        list2.next.next = obj.new ListNode(6);

        // Merging lists using recursive approach
        ListNode mergedListRecursive = obj.mergeTwoListsRecursive(list1, list2);
        System.out.println("Merged List (recursive approach):");
        obj.printList(mergedListRecursive);
    }
}
