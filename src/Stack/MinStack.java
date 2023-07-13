package Stack;

import java.util.ArrayDeque;

public class MinStack {
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static ArrayDeque<Integer> minStack = new ArrayDeque<>();

    public static void main(String[] args) {

        // Stack Operations Set 1
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
        //Stack Operation set 2
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        push(5);
        push(4);
        push(3);
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        pop();
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
        push(2);
        System.out.println("Minimum till now for the stack " + stack + " is " + getMin());
    }

    /**
     * Returns the minimum element in the stack in O(1) time.
     *
     * @return The minimum element or null if the stack is empty.
     */
    private static Integer getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return null;
    }

    /**
     * Removes and returns the top element from the stack.
     * If the removed element is the current minimum, it is also removed from the minStack.
     *
     * @return The removed element or null if the stack is empty.
     */
    private static Integer pop() {
        if (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
            }
            return pop;
        }
        return null;
    }

    /**
     * Pushes an element onto the stack.
     * If the element is smaller than the current minimum, it is also pushed onto the minStack.
     *
     * @param data The element to be pushed onto the stack.
     */
    private static void push(int data) {
        if (minStack.isEmpty() || data < minStack.peek()) {
            minStack.push(data);
        }
        stack.push(data);
    }

}
