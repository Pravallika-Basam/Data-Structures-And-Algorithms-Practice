package Matrix;

public class SearchInAColumnRowSortedArray {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3,4},
                {5, 6, 7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int key = 100;
        int[] ints = searchInArray(arr, key);
        System.out.println(ints[0]+" "+ints[1]);
    }

    private static int[] searchInArray(int[][] arr, int key) {
        int i = 0,j= arr[0].length-1;
        while (i< arr.length&&j>=0){
            if(arr[i][j]==key){
                return new int[]{i,j};
            }
            else if(arr[i][j]>key){
                j--;
            }
            else {
                i++;
            }
        }
        return new int[] {-1,-1};
    }
}
