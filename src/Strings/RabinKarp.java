package Strings;

public class RabinKarp {
    static final int d = 251;
    static final int q = 103;

    public static void main(String[] args) {
        String s = "aaaaaab";
        String p = "aac";
        rabinKarpPatternMatching(s,p,s.length(),p.length());
    }

    private static void rabinKarpPatternMatching(String str, String pat, int n, int m) {

        // Precompute dm (d^(m-1) % q)
        int dm = 1;
        for (int i = 0; i < m - 1; i++) {
            dm = (dm * d) % q;
        }

        int s = 0; // Hash value for the sliding window in the text
        int p = 0; // Hash value for the pattern

        // Compute the initial hash values for the sliding window and the pattern
        for (int i = 0; i < m; i++) {
            s = (s * d + str.charAt(i)) % q;
            p = (p * d + pat.charAt(i)) % q;
        }

        System.out.println("Pattern hash is " + p);

        // Iterate through each possible position of the sliding window
        for (int i = 0; i <= n - m; i++) {
            // If the hash values match, perform an additional character-by-character comparison
            if (s == p) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (str.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("Pattern found at " + i);
                }
            }

            // Recompute the hash value for the next sliding window position
            // and to make sure we don't go out of bound after calculating for last window
            if (i < n - m) {
                // Remove the leftmost character from the previous sliding window and add the rightmost character
                // to the current sliding window to compute the new hash value
                s = ((s - (str.charAt(i) * dm)) * d + str.charAt(i + m)) % q;
            }

            // Ensure that the hash value is positive
            if (s < 0) {
                s = s + q;
            }

            System.out.println("Str hash is " + s);
        }
    }

}
