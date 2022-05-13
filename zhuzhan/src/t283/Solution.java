package t283;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/
 * @author xzq
 * @create 2022-05-13-9:21
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int fast = 0;
        int slow = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < n) {
            nums[slow] = 0;
            slow++;
        }
    }
}
// 通过   1 ms	42.7 MB