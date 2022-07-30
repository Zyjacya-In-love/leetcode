package t191;

/**
 * @title 191. 位1的个数
 * @link https://leetcode.cn/problems/number-of-1-bits/
 * @from leetcode top 145
 * @author xzq
 * @create 2022-07-30-22:53
 */
// 会的只有循环检查二进制位
// n&(n-1) 是去掉 n 二进制最低的一位 1 后的结果，每次去掉一位 1，计数
//public class Solution {
//    // you need to treat n as an unsigned value
//    public int hammingWeight(int n) {
//        int cnt = 0;
//        while (n != 0) { // 错 1. 次：写的 n>0，但是 n 可能是 负数
//            n &= (n-1);
//            cnt++;
//        }
//        return cnt;
//    }
//}
// 通过   0 ms	38.6 MB

// O(1) 分治法
// 参考理解：https://blog.csdn.net/weixin_30587927/article/details/101093369
//          https://segmentfault.com/a/1190000015763941
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int M1 = 0x55555555;
        int M2 = 0x33333333;
        int M4 = 0x0f0f0f0f;
        int M8 = 0x00ff00ff;
        int M16 = 0x0000ffff;
        n = (n&M1) + ((n>>>1)&M1);
        n = (n&M2) + ((n>>>2)&M2);
        n = (n&M4) + ((n>>>4)&M4);
        n = (n&M8) + ((n>>>8)&M8);
        n = (n&M16) + ((n>>>16)&M16);
        return n;
    }
}
// 通过   0 ms	38.4 MB