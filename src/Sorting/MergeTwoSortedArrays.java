package Sorting;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1= {6,9,11};
        int[] arr2= {3,7,7};
        int n1 = arr1.length;
        int n2= arr2.length;
        margeTwoSortedArraysInPlce(arr1,arr2,n1,n2);
    }

    private static void margeTwoSortedArraysInPlce(int[] arr1, int[] arr2, int n1, int n2) {
        int temp1=0,temp2=0;
        while (temp1<n1&&temp2<n2){
            if(arr1[temp1]<=arr2[temp2]) {
                System.out.println(arr1[temp1]);
                temp1++;
            } else {
                System.out.println(arr2[temp2]);
                temp2++;
            }
        }
        while (temp1<n1){
            System.out.println(arr1[temp1]);
            temp1++;
        }
        while (temp2<n2){
            System.out.println(arr2[temp2]);
            temp2++;
        }


    }

}
