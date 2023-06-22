package Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortNonprimitiveComparator {
    public static void main(String[] args) {
        Integer[] arr = {5,20,10,3,12};
        Arrays.sort(arr,new MyComp());
        for (Integer integer : arr) {
            System.out.printf(integer+" ");
        }
    }

    private static class MyComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println(o1+" "+o2);
            return o1%2-o2%2;
        }
    }
}
