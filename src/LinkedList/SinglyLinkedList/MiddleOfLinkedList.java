package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.SinglyLinkedListOperations.printNodes;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 2; i < 3; i++) {
            temp.next = new Node(10*i);
            temp = temp.next;
        }

        System.out.println("Initial Linked List");
        printNodes(head);
        System.out.println();

        int pos = findMiddle(head);
        System.out.println("Middle of the LinkedList "+pos);
    }

    private static int findMiddle(Node head) {
        // Check if the list is empty
        if (head == null) {
            return 0; // Return 0 as there are no elements in the list
        }

        // Check if the list contains only one node
        if (head.next == null) {
            return head.data; // Return the data of the only node as the middle element
        }

        // Initialize two pointers, fast and slow, both pointing to the head node
        Node fast = head;
        Node slow = head;

        // Traverse the list using fast and slow pointers
        // until fast reaches the end or the last/second last node
        while (fast.next != null && fast.next.next != null) {
            // Move the slow pointer one step forward
            slow = slow.next;

            // Move the fast pointer two steps forward
            fast = fast.next.next;
        }

        // Return the data of the node pointed to by the slow pointer, which represents the middle element
        return slow.data;
    }

}
