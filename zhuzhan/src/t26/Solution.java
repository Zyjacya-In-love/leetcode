package t26;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * @author xzq
 * @create 2022-05-13-8:55
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[cnt-1]) continue;
            nums[cnt++] = nums[i];
        }
        return cnt;
    }
}
// 通过   0 ms	43.4 MB
