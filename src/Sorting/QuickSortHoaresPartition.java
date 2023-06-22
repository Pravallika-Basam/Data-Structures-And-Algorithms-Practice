package Sorting;

public class QuickSortHoaresPartition {
    public static void main(String[] args) {
        int arr[] = { 2,5,8,11,3,6,9,7 };
        quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.printf(i+" ");
        }
    }
    public static int hoaresPartition(int[] arr, int l, int n) {
        int pivot = arr[l];
        int i=l-1,j=n+1; 
        while (true){
            do{
                i++;
            } while (arr[i]<pivot);

            do{
                j--;
            } while (arr[j]>pivot);

            if(i>=j){
                System.out.println("The partition point is "+j);
                return j;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j]=temp;
        }
    }
    static void quickSort(int[] arr,int l, int n){
        if(l<n){
            int part = hoaresPartition(arr, l, n);
            quickSort(arr,l,part); //Why part and part+1 and not part-1 and part??
            // Because if you dry run with any example, there will be a case where all the elements >= pivot
            // are alreaady in the rigt and there is no swap, in this case part will be 0 and
            // if we use part - 1 we are removing one branch of the tree and the second branch will never update as
            // it will be the same as the previous call. To understand better try solving an example
            quickSort(arr,part+1,n);

        }
    }
}
