package LinkedList;

public class SinglyLinkedListOperations {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 0; i < 3; i++) {
            temp.next = new Node(11+i);
            temp = temp.next;
        }

        System.out.println("Initial Linked List");
        printNodes(head);
        System.out.println();

        System.out.println("Linked List after Inserting in the Beg");

        head = insertBegining(head,new Node(100));
        printNodes(head);
        System.out.println();

        System.out.println("Linked List after Inserting in the End");
        head = insertInTheEnd(head,new Node(1000));
        printNodes(head);
        System.out.println();

        System.out.println("Linked List after Deleting in the Beg");
        head = deleteInTheBeg(head);
        printNodes(head);
        System.out.println();

        System.out.println("Linked List after Deleting in the End");
        head = deleteInTheEnd(head);
        printNodes(head);
        System.out.println();

        System.out.println("Linked List after Inserting at a position p");
        head = insertAtPos(head,200,2);
        printNodes(head);
        System.out.println();

        int ele = 10;
        int pos = findElementPos(head,ele);
        System.out.println("Found element "+ele+" at "+pos);


    }
    private static int findElementPos(Node head, int ele) {
        if(head == null){
            return -1;
        }
        Node temp = head;
        int pos = 0;
        while (temp!=null){
            if(temp.data==ele){
                return pos+1;
            }
            temp=temp.next;
            pos++;
        }
        return -1;
    }


    private static Node insertAtPos(Node head, int data, int pos) {
        Node node = new Node(data);
        if(head == null && pos==1){
            return node;
        }
        Node temp = head;
        int count = 0;
        while (temp!=null && count<pos-2){
            temp=temp.next;
            count++;
        }
        if(temp==null){
            return head;
        }
        node.next = temp.next;
        temp.next = node;
        return head;
    }

    private static Node deleteInTheEnd(Node head) {
        if(head!=null){
            Node temp = head;
            if(temp.next==null){
                return null;
            }
            while (temp.next!=null && temp.next.next!=null){
                temp= temp.next;
            }
            temp.next=null;
        }
        return head;
    }

    private static Node deleteInTheBeg(Node head) {
        if(head!=null){
            head = head.next;
        }
        return head;
    }

    private static Node insertInTheEnd(Node head, Node node) {
        if(head==null){
            head = node;
            return head;
        }
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    private static Node insertBegining(Node head, Node node) {
        if(head == null){
            head = node;
            return head;
        }
        node.next = head;
        head = node;
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
