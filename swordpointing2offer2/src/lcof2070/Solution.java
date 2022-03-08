package lcof2070;

/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 * https://leetcode-cn.com/problems/skFtm2/
 * @author xzq
 * @create 2022-03-08-9:55
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
