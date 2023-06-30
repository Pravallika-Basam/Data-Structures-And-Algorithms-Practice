package Hashing;

import static Hashing.LongestSubArrayWithGivenSum.longestSubArrayWithGivenSum;

public class LongestCommonSubArrayWithSameSum {
    public static void main(String[] args) {
//        int[] a1 = {0,1,0,0,0,0};
//        int[] a2 = {1,0,1,0,0,1};

        int[] a1 = {0,0,0,1};
        int[] a2 = {1,1,1,1};
        int temp[] = new int[a1.length];
        for (int i = 0; i < a1.length; i++) {
            temp[i] = a1[i]-a2[i];
        }
        int len = longestSubArrayWithGivenSum(temp, temp.length, 0);
        System.out.println("Length of Longest Common SubArray is "+len);
    }
}
