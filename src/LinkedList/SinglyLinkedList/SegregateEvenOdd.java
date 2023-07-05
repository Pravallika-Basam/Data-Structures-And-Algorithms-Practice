package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.SinglyLinkedListOperations.printNodes;

public class SegregateEvenOdd {
    public static void main(String[] args) {
        Node head = new Node(11);
        Node temp = head;
        for (int i = 1; i < 2; i++) {
            temp.next = new Node(11 + i);
            temp = temp.next;
        }
//        Node head = null;

        System.out.println("Initial Linked List");
        printNodes(head);
        System.out.println();

        head = segregateEvenOdd(head);
        System.out.println("Linked List After Segregation");
        printNodes(head);
        System.out.println();
    }

    private static Node segregateEvenOdd(Node head) {
        // Handling empty Linked List
        if (head == null) {
            return head;
        }
        // Handling Linked List with one node
        if (head.next == null) {
            return head;
        }

        // Variables to hold references for even and odd nodes, and their respective heads
        Node even = null, odd = null, evenHead = null, oddHead = null;

        Node temp = head;  // Temporary variable to iterate through the linked list

        // Traverse the linked list
        while (temp != null) {
            if (temp.data % 2 == 0) {  // If the data is even
                if (even == null) {  // If even node list is empty which mean this is the head for even sublist
                    even = temp;
                    evenHead = temp;
                } else {
                    even.next = temp;  // Add the current node to the even list
                    even = even.next;  // Move the even pointer
                }
            } else {  // If the data is odd
                if (odd == null) {  // If odd node list is empty which mean this is the head for odd sublist
                    odd = temp;
                    oddHead = temp;
                } else {
                    odd.next = temp;  // Add the current node to the odd list
                    odd = odd.next;  // Move the odd pointer
                }
            }
            temp = temp.next;  // Move to the next node
        }

        // Connect the even and odd lists
        if (odd == null) {
            return evenHead;  // If there are no odd nodes, return the even list
        }
        if (even == null) {
            return oddHead;  // If there are no even nodes, return the odd list
        }

        even.next = oddHead;  // Connect the last even node to the head of the odd list
        odd.next = null;  // Set the next reference of the last odd node to null

        return evenHead;  // Return the head of the modified list
    }

}
