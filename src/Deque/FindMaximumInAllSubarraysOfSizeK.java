package Deque;

import java.util.ArrayDeque;

/**
 * This program finds the maximum element in all subarrays of size k in a given array.
 * It uses a deque data structure to efficiently track the maximum elements.
 */
public class FindMaximumInAllSubarraysOfSizeK {
    public static void main(String[] args) {
        // Input array
        //int[] arr = {10, 8, 5, 12, 15, 7, 6};
        int[] arr = {20, 5, 3, 8, 6, 15};
        // Size of subarrays
        int k = 4;
        // Find the maximum element in all subarrays of size k
        findMaximumInAllSubarraysOfSizeK(arr, k, arr.length);
    }

    /**
     * Finds the maximum element in all subarrays of size k in a given array.
     *
     * @param arr The input array
     * @param k   The size of subarrays
     * @param n   The length of the array
     */
    private static void findMaximumInAllSubarraysOfSizeK(int[] arr, int k, int n) {
        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();

        // Initialize the deque with the first k elements
        for (int i = 0; i < k; i++) {
            addtoMaxQueue(maxQueue, arr[i]);
        }

        // Process the remaining elements
        for (int i = k; i < n; i++) {
            // Print the maximum element in the current subarray
            System.out.printf(maxQueue.getFirst() + " ");

            // Remove the first element of the deque if it is outside the current subarray
            if (maxQueue.getFirst() == arr[i - k]) {
                maxQueue.pollFirst();
            }

            // Add the current element to the deque
            addtoMaxQueue(maxQueue, arr[i]);
        }

        // Print the maximum element of the last subarray
        System.out.printf(maxQueue.getFirst() + " ");
    }

    /**
     * Adds an element to the deque while maintaining the deque in decreasing order.
     *
     * @param maxQueue The deque to add the element to
     * @param data     The element to be added
     */
    private static void addtoMaxQueue(ArrayDeque<Integer> maxQueue, int data) {
        if (maxQueue.isEmpty()) {
            maxQueue.addFirst(data);
        } else {
            // Remove elements from the deque that are smaller than the current element
            while (!maxQueue.isEmpty() && maxQueue.getLast() < data) {
                maxQueue.pollLast();
            }
            // Add the current element to the deque
            maxQueue.offerLast(data);
        }
    }
}
