package Stack;

import java.util.ArrayDeque;

public class LargestAreaInAHistogram {
    public static void main(String[] args) {
        //int arr[] = {6, 2, 5, 4, 1, 5, 6};
        int arr[] = {2, 5, 1};
        int maxArea = calculateLargestArea(arr, arr.length);
        System.out.println("Max Area is " + maxArea);

    }

    public static int calculateLargestArea(int[] arr, int n) {

        int[] prev = previousClosestSmallestElement(arr);
        int[] next = nextClosestSmallestElement(arr, n);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            curr += arr[i] * (i - prev[i] - 1);
            curr += arr[i] * (next[i] - i - 1);
            //System.out.println("currArea = " + curr + " maxArea so Far is " + max);
            max = Math.max(curr, max);
        }
        return max;
    }

    public static int[] previousClosestSmallestElement(int[] arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ps = new int[arr.length];
        stack.push(0); // Push the index of the first element of the array to the stack
        ps[0] = -1; // Initialize the first element of the previous closest smallest array as -1

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop(); // Pop indices of greater elements from the stack
            }

            if (stack.isEmpty()) {
                ps[i] = -1; // If the stack is empty, there is no previous closest smaller element
            } else {
                ps[i] = stack.peek(); // Set the previous closest smaller element as the index at the top of the stack
            }

            stack.push(i); // Push the current index to the stack for future comparisons
        }

        return ps; // Return the array containing indices of previous closest smallest elements
    }


    public static int[] nextClosestSmallestElement(int[] arr, int n) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> ansStack = new ArrayDeque<>(); // It is used to store the indices of the next closest smaller elements.
        stack.push(n - 1);
        ansStack.push(n);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop(); // Pop indices of greater elements from the stack
            }

            if (stack.isEmpty()) {
                ansStack.push(n); // If the stack is empty, there is no next closest smaller element,
                // so push n This value serves as an indicator for situations where there is no NEXT closest smaller element available.
            } else {
                ansStack.push(stack.peek()); // Push the index at the top of the stack as the next closest smaller element
            }

            stack.push(i); // Push the current index to the stack for future comparisons
        }

        int[] nxt = new int[n]; //As we are iterating over the array from right to left, results in the ansStack will be from right to left as well.
        for (int i = 0; i < n; i++) {
            nxt[i] = ansStack.pop(); // Store the indices of next closest smaller elements in the `nxt` array from left to right.
        }

        return nxt; // Return the `nxt` array containing indices of next closest smaller elements in left to right
    }

}
