package Stack;

/**
 * A generic implementation of a stack using a linked list.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class MyStackLL<T> {
    Node<T> head = null;
    int size = 0;

    /**
     * Returns the number of elements in the stack.
     *
     * @return The size of the stack.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack, or null if the stack is empty.
     */
    public T peek() {
        return head != null ? head.data : null;
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack, or null if the stack is empty.
     */
    public T pop() {
        if (head != null) {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
        return null;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param data The element to be pushed onto the stack.
     */
    public void push(T data) {
        Node<T> node = new Node<T>(data);
        if (head != null)
            node.next = head;

        head = node;
        size++;
    }

    /**
     * Prints the stack
     */
    public void printStack() {
        if (head == null) {
            return;
        }
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
