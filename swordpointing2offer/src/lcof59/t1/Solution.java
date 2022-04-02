package lcof59.t1;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * @author xzq
 * @create 2022-04-01-21:11
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] preMax = new int[n];
        int[] sufMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                preMax[i] = nums[i];
            } else {
                preMax[i] = Math.max(nums[i], preMax[i-1]);
            }
        }
        sufMax[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            if ((i+1) % k == 0) {
                sufMax[i] = nums[i];
            } else {
                sufMax[i] = Math.max(nums[i], sufMax[i+1]);
            }
        }
        int[] ans = new int[n-k+1];
        for (int i = 0; i < n-k+1; i++) {
            ans[i] = Math.max(preMax[i+k-1], sufMax[i]);
        }
        return ans;
    }
}
