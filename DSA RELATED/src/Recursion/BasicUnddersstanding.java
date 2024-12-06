package Recursion;

public class BasicUnddersstanding {
	static void message()
	{
		System.out.println("Hello world");
		message1();
	}
	private static void message1() {
		System.out.println("Hello world");
		message2();
	}
	private static void message2() {
		System.out.println("Hello world");
		message3();
	}
	private static void message3() {
		System.out.println("Hello world");
		message4();
	}
	private static void message4() {
		System.out.println("Hello world");
		message5();
	}
	private static void message5() {
		System.out.println("Hello world");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		message();
		

	}

}
