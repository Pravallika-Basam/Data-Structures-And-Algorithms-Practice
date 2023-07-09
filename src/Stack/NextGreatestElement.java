package Stack;

import java.util.ArrayDeque;

public class NextGreatestElement {
    public static void main(String[] args) {

        int[] arr = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};
        //int[] arr = {9, 8, 7, 6, 5};
        nextClosestGreatestElement(arr, arr.length);
    }

    private static void nextClosestGreatestElement(int[] arr, int n) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> ansStack = new ArrayDeque<>();
        stack.push(arr[n - 1]);
        ansStack.push(-1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ansStack.push(-1);
            } else {
                ansStack.push(stack.peek());
            }
            stack.push(arr[i]);
        }
        System.out.println(ansStack);
    }

}
