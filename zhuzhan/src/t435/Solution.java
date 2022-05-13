package t435;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * https://leetcode.cn/problems/non-overlapping-intervals/
 * @author xzq
 * @create 2022-05-13-14:14
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1]-b[1];
        });
        int cnt = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) {
                cnt++;
                lastEnd = intervals[i][1];
            }
        }
        return intervals.length-cnt;
    }
}
// 通过   48 ms	97.8 MB