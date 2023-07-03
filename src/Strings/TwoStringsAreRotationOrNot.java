package Strings;

import static Strings.KMPStringMatching.findLPS;

public class TwoStringsAreRotationOrNot {
    public static void main(String[] args) {
        String s = "ABAB";
        String p = "ABBA";
        s= s+s;
        System.out.println("New S is "+s);
        int[] lps = findLPS(p);
        boolean b = kmpStringMatching(s, p, s.length(), p.length(), lps);
        System.out.println("Are strings rotations ? "+b);
    }

    private static boolean kmpStringMatching(String str, String pat, int n, int m, int[] lps) {
        int i = 0; // Index for traversing the text
        int j = 0; // Index for traversing the pattern

        while (i < n) {
            // If characters at the current positions match, move both indices forward
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            // If the entire pattern has been matched, print the starting index
            if (j == m) {
                System.out.println("Pattern found at " + (i - j));
                return true;
            }

            // If there is a mismatch and the text index is still within bounds
            if (i < n && str.charAt(i) != pat.charAt(j)) {
                if (j == 0) {
                    i++; // Move to the next character in the text
                } else {
                    j = lps[j - 1]; // Update j using the LPS array
                }
            }
        }
        return false;
    }
}
