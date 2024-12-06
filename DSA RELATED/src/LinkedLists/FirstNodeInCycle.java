package LinkedLists;

public class FirstNodeInCycle {
    static class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node firstNode(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
        	System.out.println("s"+ slow.data);
            slow = slow.next;
            System.out.println("f"+ fast.data);
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle detected, find the start of the cycle
            	System.out.println("both are qual"+ slow.data);
                slow = head;
                while (slow != fast) {
                	System.out.println("slow->"+slow.data);
                    slow = slow.next;
                    System.out.println("fast->"+ fast.data);
                    fast = fast.next;
                   
                }
                return slow; // First node in the cycle
            }
        }
        return null; // No cycle
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third; // Creating a cycle at node with value 3

        Node cycleStart = firstNode(head);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
