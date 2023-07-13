package Queue;

import java.util.ArrayDeque;
import java.util.List;

/**
 * This program demonstrates how to reverse the elements of a queue.
 * The initial queue is provided, and the program reverses the order of elements in the queue.
 * It uses both iterative and recursive approaches to reverse the queue.
 */
public class ReverseAQueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>(List.of(new Integer[]{10, 20, 30, 40}));
        System.out.println("Initial Queue is " + queue);

        reverseQueueIterative(queue);
        System.out.println("Reversed Queue (Iterative) is " + queue);

        reverseQueueRecursive(queue);
        System.out.println("Reversed Queue (Recursive) is " + queue);
    }

    /**
     * Reverses the order of elements in the queue using an iterative approach.
     *
     * @param queue The input queue
     */
    private static void reverseQueueIterative(ArrayDeque<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Pop each element from the queue and push it onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Pop each element from the stack and enqueue it back to the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }

    /**
     * Reverses the order of elements in the queue using a recursive approach.
     *
     * @param queue The input queue
     */
    private static void reverseQueueRecursive(ArrayDeque<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // Remove the top element from the queue
        Integer topElement = queue.poll();

        // Reverse the remaining elements in the queue recursively
        reverseQueueRecursive(queue);

        // Enqueue the top element back to the queue
        queue.offer(topElement);
    }
}
