package Trees.BinaryTrees;

import Trees.Node;

public class ConstructTreeFromInOrderAndPreOrder {
    static int start = 0;

    public static void main(String[] args) {
        // Test case 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};

        Node<Integer> root1 = buildTree(preorder1, inorder1, 0, inorder1.length - 1);
        System.out.println("Test case 1:");
        printInorder(root1); // Expected output: 9 3 15 20 7

        // Test case 2
        start = 0;
        int[] preorder2 = {1, 2, 3, 4};
        int[] inorder2 = {4, 3, 2, 1};

        Node<Integer> root2 = buildTree(preorder2, inorder2, 0, inorder2.length - 1);
        System.out.println("\nTest case 2:");
        printInorder(root2); // Expected output: 4 3 2 1

        // Test case 3 - Empty tree
        start = 0;
        int[] preorder3 = {};
        int[] inorder3 = {};

        Node<Integer> root3 = buildTree(preorder3, inorder3, 0, inorder3.length - 1);
        System.out.println("\nTest case 3:");
        printInorder(root3); // Expected output: (empty line)

        // Test case 4 - Single Node<Integer> tree
        start = 0;
        int[] preorder4 = {1};
        int[] inorder4 = {1};

        Node<Integer> root4 = buildTree(preorder4, inorder4, 0, 0);
        System.out.println("\nTest case 4:");
        printInorder(root4); // Expected output: 1

        // Test case 5 - Degenerate binary tree
        start = 0;
        int[] preorder5 = {1, 2, 3, 4, 5};
        int[] inorder5 = {1, 2, 3, 4, 5};

        Node<Integer> root5 = buildTree(preorder5, inorder5, 0, inorder5.length - 1);
        System.out.println("\nTest case 5:");
        printInorder(root5); // Expected output: 1 2 3 4 5
    }

    /**
     * Constructs a binary tree from given preorder and inorder traversals.
     *
     * @param preorder The preorder traversal array.
     * @param inorder  The inorder traversal array.
     * @param is       The starting index of inorder traversal array.
     * @param ie       The ending index of inorder traversal array.
     * @return The root of the binary tree.
     */
    private static Node<Integer> buildTree(int[] preorder, int[] inorder, int is, int ie) {
        if (is > ie) {
            return null;
        }
        Node<Integer> curr = new Node<>(preorder[start++]);
        int index = findIndex(inorder, curr.data);
        curr.left = buildTree(preorder, inorder, is, index - 1);
        curr.right = buildTree(preorder, inorder, index + 1, ie);
        return curr;
    }

    /**
     * Finds the index of a value in the given inorder traversal array.
     *
     * @param inorder The inorder traversal array.
     * @param data    The value to find.
     * @return The index of the value in the inorder array, or -1 if not found.
     */
    private static int findIndex(int[] inorder, int data) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == data) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Prints the inorder traversal of the binary tree rooted at the given node.
     *
     * @param root The root of the binary tree.
     */
    private static void printInorder(Node<Integer> root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
