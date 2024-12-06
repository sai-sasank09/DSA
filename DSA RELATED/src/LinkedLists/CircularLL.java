package LinkedLists;

public class CircularLL {
	
	
	private Node head;
	private Node tail;
	
	CircularLL(){
		this.head= null;
		this.tail= null;
		
	}
	public void insert(int val) {
		Node node= new Node(val);
		if(head==null) {
			head=node;
			tail=node;
			return;
		}
		node.next= head;
		tail.next= node;
		tail=node;
	}
	public void delete(int val) {
		Node node= head;
		if (node ==  null) {
			return;
		}
		if(node.val == val) {
			head=head.next;
			tail.next=tail;
			return;
		}
		
		
		do {
			Node n= node.next;
			if(n.val== val) {
				node.next= n.next;
				break;
				
			}
			node = node.next;
		}while(node != head);
		
		
	}
	public void display() {
		Node temp= head;
		if(head != null) {
			do {
				System.out.print(temp.val + " -> ");
				temp=temp.next;
				
			}while (temp != head);
			
			System.out.println("HEAD");
			
		}
	}
	
	public class Node{
		int val;
		Node next;
		
		Node(int val, Node next){
			this.val= val;
			this.next= next;
			
		}
		Node(int val){
			this.val= val;
		}
	}
	
}
