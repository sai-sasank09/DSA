package LinkedLists;

public class LL {
    Node head;
    private Node tail;
    private int size;
    
    public LL() {
        this.size = 0;
    }
    
    private static class Node {
        private int value;
        private Node next;
        
        public Node(int value) {
            this.value = value;
            this.next=null;
        }
        
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    
    public void insertLast(int val) { 
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        size++; 
    }
    
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }
    
    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        if (node == null) return node;
        node.next = insertRec(val, index - 1, node.next);
        return node;
    }
    
    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }
    
    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();    
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }
    
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }
    
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");        
    }
    
    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }
        Node prev = head;
        Node current = head.next;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head.next = null;
        head = prev;
    }
    public Node reverseList(Node head) {
    	if(head== null) {
    		return head;
    	}
    	Node prev=null;
    	Node present= head;
    	Node next= present.next;
    	while (present != null) {
    		present.next= prev;
    		prev= present;
    		present=next;
    		if(next != null) {
    			next=next.next;
    		}
    	}
    	return prev;	
    }
    
    public void removeDuplicates() {
        Node temp = head;
        
        while (temp != null && temp.next != null) {
            if (temp.value == temp.next.value) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }
    
    public static LL mergeSortedList(LL firstList, LL secondList) {
        LL result = new LL();
        Node f = firstList.head;
        Node s = secondList.head;
        
        while (f != null && s != null) {
            if (f.value < s.value) {
                result.insertLast(f.value);
                f = f.next;
            } else {
                result.insertLast(s.value);
                s = s.next;
            }
        }
        while (f != null) {
            result.insertLast(f.value);
            f = f.next;
        }
        while (s != null) {
            result.insertLast(s.value);
            s = s.next;
        }
        return result;
    }
    
    public int getSize() {
    	Node temp= head;
    	int count=0;
    	while (temp != null) {
    		count++;
    		temp=temp.next;
    	}
    	return count;
    }
    public void removeMiddleNode() {
    	int size= getSize();
    	Node temp= head;
    	for(int i=0;i<(size/2)-1;i++) {
    		temp=temp.next;
    	}
    	temp.next= temp.next.next;
    	
    	System.out.println(temp.value);
    }
    
}
