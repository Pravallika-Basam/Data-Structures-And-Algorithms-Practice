package Sorting;

public class FindIntersectionsInSortedArray {
    public static void main(String[] args) {
        int[] a = {3,5,8};
        int[] b={2,8,9,10,15};
        findIntersection(a,b,a.length,b.length);
        unionOfTwoSortedArrays(a,b,a.length,b.length);
    }

    private static  void unionOfTwoSortedArrays(int[] a, int[] b, int n1, int n2) {
        System.out.println();
        int i=0,j=0;
        while (i<n1&&j<n2){
            if(a[i]==b[j]){
                System.out.printf(a[i]+" ");
                i++;
                j++;
            } else if (a[i]<b[j]) {
                System.out.printf(a[i]+" ");
                i++;
            } else {
                System.out.printf(b[j]+" ");
                j++;
            }
        }
        while (i<n1){
            System.out.printf(a[i]+" ");
            i++;
        }
        while (j<n2){
            System.out.printf(b[j]+" ");
            j++;
        }
        System.out.println();
    }

    private static void findIntersection(int[] a, int[] b, int n1, int n2) {
        int i=0,j=0,lst=Integer.MIN_VALUE;
        while (i<n1&&j<n2){
            if(a[i]==b[j]){
                if(a[i]!=lst){
                    lst=a[i];
                    System.out.printf(a[i]+" ");
                }
                i++;
                j++;
            } else if (a[i]<b[j]) {
                i++;
            } else {
                j++;
            }
        }
    }
}
