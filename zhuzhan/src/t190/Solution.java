package t190;

/**
 * @title 190. 颠倒二进制位
 * @link https://leetcode.cn/problems/reverse-bits/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-29-22:42
 */
// 思路很简单，遍历 32 位，如果当前位是 1，就把结果的 31-i 这个位置变成 1
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&(1<<i)) != 0) {
                res |= (1<<(31-i));
            }
        }
        return res;
    }
}
// 通过   0 ms	41.1 MB