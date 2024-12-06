package Hashingg;

import java.util.*;

class HashMapLL {
    private List<Entity>[] entities;

    public HashMapLL() {
        entities = new LinkedList[100];
        for (int i = 0; i < entities.length; i++) {
            entities[i] = new LinkedList<>();
        }
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
        for (Entity entity : entities[hash]) {
            if (entity.key == key) {
                entity.value = value; // Update value if key already exists
                return;
            }
        }
        entities[hash].add(new Entity(key, value)); // Add new key-value pair
    }

    public int get(int key) {
        int hash = hash(key);
        for (Entity entity : entities[hash]) {
            if (entity.key == key) {
                return entity.value;
            }
        }
        return -1; // Return -1 if key not found
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Entity> iterator = entities[hash].iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity.key == key) {
                iterator.remove();
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(2, 40); // This should update the value for key 2
        System.out.println("Used Linked List");
        System.out.println("Value for key 1: " + map.get(1)); // Output: 10
        System.out.println("Value for key 2: " + map.get(2)); // Output: 40
        System.out.println("Value for key 3: " + map.get(3)); // Output: 30

        map.remove(1);
        System.out.println("Value for key 1 after removal: " + map.get(1)); // Output: -1 (not found)
    }
}
