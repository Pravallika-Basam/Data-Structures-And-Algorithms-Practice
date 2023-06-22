package Searching;

public class FindAllOccurencesInSortedArray {
    public static void main(String[] args) {
        int[] arr = {20};
        int key = 20;
        int n = arr.length;
        int num = findAllOccurences(arr,n,key);
        System.out.println("Total Occurences is "+num);
    }

    private static int findAllOccurences(int[] arr, int n, int key) {
        int start = findFirstOccurence(arr,n,key);
        System.out.println("First is "+start);
        if(start==-1){
            return 0;
        }
        int end = findLastOccurence(arr,n,key);
        System.out.println("End is "+end);
        return end-start+1;
    }

    private static int findFirstOccurence(int[] arr, int n, int key) {
        int s=0,e=n-1;
        while (s<=e){
            int mid = (s+e)/2;
            if(arr[mid]==key){
                if(mid==0||arr[mid-1]!=key){
                    return mid;
                } else {
                    e=mid-1;
                }
            } else if (arr[mid]>key) {
                e = mid-1;
            } else {
                s=mid+1;
            }
        }
        return -1;
    }

    private static int findLastOccurence(int[] arr, int n, int key) {
        int s=0,e=n-1;
        while (s<=e){
            int mid = (s+e)/2;
            if(arr[mid]==key){
                if(mid==(n-1)||arr[mid+1]!=key){
                    return mid;
                } else {
                    s=mid+1;
                }
            } else if (arr[mid]>key) {
                e= mid-1;
            } else {
                s=mid+1;
            }
        }
        return -1;
    }
}
