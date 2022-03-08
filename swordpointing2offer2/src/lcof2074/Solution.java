package lcof2074;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 剑指 Offer II 074. 合并区间
 * https://leetcode-cn.com/problems/SsGoHC/
 * @author xzq
 * @create 2022-03-08-9:56
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return (i1[0]==i2[0])?(i1[1]-i2[1]):(i1[0]-i2[0]);
            }
        });
        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        int idx = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.get(idx)[1]) {
                ans.get(idx)[1] = Math.max(ans.get(idx)[1], intervals[i][1]);
            }
            else {
                ans.add(intervals[i]);
                idx++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
