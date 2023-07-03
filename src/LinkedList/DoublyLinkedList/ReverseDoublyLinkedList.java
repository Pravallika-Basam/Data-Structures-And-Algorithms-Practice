package LinkedList.DoublyLinkedList;

import LinkedList.DoublyLinkedList.DoublyNode;

import static LinkedList.DoublyLinkedList.DoublyLinkedListOperations.printNodes;

public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        DoublyNode head = new DoublyNode(10);
        DoublyNode temp = head;
        for (int i = 2; i < 4; i++) {
            DoublyNode node = new DoublyNode(10*i);
            node.prev = temp;
            temp.next = node;
            temp = temp.next;
        }
        System.out.println("List Initially");
        printNodes(head);
        System.out.println();
        System.out.println("List after reversing");
        head = reverseLinkedList(head);
        printNodes(head);
    }

    private static DoublyNode reverseLinkedList(DoublyNode head) {
        if (head!=null){
            DoublyNode temp = null;
            DoublyNode curr = head;
            while (curr!=null){
                DoublyNode temp2 = curr.next;
                curr.next = temp;
                curr.prev = temp2;
                temp = curr;
                curr = temp2;
            }
            head = temp;
        }
        return head;
    }
}
