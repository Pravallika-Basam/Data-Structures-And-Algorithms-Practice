package Strings;

public class PrinFreqOfCharsInSortedForm {
    public static void main(String[] args) {
        String s = "aabbccddee";
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int chr = (int) s.charAt(i) % 97;
            arr[chr]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0)
            System.out.println((char)(i+97) + " " + arr[i] );
        }
    }
}
