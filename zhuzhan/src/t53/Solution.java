package t53;

/**
 * 53. 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author xzq
 * @create 2022-04-29-22:44
 */
//class Solution {
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        int ans = nums[0];
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
//            ans = Math.max(ans, dp[i]);
//        }
//        return ans;
//    }
//}
// 滚动数组优化空间
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            dp = Math.max(dp+nums[i], nums[i]);
            ans = Math.max(ans, dp);
        }
        return ans;
    }
}
