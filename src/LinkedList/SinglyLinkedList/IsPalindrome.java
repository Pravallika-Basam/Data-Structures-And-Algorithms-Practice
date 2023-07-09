package LinkedList.SinglyLinkedList;

import static LinkedList.SinglyLinkedList.ReverseLinkedList.reverseSinglyLinkedList;

public class IsPalindrome {
    public static void main(String[] args) {
//        Node head = new Node('g');
//        head.next = new Node('f');
//        head.next.next = new Node('g');
//        head.next.next.next = new Node('f');
//        head.next.next.next.next = new Node('g');
        Node head = new Node('g');
        head.next = new Node('f');
        head.next.next = new Node('b');
        head.next.next.next = new Node('b');
        head.next.next.next.next = new Node('f');
        head.next.next.next.next.next = new Node('g');
        System.out.println("Initial LinkedList");
        printNodes(head);

        if (isPalindrome(head))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    private static boolean isPalindrome(Node head) {
        // If the list is empty or has only one node, it is considered a palindrome
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }

        // Use the slow and fast pointers to find the middle of the linked list
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        slow = reverseSinglyLinkedList(slow);

        // Compare the first half (original order) with the second half (reversed order)
        Node temp = head;
        while (slow != null) {
            if (temp.data != slow.data) {
                // If a mismatch is found, the list is not a palindrome
                return false;
            }
            slow = slow.next;
            temp = temp.next;
        }

        // If all comparisons pass, the list is a palindrome
        return true;
    }

    private static void printNodes(Node temp) {
        if (temp == null) {
            return;
        }
        System.out.println((char) temp.data);
        printNodes(temp.next);
    }
}
