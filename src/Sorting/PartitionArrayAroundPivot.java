package Sorting;

public class PartitionArrayAroundPivot {
    public static void main(String[] args) {
        int arr[] = { 2,5,8,11,3,6,9,7 };
        int pivot = arr.length-1; //In lomuto the piot is always the last
        lomutoPartitioning(arr,pivot,arr.length-1);
        for (int i : arr) {
            System.out.printf(i+" ");
        }
        System.out.println();
        int arr1[] = { 5,3,8,4,2,7,1,10};
        HoaresPartition(arr1,arr1.length);
        for (int i : arr1) {
            System.out.printf(i+" ");
        }
    }

    public static void HoaresPartition(int[] arr, int n) {
        int pivot = arr[0];
        int i=-1,j=n;
        while (true){
            do{
                i++;
            } while (arr[i]<pivot);

            do{
                j--;
            } while (arr[j]>pivot);

            if(i>=j){
                System.out.println("The partition point is "+j);
                return;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j]=temp;
        }
    }


    public static void lomutoPartitioning(int[] arr, int pivot, int n) {
        if(pivot!=(n-1)){
            int temp = arr[pivot];
            arr[pivot] = arr[n-1];
            arr[n-1]=temp;
        }
        pivot = n;
        int window = -1;
        for (int i = 0; i <= n-1; i++) {
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
    }
}
