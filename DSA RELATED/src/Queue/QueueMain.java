package Queue;

public class QueueMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CircularQueue queue= new CircularQueue(5);
		queue.insert(10);
		queue.insert(12);
		queue.insert(13);
		queue.insert(14);
		queue.insert(4);
//		queue.remove();
		
		queue.display();
		
		
	}

}
