package Hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArraySumZero {
    public static void main(String[] args) {
        int[] arr = {-3,4,-3,-1,1};
        boolean b = subarraySum0(arr, arr.length);
        System.out.println(b);
        int sum = 14;
        arr = new int[]{5,8,11,14};
        b = subArrayWithGivenSum(arr,arr.length,sum);
        System.out.println("Subarray with sum "+sum+" is "+b);
    }

    private static boolean subArrayWithGivenSum(int[] arr, int n, int sum) {
        Set<Integer> set = new HashSet<>();
        int s=0;
        for (int i = 0; i < n; i++) {
            s += arr[i];
            if(s==sum||set.contains(s-sum)){
                return true;
            }
            if(!set.contains(s)){
                set.add(s);
            }
        }
        return false;
    }

    private static boolean subarraySum0(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum==0||set.contains(sum)){
                return true;
            } else {
                set.add(sum);
            }
        }
        return false;
    }
}
