package Trees.BinaryTrees;

import Trees.Node;

public class HeightOfTheBinaryTree {
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
        int height = heightOfTheTree(root);
        System.out.println("Height of the Trees is " + height);


        // Input 2 :
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);

        height = heightOfTheTree(root);
        System.out.println("Height of the Trees is " + height);

        // Input 2 :
        root = new Node(10);

        height = heightOfTheTree(root);
        System.out.println("Height of the Trees is " + height);


    }

    private static int heightOfTheTree(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        int heightLeft = heightOfTheTree(root.left);
        int heightRight = heightOfTheTree(root.right);
        return 1 + Math.max(heightLeft, heightRight);
    }
}
