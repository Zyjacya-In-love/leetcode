package lcof2068;

/**
 * 剑指 Offer II 068. 查找插入位置
 * https://leetcode-cn.com/problems/N6YdxV/
 * @author xzq
 * @create 2022-03-08-9:52
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0, t = nums.length;
        while (s < t) {
            int m = (s+t)>>1;
            if (nums[m] < target) s = m+1;
            else t = m;
        }
        return s;
    }
}
