package Searching;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        long[] arr = {3,1};
        long key = 1;
        int n = arr.length;
        long first = findElement(arr,n,key);
        System.out.println("Element is found at "+first);
    }

    private static int findElement(long[] arr, int n, long key) {
        int s=0,e=n-1;
        while (s<=e){
            int mid = (s+e)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[s]<=arr[mid]){ //left sorted
                if(arr[s]<=key && arr[mid]>key){
                    e=mid-1;
                } else {
                    s=mid+1;
                }
            } else {
                if(arr[mid]<key&&arr[e]>=key){
                    s=mid+1;
                } else {
                    e= mid-1;
                }
            }
        }
        return -1;
    }
}
