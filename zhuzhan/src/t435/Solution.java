package t435;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * https://leetcode.cn/problems/non-overlapping-intervals/
 * @author xzq
 * @create 2022-05-13-14:14
 */
//class Solution {
//    public int eraseOverlapIntervals(int[][] intervals) {
//        Arrays.sort(intervals, (a, b) -> {
//            return a[1]-b[1];
//        });
//        int cnt = 0;
//        int lastEnd = Integer.MIN_VALUE;
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][0] >= lastEnd) {
//                cnt++;
//                lastEnd = intervals[i][1];
//            }
//        }
//        return intervals.length-cnt;
//    }
//}
// 通过   48 ms	97.8 MB


/*
 * @create 2022-06-04-14:45
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int lastRight = intervals[0][1];
        int maxNonOverlappingIntervals = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastRight) {
                maxNonOverlappingIntervals++;
                lastRight = intervals[i][1];
            }
        }
        return n - maxNonOverlappingIntervals;
    }
}
// 通过   49 ms	97.9 MB