package Trees.BinaryTrees;

import Trees.Node;

public class PreorderTraversal {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);
        root.left = new Node<>(20);
        root.right = new Node<>(30);
        root.left.left = new Node<>(40);
        root.left.right = new Node<>(50);
        root.right.left = new Node<>(60);
        root.right.right = new Node<>(70);
        root.left.left.left = new Node<>(80);
        root.left.left.right = new Node<>(90);
        root.left.right.left = new Node<>(100);
        root.left.right.right = new Node<>(110);
        root.right.left.left = new Node<>(120);
        root.right.left.right = new Node<>(130);

        /** The above tree looks like below!!
         *         10
         *        /  \
         *      20    30
         *     / \    / \
         *   40  50  60  70
         *  / \   / \
         * 80  90 100110
         *
         *
         */
        int size = preOrderTreeTraversal(root);
        System.out.println("Size of the Trees is " + size);


        // Input 2 :
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        size = preOrderTreeTraversal(root);
        System.out.println("Size of the Trees is " + size);
    }

    /**
     * Performs a pre-order traversal of a binary tree rooted at the given node and prints the node values.
     *
     * @param root The root node of the binary tree
     * @return The total number of nodes in the binary tree
     */
    private static int preOrderTreeTraversal(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        // Print the value of the current node
        System.out.printf(root.data + " ");

        // Recursive pre-order traversal of the left subtree
        int leftSize = preOrderTreeTraversal(root.left);

        // Recursive pre-order traversal of the right subtree
        int rightSize = preOrderTreeTraversal(root.right);

        // Return the total number of nodes in the binary tree
        return leftSize + rightSize + 1;
    }
}
