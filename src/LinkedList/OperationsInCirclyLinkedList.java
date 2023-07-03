package LinkedList;

public class OperationsInCirclyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp = head;
        for (int i = 2; i <= 3; i++) {
            temp.next = new Node(10*i);
            temp = temp.next;
        }
        temp.next = head;
       // Node head = null;

        System.out.println("Initial Linked List");
        printNodes(head);

        System.out.println("Linked List after inserting in the beg");
        head = insertInTheBeg(head,100);
        printNodes(head);

        System.out.println("Linked List after inserting in the End");
        head = insertInTheEndCircly(head,1000);
        printNodes(head);

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
        Node node = new Node(data);
        if(head == null){
            node.next = node;
            return node;
        }
        Node temp = head;
        node.next = head;
        while (temp.next!=head){
            temp = temp.next;
        }
        temp.next = node;
        head = node;
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
