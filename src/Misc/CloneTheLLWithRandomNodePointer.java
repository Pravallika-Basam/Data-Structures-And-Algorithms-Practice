package Misc;

public class CloneTheLLWithRandomNodePointer {
    public static void main(String[] args) {
        // Create the original linked list
        NodeR head = new NodeR(11);
        head.next = new NodeR(12);
        head.next.next = new NodeR(13);
        head.next.next.next = new NodeR(14);
        head.next.next.next.next = new NodeR(15);

        // Set random pointers to create arbitrary connections
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next.next.next;

        System.out.print("Original list : \n");
        print(head);

        // Step 1: Create a chain by inserting a clone node after each original node
        NodeR chainHead = createChain(head);

        System.out.print("Clone list  : \n");
        // Step 2: Create the clone of the original list by setting random pointers of clone nodes
        chainHead = createClone(chainHead);
        print(chainHead);
    }

    /**
     * Creates a chain by inserting a clone node after each original node in the linked list.
     *
     * @param head The head of the original linked list
     * @return The head of the modified linked list with clones
     */
    private static NodeR createChain(NodeR head) {
        NodeR temp = head;
        while (temp != null) {
            // Create a clone node with the same data as the original node
            NodeR node = new NodeR(temp.data);
            NodeR nxt = temp.next;
            // Insert the clone node after the original node
            temp.next = node;
            node.next = nxt;
            temp = nxt;
        }
        return head;
    }

    /**
     * Creates a clone of the original linked list by setting the random pointers of the clone nodes.
     *
     * @param head The head of the cloned linked list
     * @return The head of the cloned linked list
     */
    private static NodeR createClone(NodeR head) {
        NodeR temp = head;
        while (temp != null) {
            if (temp.random != null)
                // Set the random pointer of the clone node to the corresponding clone node in the original list.
                // Consider the original list: 1 -> 2 -> 3 -> 4 -> 5 with arbitrary connections.
                // After inserting the clone nodes, the modified list becomes: 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> 4 -> 4' -> 5 -> 5'.
                // At this point, the random pointers of the clone nodes are pointed to null.
                // However, we want the random pointers of the clone nodes to point to their corresponding clone nodes.
                // By setting temp.next.random = temp.random.next, we are ensuring that the random pointer of each clone node points to its corresponding clone node in the modified list.
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        // Separating clone and real LinkedList
        NodeR head2 = head.next;
        temp = head2;
        while (temp.next != null) {
            // Remove the original nodes from the cloned list
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return head2;
    }


    public static void print(NodeR start) {
        NodeR ptr = start;
        while (ptr != null) {
            if (ptr.random == null) {
                System.out.println("Data = " + ptr.data + ", Random  = " + "null");
            } else {
                System.out.println("Data = " + ptr.data + ", Random  = " + ptr.random.data);
            }
            ptr = ptr.next;
        }
    }
}
