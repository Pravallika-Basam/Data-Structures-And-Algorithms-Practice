package Hashing;

import java.util.HashSet;

public class LongestConsecutieSubsequence {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        int count = longestConsecutiveSubsequence(arr);
        System.out.println(count);
    }

    private static int longestConsecutiveSubsequence(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        for (int i : arr) {
            set.add(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i]-1)){
                int curr = 1;
                while (set.contains(arr[i]+curr)){
                    curr++;
                }
                max= Math.max(max,curr);
            }
        }
        return max;
    }
}
