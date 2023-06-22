package Searching;

public class CountZerosInBinaryArray {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        int key = 0;
        int n = arr.length;
        int first = findFirstOccurence(arr,n,key);
        if(first==-1){
            System.out.println("Total Occurences is "+0);
            return;
        }
        System.out.println("Total Occurences is "+(n-first));
    }
    private static int findFirstOccurence(int[] arr, int n, int key) {
        int s=0,e=n-1;
        while (s<=e){
            int mid = (s+e)/2;
            if(arr[mid]==key){
                if(mid==0||arr[mid-1]!=key){
                    return mid;
                } else {
                    e=mid-1;
                }
            } else {
                s = mid+1;
            }
        }
        return -1;
    }
}
