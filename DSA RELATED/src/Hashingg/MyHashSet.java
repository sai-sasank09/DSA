package Hashingg;

import java.util.HashSet;

class MyHashSet {
    private HashSet<Integer> set;

    public MyHashSet() {
        set = new HashSet<>();
    }
    
    public void add(int key) {
        set.add(key);
    }
    
    public void remove(int key) {
        set.remove(key);
    }
    
    public boolean contains(int key) {
        return set.contains(key);
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println("Contains 1: " + obj.contains(1)); // true
        System.out.println("Contains 3: " + obj.contains(3)); // false
        obj.add(2);
        System.out.println("Contains 2: " + obj.contains(2)); // true
        obj.remove(2);
        System.out.println("Contains 2: " + obj.contains(2)); // false
    }
}
