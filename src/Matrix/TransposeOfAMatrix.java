package Matrix;

public class TransposeOfAMatrix {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3,4},
                {5, 6, 7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        transpose(arr);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf(anInt+" ");
            }
            System.out.println();
        }
    }

    private static void transpose(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr[i].length ; j++) {
                swapDigits(arr,i,j);
            }
        }
    }

    private static void swapDigits(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}
