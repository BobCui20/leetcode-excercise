package info.codingcat.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval i = new InsertInterval();
        int[][] intervals = {{2,5}, {6,7}, {8,9}};
        int[] newInterval = {0,1};
        System.out.println(Arrays.deepToString(i.insert(intervals, newInterval)));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]){
                // new interval inserted or (no overlap and new interval not reached)
                result.add(interval);
            }
            else if (interval[0] > newInterval[1]){
                //no overlap and new interval already reached and need to be inserted
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            } else if (interval[0] >= newInterval[0] && interval[1] <= newInterval[1]) {
                // new interval greater than old, ignore old
                continue;
            } else if (interval[0] <= newInterval[0] && interval[1] >= newInterval[1]) {
                // new interval smaller than old, ignore new interval
                return intervals;
            } else if (interval[0] <= newInterval[1] && interval[1] >= newInterval[1]) {
                // left overlap
                newInterval[1] = interval[1];
            } else if (interval[1] >= newInterval[0] && interval[1] <= newInterval[1]) {
                // right overlap
                newInterval[0] = interval[0];
            }
        }
        if(newInterval != null) {
            // interval not yet inserted
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }

}