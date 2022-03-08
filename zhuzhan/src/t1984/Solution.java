package t1984;

import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 * @author xzq
 * @create 2022-03-08-10:19
 */
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i+k-1 < n; i++) {
            int j = i+k-1;
            ans = Math.min(ans, nums[j]-nums[i]);
        }
        return ans;
    }
}
