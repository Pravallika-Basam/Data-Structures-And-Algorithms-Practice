package Strings;

public class CheckStringSubsequence {
    //SUBSEQUENCE IN ANY ORDER
    public static void main(String[] args) {
        String s1 = "ABCDEFB";
        String s2 = "AEFB";
        boolean b = checkSubsequence(s1,s2);
        System.out.println("In any order "+b);
        b = checkSubsequenceInGivenOrder(s1,s2);
        System.out.println("In same order "+b);
    }

    //SUBSEQUENCE IN THE SAME ORDER AS OF GIVEN STR2
    private static boolean checkSubsequenceInGivenOrder(String s1, String s2) {
        int i=0,j=0;
        while (i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)) {
                j++;
            }
            i++;
        }
        return  j==s2.length();
    }

    //SUBSEQUENCE IN ANY ORDER
    private static boolean checkSubsequence(String s1, String s2) {
        int arr[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            int pos = s1.charAt(i)%65;
            arr[pos]++;
        }
        for (int i : arr) {
            System.out.printf(i+" ");
        }
        System.out.println();
        for (int i = 0; i < s2.length(); i++) {
            int pos = s2.charAt(i)%65;
            if(arr[pos]==0){
                return false;
            } else {
                arr[pos]--;
            }
        }
        return true;
    }

}
