package Trees.BinaryTrees;

import Trees.Node;

import java.util.ArrayDeque;

public class LevelOrderTraversal {
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
         * 80  90 100 110
         *
         *
         */
        int size = levelOrder(root);
        System.out.println("Size of the tree is " + size);
        System.out.println();

        // Input 2 :
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        size = levelOrder(root);
        System.out.println("Size of the tree is " + size);
        System.out.println();

        // Input 3 :
        root = new Node(10);
        size = levelOrder(root);
        System.out.println("Size of the tree is " + size);
        System.out.println();

        //Input 4
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        size = levelOrder(root);
        System.out.println("Size of the tree is " + size);
        System.out.println();
    }

    /**
     * Performs level order traversal on a binary tree and prints the nodes at each level.
     *
     * @param root The root node of the binary tree
     */
    private static int levelOrder(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        // Create a queue to store the nodes for level order traversal
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);

        //Initialize count variable
        int count = 0;

        // Perform level order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            count += levelSize;
            // Process nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node<Integer> node = queue.poll();

                // Process the current node
                if (node != null) {
                    // Enqueue the left and right child nodes, if they exist
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    System.out.printf(node.data + " ");
                }
            }
            System.out.println(); // Print a new line after each level
        }
        return count;
    }

}
