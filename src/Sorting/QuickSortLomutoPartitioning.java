package Sorting;

public class QuickSortLomutoPartitioning {
    public static void main(String[] args) {
        int arr[] = { 2,5,8,11,3,6,9,7 };
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.printf(i+" ");
        }
    }

    public static int lomutoPartitioning(int[] arr, int l, int n) {
        int pivot = n;
        int window = l-1;
        for (int i = l; i <n; i++) {
            if(arr[i]<arr[pivot]){
                window++;
                int temp = arr[i];
                arr[i] = arr[window];
                arr[window]=temp;
            }
        }
        window++;
        int temp = arr[window];
        arr[window] = arr[pivot];
        arr[pivot]=temp;
        return window;
    }
    private static void quickSort(int[] arr, int low, int n) {
        if(low<n){
            int part = lomutoPartitioning(arr, low, n);
            System.out.println("Window is "+part);
            quickSort(arr,low,part-1);
            quickSort(arr,part+1,n);
        }
    }
}
