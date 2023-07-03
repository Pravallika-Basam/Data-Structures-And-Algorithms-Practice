package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.SinglyLinkedListOperations.printNodes;

public class NthNodeOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 2; i < 6; i++) {
            temp.next = new Node(10*i);
            temp = temp.next;
        }
        System.out.println("Initial Linked List");
        printNodes(head);
        System.out.println();

        int n = 5;
        int data = nthNodeFromTheEnd(head,n);
        System.out.println(n+"th node from the end is "+data);
    }

    private static int nthNodeFromTheEnd(Node head, int n) {
        int count = 0;

        // Check if the list is empty
        if (head == null) {
            return -1; // Return -1 to indicate that the list is empty
        }

        // Assign the head node to a fast node
        Node fast = head;

        // Traverse the list until the count reaches the specified position 'n'
        while (count < n) {
            // Check if the fast node reaches the end of the list before the desired position 'n'
            if (fast == null) {
                return -1; // Return -1 to indicate that 'n' is greater than total number of nodes in the list
            }
            // Move the fast node one step forward
            fast = fast.next;
            count++;
        }

        // Initialize a slow pointer pointing to the head node
        Node slow = head;

        // Move both the slow and fast pointers until the fast pointer reaches the end of the list
        // As fast is n positions ahead already, By moving both pointers together in each iteration,
        // the distance between the slow and fast pointers remains n.
        // By the time fast reaches end, slow might have reached len-n which is the desired position.
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Return the data of the node pointed to by the slow pointer, which represents the 'n'-th node from the end
        return slow.data;
    }

}
