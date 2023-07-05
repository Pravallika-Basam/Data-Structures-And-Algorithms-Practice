package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.SinglyLinkedListOperations.printNodes;

public class RemoveDuplicatesInSortedLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 2; i < 6; i++) {
            temp.next = new Node(10);
            temp = temp.next;
        }
        temp.next = new Node(20);
        temp = temp.next;
        temp.next = new Node(20);
        temp = temp.next;
        temp.next = new Node(30);
//        Node head = null;

        System.out.println("Initial Linked List");
        printNodes(head);
        System.out.println();


        System.out.println("List after removing duplicates");
        head = removeDuplicates(head);
        printNodes(head);
        System.out.println();
    }

    private static Node removeDuplicates(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;

    }
}
