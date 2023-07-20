package Queue;

import java.util.ArrayDeque;

/**
 * This program generates numbers using the digits from a given array of numbers.
 * It takes an array of digits, the length of the array, and the total count of numbers to generate as inputs.
 * The program generates numbers by combining the digits from the array in a queue-based approach.
 */
public class GenerateNumbers {
    public static void main(String[] args) {
        int[] numbers = {5, 6, 7};
        int total = 50;
        generateNumbers(numbers, numbers.length, total);
    }

    /**
     * Generates numbers using the digits from a given array.
     *
     * @param digits The array of digits
     * @param n      The length of the array
     * @param total  The total count of numbers to generate
     */
    private static void generateNumbers(int[] digits, int n, int total) {
        ArrayDeque<String> queue = new ArrayDeque<>();

        // Enqueue the digits as strings into the queue
        for (int digit : digits) {
            queue.offer(String.valueOf(digit));
        }
        /**
         *                                     Start
         *                                      |
         *                                      5
         *                                     /|\
         *                                    / | \
         *                                   /  |  \
         *                                  55  56  57
         *                                 /|\ /|\ /|\
         *                                / | | | | | \
         *                               555 556 557 565
         *                              /|\ /|\ /|\ /|\
         *                             / | | | | | | | \
         *                            ... ... ... ... ...
         */

        // Generate numbers by combining the digits in a queue-based approach
        for (int i = 0; i < total; i++) {
            String number = queue.poll();
            System.out.printf(number + " ");

            // Append each digit from the array to the current number and enqueue it back to the queue
            for (int j = 0; j < n; j++) {
                queue.offer(number + digits[j]);
            }
        }
    }
}
