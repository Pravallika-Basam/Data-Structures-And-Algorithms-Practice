package Searching;

public class FindSquareRoot {
    public static void main(String[] args) {
        long n=1;
        long root = findSquareRoot(n);
        System.out.println("Root is "+root);
    }

    private static long findSquareRoot(long n) {
        long s=1,e=n;
        while (s<=e){
            long mid = (s + e) / 2;
            if(mid*mid==n){
                return mid;
            } else if(mid*mid>n){
                e=mid-1;
            } else {
                s=mid+1;
            }
        }
        return e;
    }
}
