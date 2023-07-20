package Deque;

/**
 * This program finds the starting point of a circular tour that visits all petrol pumps.
 * The program takes an array of petrol pumps where each pump has a certain amount of petrol
 * and the distance to the next petrol pump. It returns the index of the starting pump from
 * where a circular tour can be completed.
 */
public class FirstCircularTour {
    /**
     * Finds the starting point of a circular tour that visits all petrol pumps.
     *
     * @param arr The array of petrol pumps, where arr[i][0] represents the amount of petrol
     *            at the i-th pump and arr[i][1] represents the distance to the next pump.
     * @param n   The number of petrol pumps in the array.
     * @return The index of the starting pump if a circular tour is possible, -1 otherwise.
     */
    static int printTour(int arr[][], int n) {
        int start = 0; // Starting point of the tour
        int end = 1; // Next petrol pump to visit
        int curr_petrol = arr[start][0] - arr[start][1]; // Petrol remaining after reaching the current pump

        // Traverse the tour until we reach the starting point again
        while (end != start || curr_petrol < 0) {
            // If petrol is insufficient, move the starting point to the next pump
            while (curr_petrol < 0 && start != end) {
                curr_petrol -= arr[start][0] - arr[start][1];
                start = (start + 1) % n;
                if (start == 0)
                    return -1; // No solution exists
            }
            // Add the petrol of the next pump and move to it
            curr_petrol += arr[end][0] - arr[end][1];
            end = (end + 1) % n;
        }
        return start; // Return the starting point of the tour
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 30}, {10, 20}, {60, 100}, {100, 10}}; // Petrol pumps array
        int start = printTour(arr, arr.length); // Find the starting point of the tour
        System.out.println(start == -1 ? "No Solution" : start); // Print the result
    }
}
