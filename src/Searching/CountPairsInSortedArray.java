package Searching;

public class CountPairsInSortedArray {
    public static void main(String[] args) {
        int arr[]= {1 ,2 ,3, 4 ,5, 6, 7};
        int sum = 8;
        System.out.println(countPair(arr,arr.length,sum));;
    }
    static int  countPair(int arr[], int n, int sum)
    {
        // Complete the function
        int count=0;
        int s= 0 ,e=n-1;
        while (s<e){
            if(arr[s]+arr[e]==sum){
                System.out.println("pair is "+arr[s]+" "+arr[e]);
                count++;
                s++;
                e--;
            } else if(arr[s]+arr[e]>sum){
                e--;
            } else {
                s++;
            }
        }
        return count;
    }
}
