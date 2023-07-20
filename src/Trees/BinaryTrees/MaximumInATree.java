package Trees.BinaryTrees;

import Trees.Node;

public class MaximumInATree {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10);
        root.left = new Node<>(20);
        root.right = new Node<>(30);
        root.left.left = new Node<>(40);
        root.left.right = new Node<>(50);
        root.right.left = new Node<>(300);
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
        int maximum = findMaximum(root);
        System.out.println("Maximum of the tree is " + maximum);
        System.out.println();

        // Input 2 :
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(330);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        maximum = findMaximum(root);
        System.out.println("Maximum of the tree is " + maximum);
        System.out.println();

        // Input 3 :
        root = new Node(10);
        maximum = findMaximum(root);
        System.out.println("Maximum of the tree is " + maximum);
        System.out.println();

        //Input 4
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        maximum = findMaximum(root);
        System.out.println("Maximum of the tree is " + maximum);
        System.out.println();
    }

    private static int findMaximum(Node<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Integer.max(root.data, Integer.max(findMaximum(root.left), findMaximum(root.right)));
    }
}
