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
//class Solution {
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int dp = nums[0];
//        int ans = nums[0];
//        for (int i = 1; i < n; i++) {
//            dp = Math.max(dp+nums[i], nums[i]);
//            ans = Math.max(ans, dp);
//        }
//        return ans;
//    }
//}


/*
 * @create 2022-06-02-21:57
 */
//      dp
//class Solution {
//    public int maxSubArray(int[] nums) {
//        int currMaxSum = nums[0];
//        int allMaxSum = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            currMaxSum = Math.max(currMaxSum+nums[i], nums[i]);
//            allMaxSum = Math.max(allMaxSum, currMaxSum);
//        }
//        return allMaxSum;
//    }
//}
// 通过   1 ms	50.3 MB

//      贪心，贪心的加，并每次记录 最大值 res，直到 sum 加到 小于 0，置为 0 继续加，因为小于 0 不会对后面有增益
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > res) {
                res = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return res;
    }
}
// 通过   1 ms	50 MB