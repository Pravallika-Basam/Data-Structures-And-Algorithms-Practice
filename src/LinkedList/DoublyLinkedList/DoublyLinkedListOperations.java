package LinkedList.DoublyLinkedList;

public class DoublyLinkedListOperations {
    public static void main(String[] args) {
        DoublyNode head = new DoublyNode(10);
        DoublyNode temp = head;
        for (int i = 2; i < 6; i++) {
            DoublyNode node = new DoublyNode(10*i);
            node.prev = temp;
            temp.next = node;
            temp = temp.next;
        }
        System.out.println("List Initially");
        printNodes(head);
        System.out.println();
        System.out.println("Linked List after Inserting in the Beg");

        head = insertBeginning(head,new DoublyNode(100));
        printNodes(head);
        System.out.println();
    }

    private static DoublyNode insertBeginning(DoublyNode head, DoublyNode node) {
        if(head == null){
            return node;
        }
        node.next = head;
        head.prev = node;
        head = node;
        return head;
    }

    public static void printNodes(DoublyNode temp) {
        if(temp == null){
            return;
        }
        System.out.printf(temp.data+" ");
        printNodes(temp.next);
    }
}
