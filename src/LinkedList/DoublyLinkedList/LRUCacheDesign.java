package LinkedList.DoublyLinkedList;

import java.util.HashMap;
import java.util.Scanner;

import static LinkedList.DoublyLinkedList.DoublyLinkedListOperations.printNodes;

public class LRUCacheDesign {
    /**
     * Using hashing (e.g., a HashMap) and a doubly linked list together is an efficient implementation
     * strategy for designing an LRU (Least Recently Used) cache.
     * This combination allows for constant time (O(1)) operations for both cache lookups and cache evictions.
     * <p>
     * Here's a high-level overview of the approach:
     * Maintain a HashMap to store key-value pairs, where the key represents the cache key,
     * and the value represents the corresponding cache node containing the key and value.
     * <p>
     * Use a doubly linked list to maintain the order of the cache nodes based on their usage,
     * with the most recently used node at the head and the least recently used node at the tail.
     * <p>
     * Each cache node in the doubly linked list contains references to its previous and next nodes,
     * as well as the key and value associated with it.
     * <p>
     * When a key is accessed (either through a cache get or put operation), follow these steps:
     * If the key exists in the cache, move the corresponding cache node to the head of
     * the doubly linked list(indicating it is the most recently used node).
     * <p>
     * If the key does not exist, create a new cache node and add it to the head of the doubly linked list.
     * <p>
     * If the cache has reached its maximum capacity, remove the least recently used node from the
     * tail of the doubly linked list and the corresponding entry from the HashMap.
     * <p>
     * The doubly linked list and HashMap work together to provide efficient operations:
     * The doubly linked list maintains the order of the cache nodes, allowing for easy removal and insertion in constant time.
     * The HashMap enables fast lookup and retrieval of cache nodes based on their keys.
     * <p>
     * This implementation ensures that the most recently used items are kept near the head of the list,
     * while the least recently used items are towards the tail.
     * <p>
     * By using a combination of hashing and a doubly linked list, we achieve efficient cache operations,
     * including O(1) time complexity for both cache lookups and evictions.
     *
     * @param args
     */
    public static void main(String[] args) {
        int capacity = 2;
        lruCacheDesign(capacity);
    }

    //TODO: Remove long method and extract into subMethods like addNode, DeleteNode etc
    private static void lruCacheDesign(int capacity) {
        // HashMap to store the key-value pairs of the cache
        HashMap<Integer, DoublyNode> map = new HashMap<>();
        DoublyNode head = null, tail = null;
        Scanner scan;

        while (true) {
            scan = new Scanner(System.in);
            System.out.println("Enter data to search");
            int data = scan.nextInt();

            if (map.containsKey(data)) {
                // Data found in the cache
                System.out.println(data + " found in Cache");
                System.out.println(map.toString());

                DoublyNode temp = map.get(data);

                if (temp != head) {
                    // Move the accessed node to the front of the cache (MRU position)
                    DoublyNode before = temp.prev;
                    DoublyNode after = temp.next;
                    before.next = after;
                    if (after != null) {
                        after.prev = before;
                    } else {
                        tail = before;
                    }
                    temp.next = head;
                    head.prev = temp;
                    temp.prev = null;
                    head = temp;
                }

                System.out.println("Linked List After is");
                printNodes(head);
                System.out.println();
            } else {
                // Data not present in the cache
                System.out.println("Data is not present in Cache");
                DoublyNode temp = new DoublyNode(data);

                if (map.size() < capacity) {
                    // Cache is not full, add the new data to the front of the cache
                    if (head == null) {
                        head = temp;
                        tail = temp;
                    } else {
                        head.prev = temp;
                        temp.next = head;
                        head = temp;
                    }
                } else {
                    // Cache is full, remove the least recently used data from the cache
                    int removeData = tail.data;
                    if (tail != head) {
                        DoublyNode before = tail.prev;
                        tail.prev = null;
                        before.next = null;
                        tail = before;

                        head.prev = temp;
                        temp.next = head;
                        temp.prev = null;
                        head = temp;
                    } else {
                        head = temp;
                        tail = temp;
                    }
                    map.remove(removeData);
                }

                // Add the new data to the cache
                map.put(data, temp);

                System.out.println("Cache after inserting data");
                System.out.println(map.toString());
                System.out.println("Linked List After is");
                printNodes(head);
                System.out.println();
            }
        }
    }

}
