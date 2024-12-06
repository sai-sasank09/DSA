package LinkedLists;
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class InsertLastGFG {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        // Create a new node with the given data
        Node newNode = new Node(x);
        
        // If the list is empty, return the new node as the head
        if (head == null) {
            return newNode;
        }
        
        // Otherwise, traverse to the end of the list
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        // Insert the new node at the end of the list
        current.next = newNode;
        
        // Return the head of the list
        return head;
    }
    void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing the insertAtEnd function
    public static void main(String[] args) {
        InsertLastGFG solution = new InsertLastGFG();

        // Creating an empty linked list
        Node head = null;

        // Inserting elements into the linked list
        head = solution.insertAtEnd(head, 10);
        head = solution.insertAtEnd(head, 20);
        head = solution.insertAtEnd(head, 30);
        head = solution.insertAtEnd(head, 40);

        // Printing the linked list
        System.out.println("Linked list after insertion:");
        solution.printList(head); // Output: 10 20 30 40
    }
}

