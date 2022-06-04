package t56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/
 * @author xzq
 * @create 2022-06-04-15:45
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][0];
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
            }
            end = Math.max(end, intervals[i][1]);
        }
        res.add(new int[]{start, end});
//        int[][] ans = new int[res.size()][2];
//        for (int i = 0; i < res.size(); i++) {
//            ans[i][0] = res.get(i)[0];
//            ans[i][1] = res.get(i)[1];
//        }
//        return ans;
        return res.toArray(new int[res.size()][]);
    }
}
// 通过   9 ms	46.5 MB