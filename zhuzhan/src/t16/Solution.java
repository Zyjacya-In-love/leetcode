package t16;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author xzq
 * @create 2022-03-08-10:16
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int sub = 0x3f3f3f3f, ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int pb = i+1, pc = n-1;
            while(pb < pc) {
                int sum = nums[i] + nums[pb] + nums[pc];
                if(sub > Math.abs(sum-target)) {
                    sub = Math.abs(sum-target);
                    ans = sum;
                }
                if(sum == target) {
                    return target;
                } else if(sum < target) {
                    pb++;
                } else {
                    pc--;
                }
            }
        }
        return ans;
    }
}
