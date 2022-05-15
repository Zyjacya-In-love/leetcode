package t209;

/**
 * 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * @author xzq
 * @create 2022-05-15-15:12
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        int ansLen = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                ansLen = Math.min(ansLen, right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ansLen == Integer.MAX_VALUE ? 0 : ansLen;
    }
}
// 通过   59 ms	41.8 MB

