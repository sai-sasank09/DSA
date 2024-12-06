package GreedyApproach;
import java.util.*;

public class KnapsackProblem {
    static class Pair {
        int weight;
        int value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static double maximumValue(Pair[] items, int n, int w) {
        // Sort items based on value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(
            (double) b.value / b.weight, (double) a.value / a.weight));

        double maxValue = 0.0; // To store the maximum value
        int remainingWeight = w; // Remaining capacity of the knapsack

        for (Pair item : items) {
            if (remainingWeight == 0) break;

            if (item.weight <= remainingWeight) {
                // Take the full item
                maxValue += item.value;
                remainingWeight -= item.weight;
            } else {
                // Take a fractional part of the item
                maxValue += (double) item.value * remainingWeight / item.weight;
                remainingWeight = 0; // Knapsack is now full
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        // Example items
        Pair[] items = {
            new Pair(10, 60), // weight = 10, value = 60
            new Pair(20, 100), // weight = 20, value = 100
            new Pair(30, 120)  // weight = 30, value = 120
        };

        int n = items.length; // Number of items
        int w = 50; // Knapsack capacity

        // Calculate the maximum value that can be achieved
        double result = maximumValue(items, n, w);

        // Print the result
        System.out.println("Maximum value in the knapsack: " + result);
    }
}
