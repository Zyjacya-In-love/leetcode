package lcof57.t2;

import java.util.ArrayList;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @author xzq
 * @create 2022-03-29-14:02
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        int l = 1, r = 2, sum = 1;
        ArrayList<int[]> ans = new ArrayList<>();
        int limit = (target-1)/2;
        while (l < r && l <= limit) {
            if (sum == target) {
                int[] tmp = new int[r-l];
                for (int i = 0; i < r-l; i++) {
                    tmp[i] = l+i;
                }
                ans.add(tmp);
                if (r - l == 2) {
                    break;
                }
                sum += r;
                r++;
            } else if (sum < target) {
                sum += r;
                r++;
            } else {
                sum -= l;
                l++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
