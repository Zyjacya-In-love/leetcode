package lcof15;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @author xzq
 * @create 2022-03-26-21:52
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int hanMingWeight = 0;
        while (n != 0) {
            if ((n&1) == 1) {
                hanMingWeight++;
            }
            n >>>= 1;
        }
        return hanMingWeight;
    }
}
