package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int sum = 15;
        int[] arr = new int[]{-13, 0 ,6, 15, 16, 2, 15 ,-12, 17, -16, 0 ,-3 ,19, -3, 2, -9, -6};
        int b = longestSubArrayWithGivenSum(arr,arr.length,sum);
        System.out.println("Length of Subarray with sum "+sum+" is "+b);
    }

    public static int longestSubArrayWithGivenSum(int[] arr, int n, int k) {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {

            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {

                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }

}
