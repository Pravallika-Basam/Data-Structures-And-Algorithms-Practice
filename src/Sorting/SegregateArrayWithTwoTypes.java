package Sorting;

public class SegregateArrayWithTwoTypes {
    public static void main(String[] args) {
        int[] arr = {15,-3,-2,18,-5,50,-12};
        segregateArray(arr,arr.length);
        for (int i : arr) {
            System.out.printf(i+" ");
        }
    }

    private static void segregateArray(int[] arr, int n) {
        int low = 0;
        int high = n-1;
        int i =0;
        while (low<=high){
            if(arr[i]<0){
                System.out.println(arr[i]+" is negative swapping "+arr[i]+" "+arr[low]);
                swapDigits(arr,i,low);
                low++;
                i++;
            } else {
                System.out.println(arr[i]+" is positive swapping "+arr[i]+" "+arr[high]);
                swapDigits(arr,i,high);
                high--;
            }
        }
    }

    private static void swapDigits(int[] arr, int i, int low) {
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }
}
