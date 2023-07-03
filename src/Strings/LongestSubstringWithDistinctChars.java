package Strings;

import java.util.Arrays;

public class LongestSubstringWithDistinctChars {
    public static void main(String[] args) {
        String s = "aaabaaabc";
        int len = findLongestSubstringWithDistinctChars(s,s.length());
        System.out.println(len);
    }

    private static int findLongestSubstringWithDistinctChars(String s, int n) {
        // Initialize an array to store the last occurrence index of each character
        int[] arr = new int[256];
        // Initialize the array with -1 to indicate that no character has occurred yet
        Arrays.fill(arr, -1);

        // Initialize variables to keep track of the current substring length, start index, and maximum length
        int len = 1;
        int start = 0;
        int maxLen = 1;

        // Iterate over the string starting from the second character
        // Here i is considered end of every substring. So technically the substring is from start to i;
        for (int i = 1; i < n; i++) {
            // Update the start index to be the maximum of the current start index
            // and the next index of the character that was last encountered.
            // Note that start will only change when we encounter a character that was already encountered before.
            start = Math.max(start, arr[s.charAt(i)] + 1);

            // Calculate the length of the current substring
            len = i - start + 1;

            // Update the maximum length if the current length is greater
            maxLen = Math.max(len, maxLen);

            // Store the current index as the last occurrence of the character so that when we encounter again we can update the start.
            arr[s.charAt(i)] = i;
        }

        // Return the maximum length of a substring with distinct characters
        return maxLen;
    }

}
