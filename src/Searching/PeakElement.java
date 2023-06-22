package Searching;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        //findPeakNaive(arr,arr.length);
        System.out.println(peakElement(arr,arr.length));
        System.out.println(peakElement2(arr, arr.length));
    }

    public static int peakElement(int[] arr,int n)
    {
        //add code here.
        int s = 0, e=n-1;
        while(s<=e){
            int mid = (s+e)/2;
            if((mid==0 || arr[mid]>=arr[mid-1]) && (mid==n-1|| arr[mid]>=arr[mid+1])){
                return arr[mid];
            }
            if(mid>0&&arr[mid]<=arr[mid-1]){
                e=mid-1;
            } else {
                s=mid+1;
            }
        }
        return -1;
    }

    public static int peakElement2(int[] arr,int n)
    {
        //add code here.
        int s = 0, e=n-1;
        while(s<=e){
            if(e-s==0){
                return s;
            }
            if(e-s==1){
                return arr[s]>=arr[e]?s:e;
            }
            int mid = (s+e)/2;
            if(arr[mid]>=arr[mid-1] && arr[mid]>=arr[mid+1]){
                return arr[mid];
            }
            if(arr[mid]<=arr[mid-1]){
                e=mid-1;
            } else {
                s=mid+1;
            }
        }
        return -1;
    }

    private static void findPeakNaive(int[] arr, int n) {
        if(n==1){
            System.out.println(arr[0]);
            return;
        }
        if(arr[0]>arr[1]){
            System.out.println(arr[0]);
        }
        for (int i = 1; i < n-1; i++) {
            if(arr[i]>=arr[i-1] && arr[i]>=arr[i+1]){
                System.out.println(arr[i]);
            }
        }
        if(arr[n-1]>arr[n-2]){
            System.out.println(arr[n-1]);
        }
    }
}
