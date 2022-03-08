package lcof2004;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * https://leetcode-cn.com/problems/WGki4K/
 * @author xzq
 * @create 2022-03-08-9:19
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num>>i)&1);
            }
            ans |= ((total%3)<<i);
        }
        return ans;
    }
}
