package Trees.BinaryTrees;

import Trees.Node;

import java.util.ArrayDeque;

public class SpiralTreeTraversal {
    public static void main(String[] args) {
        // Test case 1 - Empty tree
        Node<Integer> root1 = null;
        System.out.println("Test case 1:");
        printSpiral(root1); // Expected output: (empty line)

        // Test case 2 - Single Node<Integer> tree
        Node<Integer> root2 = new Node<>(1);
        System.out.println("\nTest case 2:");
        printSpiral(root2); // Expected output: 1

        // Test case 3 - Tree with two levels (balanced)
        Node<Integer> root3 = new Node<>(1);
        root3.left = new Node<>(2);
        root3.right = new Node<>(3);
        System.out.println("\nTest case 3:");
        printSpiral(root3); // Expected output: 1 2 3

        // Test case 4 - Tree with three levels (balanced)
        Node<Integer> root4 = new Node<>(1);
        root4.left = new Node<>(2);
        root4.right = new Node<>(3);
        root4.left.left = new Node<>(4);
        root4.left.right = new Node<>(5);
        root4.right.left = new Node<>(6);
        root4.right.right = new Node<>(7);
        System.out.println("\nTest case 4:");
        printSpiral(root4); // Expected output: 1 3 2 4 5 6 7

        // Test case 5 - Tree with four levels (balanced)
        Node<Integer> root5 = new Node<>(1);
        root5.left = new Node<>(2);
        root5.right = new Node<>(3);
        root5.left.left = new Node<>(4);
        root5.left.right = new Node<>(5);
        root5.right.left = new Node<>(6);
        root5.right.right = new Node<>(7);
        root5.left.left.left = new Node<>(8);
        root5.left.left.right = new Node<>(9);
        root5.left.right.left = new Node<>(10);
        root5.left.right.right = new Node<>(11);
        root5.right.left.left = new Node<>(12);
        root5.right.left.right = new Node<>(13);
        root5.right.right.left = new Node<>(14);
        root5.right.right.right = new Node<>(15);
        System.out.println("\nTest case 5:");
        printSpiral(root5); // Expected output: 1 3 2 4 5 6 7 15 14 13 12 11 10 9 8

        // Test case 6 - Skewed tree (left skew)
        Node<Integer> root6 = new Node<>(1);
        root6.left = new Node<>(2);
        root6.left.left = new Node<>(3);
        root6.left.left.left = new Node<>(4);
        root6.left.left.left.left = new Node<>(5);
        System.out.println("\nTest case 6:");
        printSpiral(root6); // Expected output: 1 2 3 4 5

        // Test case 7 - Skewed tree (right skew)
        Node<Integer> root7 = new Node<>(1);
        root7.right = new Node<>(2);
        root7.right.right = new Node<>(3);
        root7.right.right.right = new Node<>(4);
        root7.right.right.right.right = new Node<>(5);
        System.out.println("\nTest case 7:");
        printSpiral(root7); // Expected output: 1 2 3 4 5
    }


    /**
     * Perform a spiral (Zig-Zag) level order traversal of a binary tree.
     * The function prints the nodes of the tree in a spiral order starting from the root.
     *
     * @param root The root node of the binary tree.
     */
    private static void printSpiral(Node<Integer> root) {
        if (root == null) {
            return;
        }

        // Use a queue to store nodes at each level and a stack to reverse the order of nodes on alternate levels.
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        ArrayDeque<Node<Integer>> stack = new ArrayDeque<>();

        // Start with regular order traversal from the root node.
        queue.offer(root);

        // Use a flag to determine whether to print nodes in the normal or reverse order.
        boolean isReverse = false;

        // Continue the traversal while there are nodes to process in the queue.
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process nodes at the current level.
            for (int i = 0; i < size; i++) {
                Node<Integer> node = queue.poll();

                // Depending on the flag, either print the node directly or push it into the stack.
                if (isReverse) {
                    stack.push(node);
                } else {
                    System.out.printf(node.data + " ");
                }

                // Enqueue the left and right children of the current node for the next level traversal.
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // If the flag is set, print the nodes in reverse order from the stack.
            if (isReverse) {
                while (!stack.isEmpty()) {
                    System.out.printf(stack.pop().data + " ");
                }
            }
            // Flip the flag to switch between regular and reverse order traversal.
            isReverse = !isReverse;

            // Move to the next level (line break).
            System.out.println();
        }
    }
}
