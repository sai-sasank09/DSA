package LinkedLists;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LL list= new LL();
//		list.insertFirst(5);
//		list.insertFirst(4);
//		list.insertFirst(3);
//		list.insertFirst(1);
//		list.insertLast(6);
		//		list.display();
		list.insertLast(1);
		list.insertLast(1);
		list.insertLast(3);
		list.insertLast(4);
		list.insertLast(4);
		list.insertRec(10, 2);
//		list.display();
//		list.removeDuplicates();
		list.display();
		list.removeMiddleNode();
//		
//
////		System.out.println("First element is "+list.deleteFirst());
//		list.display();
//		list.insert(10, 3);
////		System.out.println();
////		System.out.println("Deleting last element");
////		list.display();
////		System.out.println("last element is "+list.deleteLast());
////		list.deleteLast();
////		list.display();
////		System.out.println();
////		System.out.println("Delete at a specific index");
////		list.display();
////		System.out.println(list.delete(2));
////		list.display();
//		
////		list.reverseIterate();
//		list.display();
//		DLL list= new DLL();
//		list.InsertFirst(6);
//		list.InsertFirst(5);
//		list.InsertFirst(4);
//		list.InsertFirst(3);
//		list.InsertFirst(2);
//		list.InsertFirst(1);
//		list.InsertLast(7);
//		list.InsertLast(8);
//		list.Insert(100, 3);
//		
////		list.displayRev();
//		list.display();
//		CircularLL list= new CircularLL();
//		list.insert(10);
//		list.insert(20);
//		list.insert(30);
//		list.insert(40);
//		list.delete(40);
//		list.display();
//		LL first= new LL();
//    	LL second= new LL();
//    	first.insertLast(1);
//    	first.insertLast(3);
//    	first.insertLast(6);
//    	first.insertLast(9);
//    	
//    	second.insertLast(2);
//    	second.insertLast(10);
//    	second.insertLast(98);
//    	second.insertLast(333);
    	
//    	LL ans= LL.mergeSortedList(first, second);
//    	ans.display();
		
	}

}
