package oops;
import java.util.*;
public class ZomatoApp {
	static Map<String,String> customers= new HashMap<>();
	static Map<String,String> deliveryPersons= new HashMap<>();
	static Map<String, Boolean> deliveryAvailabilty= new HashMap<>();
	static Scanner sc= new Scanner(System.in);
	
	public static void seedData() {
		customers.put("sasank", "sasi123");
		customers.put("ramana", "ramana123");
		deliveryPersons.put("Rajesh", "raj123");
		deliveryPersons.put("Kumar","kum");
		deliveryAvailabilty.put("Rajesh", true);
		deliveryAvailabilty.put("Kumar", true);
	}

	public static void main(String[] args) {
		seedData();
		System.out.println("Welcome to zomato app ");
		while (true) {
			System.out.println("1. Customer Login\n2. Delivery Person Login\n3. Exit");
			int choice =sc.nextInt();
			switch(choice) {
			case 1: customerFlow();
			break;
			case 2: deliveryPersonFlow();
			break;
			case 3: {
				System.out.println("Thanks for using this app");
				return;
			}
			default :System.out.println("Invalid option. Please Try again");
			}
		}
	}

	private static void customerFlow() {
		System.out.println("Enter username : ");
		String username= sc.next();
		System.out.println("Enter Password : ");
		String password=sc.next();
		
		if(customers.containsKey(username) && customers.get(username).equals(password)) {
			System.out.println("Customer logged in Successfully. Welcome, "+ username +"!");
			customerActions(username);
		}
		else {
			 System.out.println("Invalid credentials. Try again.");
		}	
	}

	public static void customerActions(String username) {
		List<String> cart= new ArrayList<>();
		while (true) {
			 System.out.println("1. Order Food\n2. View Cart\n3. Checkout\n4. Logout");
			 int choice = sc.nextInt();
			 sc.nextLine();
			 switch(choice) {
			 case 1: {
				 System.out.println("Avaiable food items : Pizza, Burger, Pasta, French Fries");
				 System.out.println("Enter the item that you want to order: ");
				 String item= sc.next();
				 cart.add(item);
			 }
			 case 2:
				 System.out.println("view cart :"+ cart);
			 case 3:{
				 System.out.println("Order placed successfully. Your items: " + cart);
			 	assignDeliveryBoy();
			 	cart.clear();
			 	}
			 case 4:
				 System.out.println("Logged Out Successfully");
				 return;
				 
			 default: System.out.println("Invalid options. Try again");
			 }	 
		}		
	}


	private static void assignDeliveryBoy() {
		for(Map.Entry<String,Boolean> entry : deliveryAvailabilty.entrySet()) {
			if(entry.getValue()) {
				System.out.println("Order assigned to the delivery person: "+ entry.getKey());
				deliveryAvailabilty.put(entry.getKey(), false);
				return;
			}
			else {
				System.out.println("No delivery Patners are availble at a moment. Please Wait");;
			}
		}
		
	}
	public static void deliveryPersonFlow() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        if (deliveryPersons.containsKey(username) && deliveryPersons.get(username).equals(password)) {
            System.out.println("Delivery person login successful. Welcome, " + username + "!");
            deliveryPersonActions(username);
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    public static void deliveryPersonActions(String username) {
        while (true) {
            System.out.println("1. Mark as Available\n2. Mark as Unavailable\n3. Logout");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> {
                	deliveryAvailabilty.put(username, true);
                    System.out.println("You are now available for deliveries.");
                }
                case 2 -> {
                	deliveryAvailabilty.put(username, false);
                    System.out.println("You are now unavailable for deliveries.");
                }
                case 3 -> {
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

}
