package LinkedList.SinglyLinkedList;

import java.util.LinkedList;

public class InsertInSortedLinkedList {
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

        System.out.println("Linked List after Inserting in sorted Linked List");
        head = insertInSorted(head,25);
        printNodes(head);
        System.out.println();

        System.out.println("Linked List after Inserting in sorted Linked List");
        head = insertInSorted(head,5);
        printNodes(head);
        System.out.println();

        System.out.println("Linked List after Inserting in sorted Linked List");
        head = insertInSorted(head,2);
        printNodes(head);
        System.out.println();

    }

    private static Node insertInSorted(Node head, int data) {
        Node node = new Node(data);
        if(head==null){
            return node;
        }
        Node temp = head;
        if(head.data>data){
            node.next = head;
            head = node;
        } else {
            while (temp.next != null && temp.next.data < data) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        return head;
    }

    private static void printNodes(Node temp) {
        if(temp == null){
            return;
        }
        System.out.println(temp.data);
        printNodes(temp.next);
    }
}
