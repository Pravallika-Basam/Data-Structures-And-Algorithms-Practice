/**
 * This program demonstrates the Left View of a Binary Tree, which shows the first node of each level
 * when viewed from the left side.
 */
package Trees.BinaryTrees;

import Trees.Node;

import java.util.ArrayDeque;

public class LeftViewOfATree {

    // A global variable to track the maximum level seen so far during the traversal
    static int maxLevel = 0;

    public static void main(String[] args) {
        // Input 1:
        Node<Integer> root1 = new Node<>(10);
        root1.left = new Node<>(20);
        root1.right = new Node<>(30);
        root1.left.left = new Node<>(40);
        root1.left.right = new Node<>(50);
        root1.right.left = new Node<>(300);
        root1.right.right = new Node<>(70);
        root1.left.left.left = new Node<>(80);
        root1.left.left.right = new Node<>(90);
        root1.left.right.left = new Node<>(100);
        root1.left.right.right = new Node<>(110);
        root1.right.left.left = new Node<>(120);
        root1.right.left.right = new Node<>(130);

        // Print the left view of the binary tree
        System.out.println("Left View of Tree 1:");
        leftViewOfATree(root1, 1);
        System.out.println();

        // Print the left view of the binary tree
        System.out.println("Left View of Tree 1:");
        leftViewOfATreeLevelOrder(root1);
        System.out.println();

        // Input 2:
        maxLevel = 0;
        Node<Integer> root2 = new Node<>(10);
        root2.left = new Node<>(20);
        root2.right = new Node<>(330);
        root2.right.left = new Node<>(40);
        root2.right.right = new Node<>(50);

        // Print the left view of the binary tree
        System.out.println("Left View of Tree 2:");
        leftViewOfATree(root2, 1);
        System.out.println();

        // Print the left view of the binary tree
        System.out.println("Left View of Tree 2:");
        leftViewOfATreeLevelOrder(root2);
        System.out.println();

        // Input 3:
        maxLevel = 0;
        Node<Integer> root3 = new Node<>(10);

        // Print the left view of the binary tree
        System.out.println("Left View of Tree 3:");
        leftViewOfATree(root3, 1);
        System.out.println();

        // Print the left view of the binary tree
        System.out.println("Left View of Tree 3:");
        leftViewOfATreeLevelOrder(root3);
        System.out.println();


        // Input 4:
        maxLevel = 0;
        Node<Integer> root4 = new Node<>(10);
        root4.left = new Node<>(20);
        root4.right = new Node<>(30);
        root4.left.left = new Node<>(40);
        root4.left.right = new Node<>(50);
        root4.right.left = new Node<>(60);
        root4.right.right = new Node<>(70);

        // Print the left view of the binary tree
        System.out.println("Left View of Tree 4:");
        leftViewOfATree(root4, 1);
        System.out.println();

        // Print the left view of the binary tree
        System.out.println("Left View of Tree 4:");
        leftViewOfATreeLevelOrder(root4);
        System.out.println();
    }

    /**
     * Prints the Left View of a Binary Tree.
     *
     * @param root  The root node of the binary tree
     * @param level The level of the current node during the traversal
     */
    private static void leftViewOfATree(Node<Integer> root, int level) {
        if (root == null) {
            return;
        }
        // If the current level is greater than the maximum level seen so far which means this is the first node of the current level,
        // print the data of the current node and update the maximum level.
        if (maxLevel < level) {
            System.out.printf(root.data + " ");
            maxLevel = level;
        }
        // Traverse the left and right subtrees with an incremented level.
        leftViewOfATree(root.left, level + 1);
        leftViewOfATree(root.right, level + 1);
    }

    /**
     * This method prints the left view of a binary tree using a level-order traversal.
     * The left view of a binary tree is the first node at each level when viewed from the left side.
     *
     * @param root The root node of the binary tree
     */
    private static void leftViewOfATreeLevelOrder(Node<Integer> root) {
        if (root == null) {
            return;
        }
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node<Integer> node = queue.poll();
                if (node != null) {
                    // Print the first node at each level (leftmost node)
                    if (i == 0) {
                        System.out.printf(node.data + " ");
                    }
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }
    }
}
