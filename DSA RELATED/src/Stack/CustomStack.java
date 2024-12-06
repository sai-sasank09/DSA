package Stack;

public class CustomStack {
	protected int[] data;
	private static final int DEFAULT_SIZE=10;
	int ptr=-1;
	public CustomStack() {
		this(DEFAULT_SIZE);
	}
	public CustomStack(int size) {
		this.data= new int[size];
	}
	public boolean push (int item) {
		if(isFull()) {
			System.out.println("Stack if Full");
			return false;
		}
		ptr++;
		data[ptr]=item;
		return true;
		
	}
	protected boolean isFull() {
		
		return ptr==data.length-1;
	}
	public int pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("Cannot pop from an empty Stack");
		}
//		int removed= data[ptr];
//		ptr--;
//		return removed;
		return data[ptr--];
	}
	protected boolean isEmpty() {
	
		return ptr==-1;
	}
	public int peek() throws StackException {
		if (isEmpty()) {
			throw new StackException("Cannot peek from an empty Stack");
		}
		return data[ptr];
	}
	
}
