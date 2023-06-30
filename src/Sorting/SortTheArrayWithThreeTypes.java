package Sorting;

public class SortTheArrayWithThreeTypes {
    public static void main(String[] args) {
        int[] arr = {0,1,1,2,0,1,0,2,1};
        segregateArrayThreeTypes(arr,arr.length);
        for (int i : arr) {
            System.out.printf(i+" ");
        }
    }

    private static void segregateArrayThreeTypes(int[] arr, int n) {
         int low = 0;
         int high = n-1;
         int i=0;
         while (i<=high){
             if(arr[i]==0){
                 System.out.println(arr[i]+" is 0 swapping "+arr[i]+" "+arr[low]);
                 swapDigits(arr,i,low);
                 low++;
                 i++;
             } else if(arr[i]==2){
                 System.out.println(arr[i]+" is 2 swapping "+arr[i]+" "+arr[high]);
                 swapDigits(arr,i,high);
                 high--;
             } else {
                 System.out.println(arr[i]+" is 1");
                 i++;
             }
         }
    }
    private static void swapDigits(int[] arr, int i, int low) {
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
    }
}
