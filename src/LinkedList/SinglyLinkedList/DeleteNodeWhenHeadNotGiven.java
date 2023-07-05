package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.SinglyLinkedListOperations.printNodes;

public class DeleteNodeWhenHeadNotGiven {
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

        Node node = head.next;
        System.out.println("Node to delete is " + node.data);

        deleteNode(node);

        System.out.println("After Deleting Node ");
        printNodes(head);
        System.out.println();
    }

    // This is one of the tricky problem asked in an interview where a random address to a node of the linked list is
    // given and the user needs to delete the node of the given address.
    // The address can point to any random node in-between a linked list and NEVER TO THE LAST NODE.

    private static void deleteNode(Node node) {
        Node prev = null;  // Reference to the previous node
        while (node.next != null) {
            prev = node;  // Update prev to the current node
            node.data = node.next.data;  // Overwrite current node's data with next node's data
            node = node.next;  // Move to the next node
        }

        prev.next = null;  // Set the next reference of the previous node to null, removing the last node from the list
    }

}
