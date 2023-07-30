package Trees.BinaryTrees;

import Trees.Node;

public class FlattenBinaryTree {

    private static Node<Integer> head = null; // Head of the doubly linked list
    private static Node<Integer> prev = null; // Previously processed node in inorder traversal

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.right = new Node<>(6);

        // Test case 1: Convert the binary tree to a doubly linked list
        convertToDoublyLinkedList(root);
        printDoublyLinkedList(head); // Expected output: 4 <-> 2 <-> 5 <-> 1 <-> 3 <-> 6

        // Test case 2: Convert an empty binary tree to a doubly linked list
        head = null;
        prev = null;
        convertToDoublyLinkedList(null);
        printDoublyLinkedList(head); // Expected output: null

        // Test case 3: Convert a binary tree with only one node to a doubly linked list
        head = null;
        prev = null;
        Node<Integer> root3 = new Node<>(7);
        convertToDoublyLinkedList(root3);
        printDoublyLinkedList(head); // Expected output: 7

        // Test case 4: Convert a binary tree with negative values to a doubly linked list
        head = null;
        prev = null;
        Node<Integer> root4 = new Node<>(-1);
        root4.left = new Node<>(-2);
        root4.right = new Node<>(-3);
        root4.left.left = new Node<>(-4);
        root4.left.right = new Node<>(-5);
        root4.right.right = new Node<>(-6);
        convertToDoublyLinkedList(root4);
        printDoublyLinkedList(head); // Expected output: -4 <-> -2 <-> -5 <-> -1 <-> -3 <-> -6

        // Test case 5: Convert a skewed binary tree to a doubly linked list
        head = null;
        prev = null;
        Node<Integer> root5 = new Node<>(1);
        root5.right = new Node<>(2);
        root5.right.right = new Node<>(3);
        root5.right.right.right = new Node<>(4);
        convertToDoublyLinkedList(root5);
        printDoublyLinkedList(head); // Expected output: 1 <-> 2 <-> 3 <-> 4
    }

    /**
     * Converts a binary tree to a doubly linked list in place.
     * The resulting doubly linked list will have nodes connected in the inorder traversal order.
     *
     * @param root The root node of the binary tree.
     */
    private static void convertToDoublyLinkedList(Node<Integer> root) {
        if (root == null) {
            return;
        }

        // Convert the left subtree
        convertToDoublyLinkedList(root.left);

        // Process the current node
        if (prev == null) {
            // If prev is null, this is the leftmost node, hence assign it to the head
            head = root;
        } else {
            // Otherwise, connect the previous node's right pointer to the current node
            // and the current node's left pointer to the previous node.
            root.left = prev;
            prev.right = root;
        }
        prev = root; // Update the previous node to the current node for the next iteration

        // Convert the right subtree
        convertToDoublyLinkedList(root.right);
    }

    private static void printDoublyLinkedList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.right != null) {
                System.out.print(" <-> ");
            }
            current = current.right;
        }
        System.out.println();
    }
}
