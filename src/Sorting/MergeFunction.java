package Sorting;

public class MergeFunction {
    public static void main(String[] args) {
        int arr[] = {5,10,6};
        int n = arr.length;
        int mid =  (n+1)/2;
        mergeSortedHalfs(arr,0,mid,n);
    }

    public static void mergeSortedHalfs(int[] arr, int start, int mid, int n) {
        int[] temp = new int[n];
        int i=0;
        int p1 = start;
        int p2 = mid;
        while (p1<mid&&p2<n){
            if(arr[p1]<=arr[p2]){
                temp[i] = arr[p1];
                p1++;
                i++;
            } else {
                temp[i] = arr[p2];
                p2++;
                i++;
            }
        }
        while (p1<mid){
            temp[i] = arr[p1];
            p1++;
            i++;
        }
        while (p2<n){
            temp[i] = arr[p2];
            p2++;
            i++;
        }
        for (int i1 : temp) {
            System.out.printf(i1+" ");
        }
    }
}
