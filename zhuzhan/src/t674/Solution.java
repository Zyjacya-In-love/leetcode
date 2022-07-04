package t674;

import java.util.Arrays;

/**
 * 674. 最长连续递增序列
 * https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
 * @author xzq
 * @create 2022-07-04-20:37
 */
// 定义：dp[i] 以 nums[i] 为结尾的最长连续递增的子序列的长度
// 状态转移：if(nums[i]>nums[i-1]) dp[i] = dp[i-1]+1
// 初始化：dp[i] = 1，只要有元素，最长连续递增子序列的长度至少为 1
// 遍历顺序：正序遍历 nums
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1]+1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// 通过   3 ms	42.2 MB