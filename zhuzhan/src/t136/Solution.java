package t136;

/**
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-17-23:15
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
// 通过   1 ms	41.7 MB