package oops;

import java.util.*;

class Customer {
    private String username;
    private String password;
    private List<String> cart;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addToCart(String item) {
        cart.add(item);
    }

    public List<String> getCart() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }
}

public class ZomatoAppWithCustomerClass {
    static Map<String, Customer> customerMap = new HashMap<>();
    static Map<String, String> deliveryPersons = new HashMap<>();
    static Map<String, Boolean> deliveryAvailability = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedData();
        System.out.println("Welcome to Zomato-like App!");
        while (true) {
            System.out.println("1. Customer Login\n2. Delivery Person Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> customerFlow();
                case 2 -> deliveryPersonFlow();
                case 3 -> {
                    System.out.println("Thank you for using the app. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Seed data for testing
    public static void seedData() {
        customerMap.put("alice", new Customer("alice", "password123"));
        customerMap.put("bob", new Customer("bob", "securepass"));

        deliveryPersons.put("john", "deliver123");
        deliveryPersons.put("jane", "quickpass");
        deliveryAvailability.put("john", true);
        deliveryAvailability.put("jane", true);
    }

    // Customer flow
    public static void customerFlow() {
        System.out.println("Enter username:");
        String username = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();

        Customer customer = customerMap.get(username);
        if (customer != null && customer.getPassword().equals(password)) {
            System.out.println("Customer login successful. Welcome, " + username + "!");
            customerActions(customer);
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    public static void customerActions(Customer customer) {
        while (true) {
            System.out.println("1. Order Food\n2. View Cart\n3. Checkout\n4. Logout");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            switch (choice) {
                case 1 -> {
                    System.out.println("Available food items: Pizza, Burger, Pasta, Salad");
                    System.out.println("Enter the item you want to order:");
                    String item = sc.nextLine();
                    customer.addToCart(item);
                    System.out.println(item + " added to cart.");
                }
                case 2 -> {
                    System.out.println("Your cart: " + customer.getCart());
                }
                case 3 -> {
                    System.out.println("Order placed successfully. Your items: " + customer.getCart());
                    assignDeliveryPerson();
                    customer.clearCart();
                }
                case 4 -> {
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void assignDeliveryPerson() {
        for (Map.Entry<String, Boolean> entry : deliveryAvailability.entrySet()) {
            if (entry.getValue()) {
                System.out.println("Order assigned to delivery person: " + entry.getKey());
                deliveryAvailability.put(entry.getKey(), false);
                return;
            }
        }
        System.out.println("No delivery person available at the moment. Please wait.");
    }

    // Delivery person flow
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
                    deliveryAvailability.put(username, true);
                    System.out.println("You are now available for deliveries.");
                }
                case 2 -> {
                    deliveryAvailability.put(username, false);
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

