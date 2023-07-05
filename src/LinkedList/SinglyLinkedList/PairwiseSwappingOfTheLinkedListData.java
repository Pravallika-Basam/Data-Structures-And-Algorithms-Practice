package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.SinglyLinkedListOperations.printNodes;

public class PairwiseSwappingOfTheLinkedListData {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 2; i < 5; i++) {
            temp.next = new Node(10 * i);
            temp = temp.next;
        }
//        Node head = null;

        System.out.println("Initial Linked List");
        printNodes(head);
        System.out.println();

        System.out.println("Linked List after Pair Swapping!!");
        head = swapPairs(head);
        printNodes(head);
        System.out.println();
    }

    private static Node swapPairs(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            int data = temp.data;
            temp.data = temp.next.data;
            temp.next.data = data;
            temp = temp.next.next;
        }
        return head;
    }
}
