package Queue;

import java.util.*;

class NumberContainers {
    Map<Integer, PriorityQueue<Integer>> numCon;
    Map<Integer, Integer> inmp;

    public NumberContainers() {
        numCon = new HashMap<>();
        inmp = new HashMap<>();
    }

    public void change(int index, int number) {
        if (inmp.containsKey(index)) {
            int prevNum = inmp.get(index);
            if (prevNum == number) return;
            numCon.get(prevNum).remove(index);
        }
        numCon.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        inmp.put(index, number);
    }

    public int find(int number) {
        PriorityQueue<Integer> pq = numCon.getOrDefault(number, new PriorityQueue<>());
        return pq.isEmpty() ? -1 : pq.peek();
    }

    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();
        
        obj.change(1, 10);
        obj.change(2, 10);
        obj.change(3, 20);
        obj.change(4, 10);
        
        System.out.println(obj.find(10)); // Expected: 1 (smallest index with number 10)
        System.out.println(obj.find(20)); // Expected: 3
        System.out.println(obj.find(30)); // Expected: -1 (30 doesn't exist)
        
        obj.change(1, 20); // Changing index 1 from 10 -> 20
        System.out.println(obj.find(10)); // Expected: 2 (smallest index with number 10 now)
        System.out.println(obj.find(20)); // Expected: 1 (smallest index with number 20)
    }
}
