package Strings;

public class KMPStringMatching {
    public static void main(String[] args) {
        String str = "aaaaaab";
        String pat = "aaaab";
        int[] lps = findLPS(pat);
        for (int lp : lps) {
            System.out.printf(lp+" ");
        }
        kmpStringMatching(str,pat,str.length(),pat.length(),lps);
    }

    private static void kmpStringMatching(String str, String pat, int n, int m, int[] lps) {
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
                j = lps[j - 1]; // Update j using the LPS array
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
    }


    static int[] findLPS(String str) {
        int[] lps = new int[str.length()];
        int n = str.length();
        for (int i = 1; i < n; i++) {
            if(str.charAt(i)==str.charAt(lps[i-1])){
                lps[i] = lps[i-1]+1;
            } else {
                int j = lps[i - 1];
                if(j==0){
                    lps[i] = str.charAt(i)==str.charAt(j)?1:0;
                } else {
                    while (j>=0){
                        if(str.charAt(j)==str.charAt(i)){
                            lps[i]=j+1;
                            break;
                        } else {
                            j--;
                        }
                    }
                }
            }
        }
        return lps;
    }
}
