package Trees.BinaryTrees;

import Trees.Node;

public class NodesAtKDistance {
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
        int k = 2;
        nodesAtK(root, 0, k);
        System.out.println();

        // Input 2 :
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        k = 1;
        nodesAtK(root, 0, k);
        System.out.println();

        // Input 2 :
        root = new Node(10);
        nodesAtK(root, 0, 0);
        System.out.println();

    }

    /**
     * Prints the nodes at a given level (k) in a binary tree rooted at the given node.
     *
     * @param root The root node of the binary tree
     * @param n    The current level of the node being visited
     * @param k    The level at which to print the nodes
     *             Time = O(N) Space : O(H) Height
     */
    private static void nodesAtK(Node<Integer> root, int n, int k) {
        if (root == null) {
            return;
        }
        if (n == k) {
            System.out.printf(root.data + " "); // Print the data of the current node
            return;
        }
        nodesAtK(root.left, n + 1, k); // Recursively traverse the left subtree with increased level
        nodesAtK(root.right, n + 1, k); // Recursively traverse the right subtree with increased level
    }
}
