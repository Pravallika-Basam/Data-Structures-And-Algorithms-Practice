package Strings;

public class AnagramSearch {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String p = "frog";
        boolean b= checkForAnagramPattern(s,p,s.length(),p.length());
        System.out.println( b);
    }

    private static boolean checkForAnagramPattern(String s, String p, int n, int m) {
        int[] str = new int[26];
        int[] pat = new int[26];
        for (int i = 0; i < m; i++) {
            int pos1 = s.charAt(i) % 97;
            int pos2 = p.charAt(i) % 97;
            str[pos1]++;
            pat[pos2]++;
        }
        for (int i = 0; i < n-m; i++) {
            System.out.println(s.charAt(i));
            if(areSame(str,pat)){
                return true;
            } else {
                if(i<n-m) {
                    int pos1 = s.charAt(i) % 97;
                    int pos2 = s.charAt(i+m) % 97;
                    str[pos1]--;
                    str[pos2]++;
                }
            }

        }
        return false;
    }

    private static boolean areSame(int[] str, int[] pat) {
        for (int i = 0; i < str.length; i++) {
            System.out.printf(str[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < str.length; i++) {
            System.out.printf(pat[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < str.length; i++) {
            if(str[i]!=pat[i]){
                return false;
            }
        }
        return true;
    }
}
