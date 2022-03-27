package lcof56.t1;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @author xzq
 * @create 2022-03-27-12:18
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        int xorSum = 0;
        for (int x : nums) {
            xorSum ^= x;
        }
        int pos1 = 0;
        while ((xorSum&1) == 0) {
            xorSum >>= 1;
            pos1++;
        }
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if (((x>>pos1)&1) == 1) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        return new int[]{a, b};
    }
}