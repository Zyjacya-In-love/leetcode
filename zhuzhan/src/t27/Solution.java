package t27;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 * @author xzq
 * @create 2022-05-13-9:18
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int fast = 0;
        int slow = 0;
        while (fast < n) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
// 通过   0 ms	39.9 MB