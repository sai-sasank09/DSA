package Hashingg;
import java.util.*;

class MyHashMap {
    private Entity[] entities;

    public MyHashMap() {
        entities = new Entity[100];
    }

    private class Entity {
        int key;
        int value;

        public Entity(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(int key) {
        return Math.abs(key % entities.length);
    }

    public void put(int key, int value) {
        int hash = hash(key);
        entities[hash] = new Entity(key, value);
    }

    public int get(int key) {
        int hash = hash(key);
        if (entities[hash] != null && entities[hash].key == key) {
            return entities[hash].value;
        }
        return -1; // Return -1 if key not found (assuming value cannot be negative)
    }

    public void remove(int key) {
        int hash = hash(key);
        if (entities[hash] != null && entities[hash].key == key) {
            entities[hash] = null;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);

        System.out.println("Value for key 1: " + map.get(1)); // Output: 10
        System.out.println("Value for key 2: " + map.get(2)); // Output: 20

        map.remove(1);
        System.out.println("Value for key 1 after removal: " + map.get(1)); // Output: -1 (not found)
    }
}

