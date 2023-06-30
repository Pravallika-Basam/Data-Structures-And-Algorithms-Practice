package Matrix;

public class RotateMatrcixAntiCloclWise90 {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3,4},
                {5, 6, 7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        transform90Clock(arr,arr.length);
//        for (int[] ints : arr) {
//            for (int anInt : ints) {
//                System.out.printf(anInt+" ");
//            }
//            System.out.println();
//        }
    }

    private static void transform90Clock(int[][] arr,int n) {
        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j < n; j++) {
                System.out.printf(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
}
