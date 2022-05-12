package t410;

/**
 * 410. 分割数组的最大值
 * https://leetcode.cn/problems/split-array-largest-sum/
 * @author xzq
 * @create 2022-05-12-22:41
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        int maxNum = Integer.MIN_VALUE;
        int sumNums = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            sumNums += num;
        }
        int s = maxNum, t = sumNums+1;
        while (s < t) {
            int mid = ((s+t)>>1);
            if (isOK(nums, mid, m)) {
                t = mid;
            } else {
                s = mid+1;
            }
        }
        return s;
    }

    private boolean isOK(int[] nums, int maxSum, int m) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                cnt++;
                sum = 0;
                i--;
            }
        }
        if (sum > 0) cnt++;
        return cnt <= m;
    }
}
// 通过   0 ms	38.7 MB