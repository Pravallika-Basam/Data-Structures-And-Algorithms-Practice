package Strings;

import java.util.Arrays;

public class LeftMostNonRepeatingChar {
    public static void main(String[] args) {
        String s = "ab                                                                                                                                                                                                                                                                                                                                     abc";
        int b =  leftMostNonRepeatingChar(s);
        System.out.println("First Non-repeating char is "+s.charAt(b));
    }

    private static int leftMostNonRepeatingChar(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i)%97;
            if(arr[pos]==-1){
                arr[pos]=i;
            } else {
                arr[pos]=-2;
            }
        }
        int min = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=0){
               if(min==-1){
                   min = arr[i];
               } else {
                   min = Math.min(min,arr[i]);
               }
            }
        }
        return min;
    }
}
