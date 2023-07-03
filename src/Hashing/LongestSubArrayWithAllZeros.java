package Hashing;

public class LongestSubArrayWithAllZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,0,0,0,0,0,-1,0,1,0,0,0,0,0,1,0,0,1};
        int[] max = new int[arr.length];
        max[0] = arr[0]==0?1:0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==0){
                max[i]=max[i-1]+1;
                m = Math.max(m,max[i]);
            } else {
                max[i]=0;
            }
        }
        System.out.println("Max SubArray with all Zeros is "+m);
    }
}
