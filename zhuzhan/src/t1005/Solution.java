package t1005;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 * @author xzq
 * @create 2022-06-03-10:24
 */
//      贪心：排序，把前 k 个 负的最大的变成正数，
//          如果所有负数都变成正的了，k还有剩余，那么如果剩余k是奇数，将当前数组中最小的数变为负数
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int index = i%n;
            if (nums[index] < 0) {
                nums[index] = -nums[index];
            } else {
                if (((k-i)&1)==1) {
                    Arrays.sort(nums);
                    nums[0] = -nums[0];
                }
                break;
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
// 通过   2 ms	41 MB