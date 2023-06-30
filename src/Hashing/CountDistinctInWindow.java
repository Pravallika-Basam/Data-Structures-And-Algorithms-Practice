package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctInWindow {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int window = 3;
        countDistinct(arr,arr.length,window);
    }

    private static void countDistinct(int[] arr, int n,int k) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            insertIntoMap(arr[i], map);
        }
       // map.forEach((a,b)-> System.out.println(a+" : "+b));
        //System.out.printf(map.size()+" ");
        list.add(map.size());
        for (int i = k; i < n; i++) {
            if (map.containsKey(arr[i-k])){
                if(map.get(arr[i-k])==1) {
                    map.remove(arr[i - k]);
                } else {
                    map.put(arr[i-k],map.get(arr[i-k])-1);
                }
            }
            insertIntoMap(arr[i],map);
            //map.forEach((a,b)-> System.out.println(a+" : "+b));
            //System.out.println();
            list.add(map.size());
            //System.out.printf(map.size()+" ");
        }
    }

    private static void insertIntoMap(int ele, HashMap<Integer, Integer> map) {
        if (map.containsKey(ele)){
            map.put(ele, map.get(ele)+1);
        } else {
            map.put(ele,1);
        }
    }

}
