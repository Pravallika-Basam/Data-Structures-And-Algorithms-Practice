package Stack;

import java.util.ArrayDeque;

public class StockSpanProblem {

    /**
     * Time Complexity: The time complexity of this function is Theta(n), where n is the number of elements in the array.
     * It iterates through the array once, performing constant-time operations for each element.
     * Each item is pushed once into the stack and popped out once. Making it 2N operations and Theta(n) time complexity.
     * <p>
     * Space Complexity: The space complexity of this function is O(n) as well.
     * It uses a stack to store indices, and the maximum size of the stack can be equal to the number of elements
     * in the array in the worst case scenario, when the array is sorted in non-decreasing order.
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // int[] arr = {13, 15, 12, 14, 16, 8, 6, 4, 10,30};
        int[] arr = {9, 8, 7, 6, 5};
        stockSpan(stack, arr);
    }

    /**
     * Calculates the stock span for each element in the given array.
     * The stock span is the number of consecutive days before the current day, including the current day,
     * for which the price of the stock was less than or equal to the price on the current day.
     *
     * @param stack The stack to store indices of elements with decreasing prices
     * @param arr   The array of stock prices
     */
    private static void stockSpan(ArrayDeque<Integer> stack, int[] arr) {
        stack.push(0);
        System.out.printf(1 + " "); // The span for the first day is always 1
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop(); // Pop smaller stock prices from the stack to get the closest larger element.
            }
            int span = stack.isEmpty() ? i + 1 : i - stack.peek(); // Calculate the span for the current day.
            // If the stack is empty after popping elements, it means that all previous stock prices were smaller,
            // so the span is the current day's index plus 1.
            // Otherwise, it's the difference between the current day's index and the index at the top of the stack.
            stack.push(i); // Push the current index to the stack for future comparisons
            System.out.printf(span + " "); // Print the calculated span for the current day
        }
    }

}
