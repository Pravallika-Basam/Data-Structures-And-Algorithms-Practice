package Trees.BinaryTrees;

import Trees.Node;

public class ChildSumProperty {
    public static void main(String[] args) {
        // Example 1
        Node root1 = new Node(20);
        root1.left = new Node(10);
        root1.right = new Node(10);
        root1.left.left = new Node(4);
        root1.left.right = new Node(6);
        root1.right.left = new Node(5);
        root1.right.right = new Node(5);

        System.out.println("Example 1: " + isChildSum(root1)); // Output: true

        // Example 2
        Node root2 = new Node(50);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.left = new Node(10);
        root2.left.right = new Node(10);
        root2.right.right = new Node(20);

        System.out.println("Example 2: " + isChildSum(root2)); // Output: true

        // Example 3
        Node root3 = new Node(100);
        root3.left = new Node(20);
        root3.right = new Node(80);
        root3.right.left = new Node(40);
        root3.right.right = new Node(40);
        root3.right.right.right = new Node(60);

        System.out.println("Example 3: " + isChildSum(root3)); // Output: true

        // Edge Case 1: Null tree
        Node root4 = null;
        System.out.println("Edge Case 1: " + isChildSum(root4)); // Output: true

        // Edge Case 2: Single node tree
        Node root5 = new Node(5);
        System.out.println("Edge Case 2: " + isChildSum(root5)); // Output: true

        // Edge Case 3: Tree with a single child
        Node root6 = new Node(10);
        root6.left = new Node(5);
        System.out.println("Edge Case 3: " + isChildSum(root6)); // Output: true

        // Edge Case 4: Tree with a single child having negative value
        Node root7 = new Node(10);
        root7.left = new Node(-5);
        root7.right = new Node<>(15);
        System.out.println("Edge Case 4: " + isChildSum(root7)); // Output: false
    }

    /**
     * This function checks whether a binary tree satisfies the children sum property or not.
     * The children sum property states that for every node in the tree, the value of the node
     * should be equal to the sum of its left and right child's value (if present).
     *
     * @param root The root node of the binary tree
     * @return True if the binary tree satisfies the children sum property, false otherwise
     */
    private static boolean isChildSum(Node<Integer> root) {
        // Base case: If the node is null, it satisfies the property
        if (root == null) {
            return true;
        }

        // If the node is a leaf node (no children), it satisfies the property
        if (root.left == null && root.right == null) {
            return true;
        }

        // Calculate the sum of the values of the left and right children
        int sum = 0;
        if (root.left != null) {
            sum += root.left.data;
        }
        if (root.right != null) {
            sum += root.right.data;
        }

        // Check if the node's value is equal to the sum of its children's values,
        // and recursively check for the left and right subtrees
        return (root.data == sum) && isChildSum(root.left) && isChildSum(root.right);
    }

}
