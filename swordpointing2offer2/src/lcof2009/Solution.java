package lcof2009;

/**
 * 剑指 Offer II 009. 乘积小于 K 的子数组
 * https://leetcode-cn.com/problems/ZVAVXX/
 * @author xzq
 * @create 2022-03-08-9:21
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0;
        int n = nums.length;
        int mul = 1, ans = 0;
        while (end < n) {
            mul *= nums[end];
            while (start <= end && mul >= k) {
                mul /= nums[start];
                start++;
            }
            ans += (end-start+1);
            end++;
        }
        return ans;
    }
}
