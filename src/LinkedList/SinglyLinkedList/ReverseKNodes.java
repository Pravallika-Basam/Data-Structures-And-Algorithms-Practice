package LinkedList.SinglyLinkedList;

import java.util.HashSet;
import java.util.Set;

public class ReverseKNodes {
    public static void main(String[] args) {
        Node head = new Node(15);
        head.next.next = new Node(15);
        head.next.next.next = new Node(15);
        head.next.next.next.next = head.next;

        boolean b = isLoop(head);
        System.out.println("Floyd's Loop is " + b);

        b = isLoopHashing(head);
        System.out.println("Hashing Loop is " + b);

        b = isLoopTempNode(head);
        System.out.println("Temp Node Loop is " + b);
    }

    // Below code attempts to detect a loop in a linked list by using a temporary node.
    // Note that by using below method the linkedList is complete destroyed.
    private static boolean isLoopTempNode(Node head) {

        if (head == null) {
            return false;
        }

        // Create a temporary node with a distinct value
        Node node = new Node(100);

        // Start traversal from the head of the linked list
        Node curr = head;

        while (curr.next != null) {
            // If the next node points to the temporary node,
            // it indicates a loop as the current node was already visited and the next was altered to point to temp node
            if (curr.next == node) {
                return true;
            }

            // Store the reference to the next node before modifying the current node's next reference
            Node nxt = curr.next;

            // Modify the current node's next reference to point to the temporary node
            curr.next = node;

            // Move to the next node
            curr = nxt;
        }

        // No loop detected
        return false;
    }


    // Check if a linked list contains a loop using Hashing The HashSet uses the equals() and hashCode() methods
    // of the objects being stored to determine uniqueness.
    // By default, these methods compare object references for equality, not the actual content of the objects.
    // If there are nodes with the same data but different object references,
    // the HashSet will consider them as distinct objects and allow duplicates.

    private static boolean isLoopHashing(Node head) {
        // Check if the head node is null, indicating an empty list
        if (head == null) {
            return false;
        }

        // Create a HashSet to store visited nodes
        Set<Node> set = new HashSet<>();

        // Traverse the linked list
        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            // If the current node is already in the set, a loop is detected
            if (set.contains(temp)) {
                return true;
            }

            // Add the current node to the set
            set.add(temp);

            // Move to the next node
            temp = temp.next;
        }

        // If the loop is not detected, return false
        return false;
    }


    // Check if a linked list contains a loop

    private static boolean isLoop(Node head) {
        // Check if the head node is null, indicating an empty list
        if (head == null) {
            return false;
        }
        // Use the Floyd's cycle-finding algorithm with two pointers (slow and fast)
        // to detect a loop in the linked list
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;         // Move slow pointer by one step
            fast = fast.next.next;    // Move fast pointer by two steps

            // If the slow and fast pointers meet, a loop is detected
            if (slow == fast) {
                return true;
            }
        }

        // If the loop is not detected, return false
        return false;
    }

}
