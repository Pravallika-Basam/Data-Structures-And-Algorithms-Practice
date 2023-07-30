package Trees.BinaryTrees;

import Trees.Node;

public class IsBinaryTreeBalanced {
    public static void main(String[] args) {
        // Test Case 1: A balanced binary tree
        Node<Integer> root1 = new Node<>(10);
        root1.left = new Node<>(5);
        root1.right = new Node<>(15);
        root1.left.left = new Node<>(3);
        root1.left.right = new Node<>(7);
        root1.right.left = new Node<>(12);
        root1.right.right = new Node<>(20);

        int isBalanced = isHeightBalanced(root1);
        System.out.println("Test Case 1 - Is Balanced: " + (isBalanced != -1));

        // Test Case 2: An unbalanced binary tree
        Node<Integer> root2 = new Node<>(10);
        root2.left = new Node<>(5);
        root2.left.left = new Node<>(3);
        root2.left.left.left = new Node<>(2);

        int result2 = isHeightBalanced(root2);
        System.out.println("Test Case 2 - Is Balanced: " + (result2 != -1));

        // Test Case 3: An empty binary tree
        Node<Integer> root3 = null;
        int result3 = isHeightBalanced(root3);
        System.out.println("Test Case 3 - Is Balanced: " + (result3 != -1));

        // Test Case 5: A skewed left binary tree (Unbalanced)
        Node<Integer> root5 = new Node<>(10);
        root5.left = new Node<>(9);
        root5.left.left = new Node<>(8);
        root5.left.left.left = new Node<>(7);

        int result5 = isHeightBalanced(root5);
        System.out.println("Test Case 4 - Is Balanced: " + (result5 != -1));

        // Test Case 6: A skewed right binary tree (Unbalanced)
        Node<Integer> root6 = new Node<>(10);
        root6.right = new Node<>(11);
        root6.right.right = new Node<>(12);
        root6.right.right.right = new Node<>(13);

        int result6 = isHeightBalanced(root6);
        System.out.println("Test Case 5 - Is Balanced: " + (result6 != -1));
    }

    /**
     * Check if the binary tree is height-balanced.
     * A binary tree is height-balanced if the height difference between its left and right subtrees is at most 1.
     *
     * @param root The root of the binary tree
     * @return The height of the binary tree if it is height-balanced, otherwise returns -1
     */
    private static int isHeightBalanced(Node<Integer> root) {
        // Base case: If the node is null, it is height-balanced with height 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left subtree
        int lh = isHeightBalanced(root.left);
        // If the left subtree is not height-balanced, return -1 to indicate unbalanced
        if (lh == -1) {
            return -1;
        }

        // Recursively calculate the height of the right subtree
        int rh = isHeightBalanced(root.right);
        // If the right subtree is not height-balanced, return -1 to indicate unbalanced
        if (rh == -1) {
            return -1;
        }

        // Check if the height difference between left and right subtrees is greater than 1
        // If so, the binary tree is not height-balanced, return -1 to indicate unbalanced
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        // If the binary tree is height-balanced, return its height by adding 1 to the maximum height of its subtrees
        return Math.max(lh, rh) + 1;
    }

}
