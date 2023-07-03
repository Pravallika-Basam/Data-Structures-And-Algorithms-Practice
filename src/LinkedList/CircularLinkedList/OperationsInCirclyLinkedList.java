package LinkedList.CircularLinkedList;

import LinkedList.SinglyLinkedList.Node;

public class OperationsInCirclyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 2; i <= 3; i++) {
            temp.next = new Node(10*i);
            temp = temp.next;
        }
        temp.next = head;
       //Node head = null;

        System.out.println("Initial Linked List");
        printNodes(head);

        System.out.println("Linked List after inserting in the beg");
        head = insertInTheBeg(head,100);
        printNodes(head);

        System.out.println("Linked List after inserting in the End");
        head = insertInTheEndCircly(head,120);
        printNodes(head);

        System.out.println("Linked List after Deleting in the Beg");
        head = deleteInTheBeginningCircly(head);
        printNodes(head);

    }

    private static Node deleteInTheBeginningCircly(Node head) {
        // Check if the list is empty
        if (head == null) {
            return null; // If the list is empty, return null
        }

        // Check if the list has only one node
        if (head.next == null) {
            return null; // If the list has only one node, return null (deleting the node)
        }

        // Replace the data of the head node with the data of the next node
        head.data = head.next.data;

        // Update the next pointer of the head node to skip the next node and point to the node after it
        head.next = head.next.next;

        // Return the updated head node
        return head;
    }

    //Note this is just an O(1) operation if we swap the data.
    private static Node insertInTheEndCircly(Node head, int data) {
        // Create a new node with the given data
        Node node = new Node(data);

        // Check if the list is empty
        if (head == null) {
            // If the list is empty, make the new node point to itself
            node.next = node;
            return node; // Return the new node as the head of the list
        }

        // Insert the new node at the end of the circular list
        node.next = head.next;
        head.next = node;

        // Swap data between the head node and the newly inserted node
        swapData(head);

        // Move the head pointer to the newly inserted node
        head = head.next;

        // Return the updated head node
        return head;
    }


    private static void swapData(Node head) {
        int val = head.data;
        head.data= head.next.data;
        head.next.data = val;
    }


    // Here we are doing it in linear time. However we can simply Do the insertion in O(1) time.
    // Insert the element just after head and then swap it.
    private static Node insertInTheBeg(Node head, int data) {
        // Create a new node with the given data
        Node node = new Node(data);

        // Check if the list is empty
        if (head == null) {
            // If the list is empty, make the new node circular by pointing its next reference to itself
            node.next = node;
            return node; // Return the new node as the new head of the list
        }

        // Traverse to the last node of the current circular list
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Make the last node point to the new node, thereby including it at the beginning
        temp.next = node;

        // Update the next reference of the new node to point to the current head node
        node.next = head;

        // Update the head reference to the new node, as it is now the first node in the circular list
        head = node;

        // Return the updated head node
        return head;
    }


    private static void printNodes(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
