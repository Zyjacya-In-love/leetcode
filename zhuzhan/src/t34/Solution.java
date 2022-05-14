package t34;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author xzq
 * @create 2022-05-14-9:14
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        int right = upperBound(nums, target);
        return right - left == 0 ? new int[]{-1, -1} : new int[]{left, right-1};
    }

    private int upperBound(int[] nums, int target) {
        int s = 0, t = nums.length;
        while (s < t) {
            int m = ((s + t) >> 1);
            if (nums[m] > target) {
                t = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    private int lowerBound(int[] nums, int target) {
        int s = 0, t = nums.length;
        while (s < t) {
            int m = ((s + t) >> 1);
            if (nums[m] >= target) {
                t = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
}
// 通过   0 ms	44.8 MB