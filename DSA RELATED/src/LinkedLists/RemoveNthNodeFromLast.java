package LinkedLists;


class RemoveNthNodeFromLast {
    
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    // Function to remove the N-th node from the end
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        
        // Step 1: Calculate the size of the linked list
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        
        // Step 2: Set temp back to the head of the list
        temp = head;
        
        // Special case: if we need to remove the head node
        if (n == size) {
            return head.next; // Removing the head
        }
        
        // Step 3: Traverse the list to the (size - n - 1)th node
        for (int i = 0; i < size - n - 1; i++) {
            temp = temp.next;
        }
        
        // Step 4: Skip the nth node from the end
        temp.next = temp.next.next;
        
        return head;
    }
    
    // Helper method to create a linked list from an array of integers
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    // Helper method to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
    	RemoveNthNodeFromLast solution = new RemoveNthNodeFromLast();
        
        // Create a linked list from an array
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(values);
        
        // Print the original list
        System.out.print("Original list: ");
        printLinkedList(head);
        
        // Remove the 2nd node from the end (n = 2)
        head = solution.removeNthFromEnd(head, 2);
        
        // Print the modified list
        System.out.print("List after removal: ");
        printLinkedList(head);
    }
}
