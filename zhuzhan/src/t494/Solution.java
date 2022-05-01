package t494;

import java.util.Arrays;

/**
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 * @author xzq
 * @create 2022-05-01-20:39
 */
//class Solution {
//    public int findTargetSumWays(int[] nums, int target) {
//        int n = nums.length;
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        int sumA = (target+sum);
//        // sumA 是 nums 中+的集合，0 <= nums[i]，所以 sumA 也必须是非负整数
//        if (sumA < 0 || (sumA&1) == 1) {
//            return 0;
//        }
//        sumA /= 2;
//        int[][] dp = new int[n+1][sumA+1];
//        // 因为 nums[i] 可能等于0，所以，dp[1...][0] 不一定等于 1，
//        // 只有 dp[0][0] 一定是 1，因为它没有元素可以选，和只能为0，所以 1 种方案，
//        // 而nums[i]可能为0，选或者不选和都为0，则有两种方案
//        dp[0][0] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= sumA; j++) {
//                if (j >= nums[i-1]) {
//                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
//                } else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[n][sumA];
//    }
//}
// 通过   3 ms	41.3 MB

// 滚动数组优化空间
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sumA = (target+sum);
        // sumA 是 nums 中+的集合，0 <= nums[i]，所以 sumA 也必须是非负整数
        if (sumA < 0 || (sumA&1) == 1) {
            return 0;
        }
        sumA /= 2;
        int[] dp = new int[sumA+1];
        // 因为 nums[i] 可能等于0，所以，dp[1...][0] 不一定等于 1，
        // 只有 dp[0][0] 一定是 1，因为它没有元素可以选，和只能为0，所以 1 种方案，
        // 而nums[i]可能为0，选或者不选和都为0，则有两种方案
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = sumA; j >= 0; j--) {
                if (j >= nums[i-1]) {
                    dp[j] = dp[j] + dp[j-nums[i-1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[sumA];
    }
}
// 通过   3 ms	38.9 MB