package info.codingcat.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 4, 8 } };
        System.out.println(Arrays.deepToString(m.merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);
        List<int[]> resultList = new ArrayList<>();
        int[] previous = null;
        for (int[] interval : intervals) {
            if (previous == null) {
                previous = interval;
                continue;
            }

            if (previous[1] >= interval[0]) {
                previous[1] = Integer.max(interval[1], previous[1]);
                continue;
            } else {
                resultList.add(previous);
                previous = interval;
            }
        }

        if (previous != null) {
            resultList.add(previous);
        }
        return resultList.toArray(new int[resultList.size()][]);

    }

}