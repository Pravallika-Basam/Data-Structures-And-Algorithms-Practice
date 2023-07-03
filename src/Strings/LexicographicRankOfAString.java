package Strings;

public class LexicographicRankOfAString {
    public static void main(String[] args) {
        String s = "cba";
        int n = s.length();
        int rank = getLexicographicRank(s,n);
        System.out.println("Rank is "+rank);
    }

    private static int getLexicographicRank(String s, int n) {
        int[] arr = new int[26]; // Array to store the count of each character in the string
        for (int i = 0; i < n; i++) {
            int pos = s.charAt(i) % 97; // Calculate the position of the character in the array
            arr[pos]++; // Increment the count of the character
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1]; // Update the counts to represent the cumulative count of characters in whole string
        }

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i; // Calculate the factorial of n
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            fact = fact / (n - i); // Update the factorial value
            // (ex : "BAC" 3! is 6. But after fixing the first char
            // we only have 2 possible permutations so 2! and we can obtain this from the fact by diving it by 3 and so on.
            int pos = s.charAt(i) % 97; // Get the position of the current character
            if (pos > 0) {
                ans += (fact * arr[pos - 1]); // Add the count of smaller characters multiplied by the factorial
            }
            for (int j = pos; j < arr.length; j++) {
                arr[j]--;// After processing the current character, we need to update the arr array to consider
                // the remaining characters to the right of the current character. We want the count of smaller characters
                // to reflect only the characters to the right, excluding the characters we have already processed.
                // By decrementing arr[j] for j greater than or equal to pos, we remove the count of characters
                // that have already been processed (characters with positions less than pos).
                // This adjustment ensures that the remaining count in arr corresponds only to
                // the characters to the right of the current character.
            }
        }

        return ans + 1; // Return the lexicographic rank
    }

}
