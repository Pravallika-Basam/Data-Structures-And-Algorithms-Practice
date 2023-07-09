package Stack;

import java.util.ArrayList;

/**
 * A generic implementation of a stack using an ArrayList.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class MyStack<T> {
    ArrayList<T> myStack = new ArrayList<>();
    int top = -1;

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack, or null if the stack is empty.
     */
    T pop() {
        if (!this.isEmpty()) {
            T data = this.myStack.get(top);
            this.myStack.remove(top);
            this.top--;
            return data;
        }
        return null;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack, or null if the stack is empty.
     */
    T peek() {
        if (!this.myStack.isEmpty()) {
            return this.myStack.get(this.top);
        }
        return null;
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param data The element to be pushed onto the stack.
     */
    void push(T data) {
        this.top++;
        this.myStack.add(data);
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return The size of the stack.
     */
    int size() {
        return this.top + 1;
    }

    /**
     * Prints the stack
     */
    void printStack() {
        System.out.println(myStack.toString());
    }
}
