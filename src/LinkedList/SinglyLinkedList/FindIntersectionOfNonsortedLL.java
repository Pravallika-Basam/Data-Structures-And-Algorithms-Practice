package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.SinglyLinkedListOperations.printNodes;

public class FindIntersectionOfNonsortedLL {
    public static void main(String[] args) {

        //LinkedList 1
        Node head1 = new Node(11);
        Node temp = head1;
        for (int i = 1; i < 4; i++) {
            temp.next = new Node(11 + i);
            temp = temp.next;
        }
//        Node head = null;

        System.out.println("Initial Linked List 1");
        printNodes(head1);
        System.out.println();

        //LinkedList 2

        Node head2 = new Node(130);
        Node temp2 = head2;
        for (int i = 1; i < 2; i++) {
            temp2.next = new Node(130 + i);
            temp2 = temp2.next;
        }
        temp2.next = head1;
//        Node head = null;

        System.out.println("Initial Linked List 2");
        printNodes(head2);
        System.out.println();

        int len1 = countNodes(head1);
        int len2 = countNodes(head2);

        System.out.println("Length of LL1 and LL2 are " + len1 + " " + len2);
        int diff = Math.abs(len1 - len2);
        int node;
        if (len1 > len2) {
            node = findIntersectionNodeNonSorted(diff, head1, head2);
        } else {
            node = findIntersectionNodeNonSorted(diff, head2, head1);
        }
        System.out.println("Intersection Node is " + node);

    }

    static int findIntersectionNodeNonSorted(int diff, Node head1, Node head2) {
        Node current1 = head1;  // Pointer for the first linked list
        Node current2 = head2;  // Pointer for the second linked list

        // Move the pointer of the longer linked list ahead by 'diff' positions
        for (int i = 0; i < diff; i++) {
            if (current1 == null) {  // If the pointer reaches the end of the list, there is no intersection
                return -1;
            }
            current1 = current1.next;
        }

        // Traverse both linked lists in parallel until the intersection is found
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {  // If the data values of the nodes are equal, it means an intersection is found
                return current1.data;  // Return the data value of the intersection node
            }
            current1 = current1.next;  // Move to the next node in the first list
            current2 = current2.next;  // Move to the next node in the second list
        }

        return -1;  // If no intersection is found, return -1
    }

    private static int countNodes(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
