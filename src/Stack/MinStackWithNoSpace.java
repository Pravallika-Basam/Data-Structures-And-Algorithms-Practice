package Stack;

import java.util.ArrayDeque;

/**
 * Implementation of a stack with minimum element retrieval.
 * NOTE: This method only works if input is all positive
 * This implementation optimizes space usage by not storing the minimum elements separately.
 */
public class MinStackWithNoSpace {

    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static Integer min = -1;

    /**
     * Main method to demonstrate the functionality of the MinStackWithNoSpace.
     * It performs various stack operations and prints the minimum element at each step.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        push(20);
        push(10);
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        push(5);
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        pop();
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        pop();
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        System.out.println();

        stack = new ArrayDeque<>();
        push(5);
        push(4);
        push(3);
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        pop();
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        push(2);
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        push(1);
        System.out.println("Peek till now for the stack " + stack + " is " + peek());
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
    }

    /**
     * Retrieves the minimum element from the stack.
     * Time Complexity: O(1)
     *
     * @return The minimum element or null if the stack is empty.
     */
    private static Integer getMin() {
        return min;
    }

    /**
     * Pushes an element onto the stack.
     * If the element is smaller than the current minimum, it updates the minimum and pushes a modified value to the stack.
     *
     * @param data The element to be pushed onto the stack.
     */
    private static void push(int data) {
        if (min == -1 || data < min) {
            stack.push(data - min);
            min = data;
        } else {
            stack.push(data);
        }
    }

    /**
     * Retrieves the top element of the stack without removing it.
     *
     * @return The top element or null if the stack is empty.
     */
    private static Integer peek() {
        if (!stack.isEmpty()) {
            return stack.peek() < 0 ? min : stack.peek();
        }
        return null;
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return The removed element or null if the stack is empty.
     */
    private static Integer pop() {
        if (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop < 0) {
                min -= pop;
            }
            return pop;
        }
        return null;
    }
}
