package Stack;

//import java.util.ArrayList;
//import java.util.List;
//
//class StockSpanner {
//    private List<Integer> prices;
//    
//    public StockSpanner() {
//        prices = new ArrayList<>(); // To store prices
//    }
//    
//    public int next(int price) {
//        prices.add(price); // Add the current price to the list
//        int span = 1; // Initial span is at least 1 (for the current day)
//        
//        // Iterate backwards through the prices to calculate the span
//        for (int i = prices.size() - 2; i >= 0; i--) {
//            if (prices.get(i) <= price) {
//                span++; // Increase the span if the previous price is less than or equal to current
//            } else {
//                break; // Stop if the previous price is greater than current price
//            }
//        }
//        
//        return span; // Return the calculated span
//    }
//
//    public static void main(String[] args) {
//        StockSpanner stockSpanner = new StockSpanner();
//        
//        System.out.println(stockSpanner.next(100)); // Output: 1
//        System.out.println(stockSpanner.next(80));  // Output: 1
//        System.out.println(stockSpanner.next(60));  // Output: 1
//        System.out.println(stockSpanner.next(70));  // Output: 2
//        System.out.println(stockSpanner.next(60));  // Output: 1
//        System.out.println(stockSpanner.next(75));  // Output: 4
//        System.out.println(stockSpanner.next(85));  // Output: 6
//    }
//}
import java.util.Stack;

class Pair {
    int price;
    int day;

    Pair(int price, int day) {
        this.price = price;
        this.day = day;
    }
}

class StockSpanner {
    private Stack<Pair> stack; // Stack to hold Pair objects
    private int day; // Current day count

    public StockSpanner() {
        stack = new Stack<>();
        day = -1; // Initialize day count to -1
    }
    
    public int next(int price) {
        day++; // Increment day count
        // While the stack is not empty and the top price is less than or equal to the current price
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop(); // Remove elements that are less than or equal to the current price
        }
        
        // If the stack is empty, it means the current price is the highest
        // So the span is the current day + 1 (since day is zero-based)
        int span = (stack.isEmpty()) ? day + 1 : day - stack.peek().day;

        // Push the current price and the current day to the stack
        stack.push(new Pair(price, day));
        
        return span; // Return the calculated span
    }
    
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        
        // Example stock prices
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        
        // Call next method for each price and print the span
        for (int price : prices) {
            int span = stockSpanner.next(price);
            System.out.println("Price: " + price + ", Span: " + span);
        }
    }
}

