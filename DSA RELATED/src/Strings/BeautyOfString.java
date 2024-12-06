package Strings;
import java.util.*;

public class BeautyOfString {

    public static void main(String[] args) {
        // Calculate and print the beauty sum of the string "aabcb"
        int result = beautySum("aabcb");
        System.out.println("Beauty sum: " + result);
    }

    public static int beautySum(String s) {
        int totalBeauty = 0;

        for (int i = 0; i < s.length(); i++) {
            // Initialize a frequency map for characters
            HashMap<Character, Integer> freq = new HashMap<>();

            for (int j = i + 1; j <= s.length(); j++) {
                char ch = s.charAt(j - 1);
                // Update the frequency map for the current character
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);

                // Priority queue for minimum frequency
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                // Priority queue for maximum frequency (invert the order for max heap)
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

                // Add all current frequencies to both heaps
                for (int value : freq.values()) {
                    minHeap.add(value);
                    maxHeap.add(value);
                }

                // Determine the maximum and minimum frequencies using heaps
                int maxFreq = maxHeap.peek();
                int minFreq = minHeap.peek();

                // Calculate the beauty for the current substring
                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;
    }
}
