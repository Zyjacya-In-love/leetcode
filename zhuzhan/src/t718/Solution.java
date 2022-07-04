package t718;

/**
 * 718. 最长重复子数组
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 * @author xzq
 * @create 2022-07-04-20:50
 */
// 定义：dp[i][j] 以 nums1[i] 和 nums2[j] 结尾 的 两个数组中 公共的 、长度最长的子数组的长度
// 状态转移：if(nums1[i]==nums2[j]) dp[i][j] = dp[i-1][j-1]+1
// 初始化：dp[i][j] = 0，
// 遍历顺序：每次更新 依赖于 左上角的 元素，所以 正序 nums1 再 正序 nums2
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        int res = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
// 通过   32 ms	50.2 MB