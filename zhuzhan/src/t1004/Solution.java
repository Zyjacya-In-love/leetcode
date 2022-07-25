package t1004;

/**
 * @title 1004. 最大连续1的个数 III
 * @link https://leetcode.cn/problems/max-consecutive-ones-iii/
 * @from yongyou7.25
 * @author xzq
 * @create 2022-07-25-20:44
 */
// 滑动窗口
// 求出 nums 中 0 的数量的前缀和，可以快速得到某一个区间 0 的数量，
// 那么 只要 窗口 中 0 的数量 小于等于 k 即可，目标即是求出窗口的最大长度
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, sum = 0;
        int ans = 0;
        while (r < n) {
            sum += (1-nums[r]); // 失误 1. 次：sum 是 [l,r] 中 0 的数量，不是 1 的，必须 (1-nums[r])
            while (sum > k) {
                sum -= (1-nums[l]); // 失误 2. 次：sum 是 [l,r] 中 0 的数量，不是 1 的，必须 (1-nums[l])
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}
// 通过   3 ms	42.9 MB