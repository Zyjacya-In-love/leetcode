package t35;

/**
 * 35. 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/
 * @author xzq
 * @create 2022-05-14-9:02
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0, t = nums.length;
        while (s < t) {
            int m = ((s+t)>>1);
            if (nums[m] >= target) {
                t = m;
            } else {
                s = m+1;
            }
        }
        return s;
    }
}
// 通过   0 ms	41.2 MB