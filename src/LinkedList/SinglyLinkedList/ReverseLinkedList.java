package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.SinglyLinkedListOperations.printNodes;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 2; i < 6; i++) {
            temp.next = new Node(10 * i);
            temp = temp.next;
        }
//        Node head = null;

        System.out.println("Initial Linked List");
        printNodes(head);
        System.out.println();

        System.out.println("Reversed LinkedList ");
        head = reverseSinglyLinkedList(head);
        printNodes(head);
        System.out.println();

        System.out.println("Reversed LinkedList Recursive");
        head = reverseSinglyLinkedListRecursively(null, head);
        printNodes(head);
        System.out.println();

    }

    // Reverse a singly linked list recursively
    private static Node reverseSinglyLinkedListRecursively(Node prev, Node curr) {
        // Check if the current node is null, indicating the end of the list
        if (curr == null) {
            return prev; // Return the previous node, which is now the new head of the reversed list
        }

        // Store the next node in a temporary variable
        Node nxt = curr.next;

        // Reverse the link of the current node by pointing it to the previous node
        curr.next = prev;

        // Recursively call the function with the current node as the new previous node
        // and the next node as the current node
        return reverseSinglyLinkedListRecursively(curr, nxt);
    }


    private static Node reverseSinglyLinkedList(Node head) {
        // Check if the list is empty
        if (head == null) {
            return null; // Return null if the list is empty
        }

        // Check if the list has only one node
        if (head.next == null) {
            return head; // Return the head node as it is the only node in the list
        }

        // Initialize current node as the head node, and previous node as null
        Node curr = head;
        Node prev = null;

        // Traverse the list and reverse the links between nodes
        while (curr != null) {
            // Store the next node in a temporary variable
            Node nxt = curr.next;

            // Reverse the link of the current node by pointing it to the previous node
            curr.next = prev;

            // Update the previous node to be the current node
            prev = curr;

            // Move to the next node in the original list
            curr = nxt;
        }

        // Return the new head of the reversed list, which is the last node encountered (previously the first node)
        return prev;

    }


}
