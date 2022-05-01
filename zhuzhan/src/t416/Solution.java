package t416;

import java.util.TreeMap;

/**
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @author xzq
 * @create 2022-05-01-18:37
 */
//class Solution {
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if ((sum&1) == 1) {
//            return false;
//        }
//        int n = nums.length;
//        int target = sum/2+1;
//        boolean[][] dp = new boolean[n+1][target];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = true;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j < target; j++) {
//                if (j >= nums[i-1]) {
//                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
//                } else {
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[n][target-1];
//    }
//}
// 通过   32 ms	42 MB

// 滚动数组优化空间
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum&1) == 1) {
            return false;
        }
        int n = nums.length;
        int target = sum/2+1;
        boolean[] dp = new boolean[target];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = target-1; j >= 1; j--) {
                if (j >= nums[i-1]) {
                    dp[j] = dp[j] || dp[j-nums[i-1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[target-1];
    }
}
// 通过   27 ms	39.7 MB