package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr= {6,4,3,9,1,9,6,5,4,3 };
        int n = arr.length;
        insertionSort(arr,n);
    }

    private static void insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while (j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        for (int i : arr) {
            System.out.printf(i+" ");
        }
    }
}
