package lcof42;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author xzq
 * @create 2022-03-14-21:11
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int nowMax = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nowMax = Math.max(nowMax+nums[i], nums[i]);
            ans = Math.max(ans, nowMax);
        }
        return ans;
    }
}
