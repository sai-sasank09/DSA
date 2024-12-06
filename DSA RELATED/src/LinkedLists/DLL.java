package LinkedLists;

//import LinkedLists.LL.Node;

public class DLL {
	Node head;
	
	
	
	public void InsertFirst(int val) {
		Node node= new Node(val);
		node.next=head;
		node.prev=null;
		if(head!= null) {
			head.prev= node;
		}
		
		head=node;
		
	}
	
	
	public void InsertLast(int val) {
		Node node= new Node(val);
		
		Node temp= head;
		node.next=null;
		while (temp.next != null) {
			temp=temp.next;
		}
		node.prev= temp;
		temp.next= node;
		
	}
	public Node find(int value) {
		Node node=head;
		while (head != null) {
			if (node.data== value) {
				return node;
			}
			node= node.next;
		}
		return null;
	}
	public void Insert1(int after, int val) {
		Node p= find(after);
		if (p==null) {
			System.out.println("Does not exist");
		}
		Node node= new Node(val);
		node.next=p.next;
		
		p.next=node;
		node.prev=p;
		if(node.next != null) {
			p.next.prev= node;
		}
		
		
		
	}
	public void Insert(int val, int index) {
		if (index==0) {
			InsertFirst(val);
		}
		Node node= new Node(val);
		Node temp= head;
		for (int i=1;i<index;i++) {
			temp=temp.next;
		}
		node.next= temp.next;
		temp.next.prev=node;
		temp.next=node;
		node.prev=temp;
			
	}
	
	
	public void display() {
		Node temp= head;
		while (temp != null) {
			System.out.print(temp.data+ " -> ");
			temp=temp.next;
		}
		System.out.println("End");
	}
	
	public void displayRev() {
		Node temp= head;
		Node last= null;;
		while (temp != null) {
//			System.out.print(temp.data+ " -> ");
			last= temp;
			temp=temp.next;	
		}
		while(last!= null) {
			System.out.print(last.data+ " <- ");
			last= last.prev;
		}
		
		System.out.println("End");
	}
	
	
	
	private class Node{
		private Node next;
		private Node prev;
		 int data;	
		
		
		Node(int data, Node next, Node prev){
			this.data= data;
			this.prev=prev;
			this.next= next;
		}
		Node(int data){
			this.data= data;
		}

	}
}