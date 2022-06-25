package t377;

import java.util.Arrays;

/**
 * 377. 组合总和 Ⅳ
 * https://leetcode.cn/problems/combination-sum-iv/
 * @author xzq
 * @create 2022-06-12-13:53
 */
//class Solution {
//    public int combinationSum4(int[] nums, int target) {
//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        for (int i = 0; i <= target; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (i >= nums[j]) {
//                    dp[i] += dp[i - nums[j]];
//                }
//            }
//        }
//        return dp[target];
//    }
//}


/*
 * @create 2022-06-24-23:39
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
// 通过   1 ms	38.8 MB