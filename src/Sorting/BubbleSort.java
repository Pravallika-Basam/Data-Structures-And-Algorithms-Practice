package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6};
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean swap = false;
            for (int j = 1; j < n-i; j++) {
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
            if(!swap){
                break;
            }
        }
        for (int i : arr) {
            System.out.printf(i+" ");
        }
    }
}
