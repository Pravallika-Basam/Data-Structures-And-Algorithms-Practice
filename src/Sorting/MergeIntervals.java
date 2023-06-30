package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval implements Comparable<Interval> {
    int i, j;
    Interval(int i,  int j){
        this.i = i;
        this.j = j;
    }
    @Override
    public int compareTo(Interval o) {
        return this.i-o.i;
    }
}
public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals= new ArrayList<Interval>();
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(3,15));
        intervals.add(new Interval(18,30));
        intervals.add(new Interval(2,7));

        Collections.sort(intervals);

        for (Interval interval : intervals) {
            System.out.println(interval.i+" "+ interval.j);
        }

        int low= 0,n = intervals.size();
        for (int i = 1; i < n; i++) {
            if(intervals.get(i).i<=intervals.get(low).j){
                intervals.set(low,new Interval(intervals.get(low).i,Math.max(intervals.get(low).j,intervals.get(i).j)));
                System.out.println("After Swapping : "+intervals.get(low).i+" "+intervals.get(low).j);
            } else {
                low++;
                intervals.set(low,intervals.get(i));
            }
        }
        System.out.println("==========================================");
        for (int i = 0; i <= low; i++) {
            System.out.println(intervals.get(i).i+" "+ intervals.get(i).j);
        }
    }
}
