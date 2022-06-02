package t376;

/**
 * 376. 摆动序列
 * https://leetcode.cn/problems/wiggle-subsequence/
 * @author xzq
 * @create 2022-06-02-22:37
 */
//      动态规划，dp[i][0] 以i结尾，并且i作为 峰 的最长子序列，dp[i][1] 以i结尾，并且i作为 谷 的最长子序列
//              虽然是以 i 结尾，但其实最后一个元素和上一个 峰 或 谷 接上就是最大序列长度，所以直接返回最后元素的max即可
//class Solution {
//    public int wiggleMaxLength(int[] nums) {
//        int n = nums.length;
//        int[][] dp = new int[n][2];
//        dp[0][0] = dp[0][1] = 1;
//        int res = 1;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][0] = dp[i][1] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i][0] = Math.max(dp[i][0], dp[j][1]+1);
//                }
//            }
//            for (int j = 0; j < i; j++) {
//                if (nums[j] > nums[i]) {
//                    dp[i][1] = Math.max(dp[i][1], dp[j][0]+1);
//                }
//            }
//        }
//        return Math.max(dp[n-1][0], dp[n-1][1]);
//    }
//}
// 通过   4 ms	38.9 MB


//      贪心找 峰 和 谷，中间的过度节点都可以删除
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int preDiff = nums[1]-nums[0];
        int res = preDiff == 0 ? 1 : 2; // 即使相等也要算 1 个序列长度
        for (int i = 2; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - 1];
            // preDiff = 是为了一开始时可能有相等的元素，所以 preDiff= 是应该的
            if ((preDiff <= 0 && currDiff > 0) || (preDiff >= 0 && currDiff < 0)) {
                res++;
                // 因为 if preDiff=，所以如果把这行放if外面，可能序列中间会有 = 的情况，但=前后都是>或都是<，那就加错了，所以不能放外面
                preDiff = currDiff;
            }
        }
        return res;
    }
}
// 通过   0 ms	38.8 MB