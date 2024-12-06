package LinkedLists;

public class HadCycle {

    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public int lengthOfCycle(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int length = 1;
                ListNode temp = slow;
                temp = temp.next;
                while (temp != slow) {
                    temp = temp.next;
                    length++;
                }
                return length;
            }
        }
        return 0;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        int length = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                length = lengthOfCycle(slow);
                System.out.println("Length="+ length);
                break;
            }
        }

        if (length == 0) {
            return null; // No cycle
        }

        ListNode f = head;
        ListNode s = slow;
        while(length > 0) {
            s = s.next;
            length--;
        }
        while (f != s) {
            f = f.next;
            s = s.next;
        }

        return s; // The start of the cycle
    }

    
    public boolean isHappy(int n) {
    	int slow=n;
    	int fast=n;
    	do {
    		slow= findSquare(slow);
    		fast= findSquare(findSquare(fast));
    	}
    	while(slow != fast);
    	
    	if (slow==1) {
    		return true;
    	}
    	return false;
    }
    
    private int findSquare(int num) {
    	int ans=0;
    	while(num>0) {
    		int rem= num % 10;
    		ans += rem * rem;
    		num/= 10;
    	}
    	return ans;
    }
    
    
    
    
    
    
    // Method to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        ListNode cycleStart = detectCycle(head);
        boolean isCycle = false;

        while (current != null) {
            System.out.print(current.val);
            current = current.next;
            if (current != null) {
                System.out.print(" -> ");
            }
            if (current == cycleStart && !isCycle) {
                isCycle = true;
                System.out.print("(cycle starts here)");
                break;
            }
        }
        if (current == null) {
            System.out.println(" -> null");
        } else {
            System.out.println(" -> ...");
        }
    }

    // Main method
    public static void main(String[] args) {
        HadCycle solution = new HadCycle();
        
        // Create nodes
        ListNode head = solution.new ListNode(3);
        ListNode node2 = solution.new ListNode(2);
        ListNode node3 = solution.new ListNode(0);
        ListNode node4 = solution.new ListNode(-4);

        // Create a cycle in the linked list: 3 -> 2 -> 0 -> -4 -> 2 (cycle starts at node 2)
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creating a cycle

        // Print the linked list
        System.out.print("Linked List: ");
        solution.printList(head);

        // Test hasCycle method
        boolean hasCycle = solution.hasCycle(head);
        System.out.println("Has cycle: " + hasCycle);

        // Test detectCycle method
        ListNode cycleStart = solution.detectCycle(head);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }

        // Test lengthOfCycle method
        int cycleLength = solution.lengthOfCycle(head);
        System.out.println("Length of cycle: " + cycleLength);
    }
}
