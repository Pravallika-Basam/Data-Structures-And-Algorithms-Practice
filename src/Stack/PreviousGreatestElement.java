package Stack;

import java.util.ArrayDeque;

public class PreviousGreatestElement {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] arr = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};
        //int[] arr = {9, 8, 7, 6, 5};
        previousClosestGreatestElement(stack, arr);
    }

    /**
     * This method uses a stack to find the previous closest greater element for each element in the array.
     * <p>
     * Time Complexity: Theta(N), where N is the number of elements in the array. Each element is pushed and popped once making it 2N operations.
     * Space Complexity: O(N), as the stack can store up to N elements in the worst case scenario where all elements are in descending order.
     *
     * @param stack
     * @param arr
     */
    private static void previousClosestGreatestElement(ArrayDeque<Integer> stack, int[] arr) {
        stack.push(arr[0]); // Push the first element of the array to the stack
        System.out.printf(-1 + " "); // Print -1 as there is no previous closest greater element for the first element
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop(); // Pop smaller elements from the stack
            }
            if (stack.isEmpty()) {
                System.out.printf(-1 + " "); // If the stack is empty, there is no previous closest greater element
            } else {
                System.out.printf(stack.peek() + " "); // Print the element at the top of the stack as the previous closest greater element
            }
            stack.push(arr[i]); // Push the current element to the stack for future comparisons
        }
    }

}
