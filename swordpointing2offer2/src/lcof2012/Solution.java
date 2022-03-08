package lcof2012;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * https://leetcode-cn.com/problems/tvdfij/
 * @author xzq
 * @create 2022-03-08-9:24
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for (int i = 1; i < n + 1; ++i) {
            if (sum[i-1]-sum[0] == sum[n]-sum[i]) return i-1;
        }
        return -1;
    }
}
