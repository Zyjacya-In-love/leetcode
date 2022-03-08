package lcof2008;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * https://leetcode-cn.com/problems/2VG8Kg/
 * @author xzq
 * @create 2022-03-08-9:21
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        int pre = 0;
        if (sum[n] < target) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if(sum[i]-sum[pre] < target) continue;
            while (sum[i]-sum[pre] >= target) pre++;
            pre--;
            ans = Math.min(ans, i-pre);
        }
        return ans;
    }
}
