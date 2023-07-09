package Stack;

import static Stack.LargestAreaInAHistogram.calculateLargestArea;

public class MaximumSubmatrixWithAll1 {
    public static void main(String[] args) {
//        int arr[][] = {
//                {1, 1, 0, 1, 1},
//                {1, 1, 1, 1, 1},
//                {0, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1},
//                {1, 0, 1, 1, 1},
//                {1, 1, 1, 1, 1}
//        };

//        int arr[][] = {
//                {1, 1, 0, 1},
//                {1, 1, 1, 1},
//                {0, 1, 1, 1},
//                {1, 1, 1, 1}
//        };

//        int arr[][] = {
//                {1, 1, 0, 1},
//        };

        int arr[][] = {
                {1},
                {1},
                {0},
                {1}
        };

        int r = arr.length; // Number of rows
        int c = arr[0].length; // Number of columns

        // Calculate the heights of each column
        for (int i = 0; i < c; i++) {
            for (int j = 1; j < r; j++) {
                if (arr[j][i] != 0) {
                    arr[j][i] += arr[j - 1][i]; // Accumulate the height if the current element is 1
                }
            }
        }

        // Print the modified matrix
        for (int[] row : arr) {
            for (int col : row) {
                System.out.printf(col + " ");
            }
            System.out.println();
        }

        int maxArea = Integer.MIN_VALUE; // Variable to store the maximum area
        // Calculate the largest area for each row and update the maxArea
        for (int i = 0; i < r; i++) {
            int res = calculateLargestArea(arr[i], arr[i].length); // Calculate the largest area for the current row
            maxArea = Math.max(res, maxArea); // Update the maxArea if necessary
        }

        System.out.println("MaxArea Rectangle is " + maxArea);
    }
}
