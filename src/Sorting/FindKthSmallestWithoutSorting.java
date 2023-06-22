package Sorting;

public class FindKthSmallestWithoutSorting {
    public static void main(String[] args) {
        int arr[] = { 2,5,8,11,3,6,9,7 };
        int ktSmallest = findKtSmallest(arr, 1, 0, arr.length - 1);
        System.out.println("Element is "+ktSmallest);
    }

    private static int findKtSmallest(int[] arr, int k, int low, int n) {
        int p = lomutoPartitioning(arr,low,n);
        if(p==(k-1)) {
            return arr[p];
        } else if (p>k-1) {
            return findKtSmallest(arr,k,low,p-1);
        } else {
            return findKtSmallest(arr,k,p+1,n);
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
}
