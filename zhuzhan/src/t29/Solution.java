package t29;

/**
 * 29. 两数相除
 * https://leetcode.cn/problems/divide-two-integers/
 * @author xzq
 * @create 2022-07-12-21:34
 */
// 边界情况：
// 由于除数不为 0，那么 商的绝对值 必然 小于等于 被除数的绝对值
// 被除数的范围在 int 里，[-2^31, (2^31)-1]
//      ① 被除数是 0，那么商为 0，不会溢出
//      ② 如果被除数是正数，除数是正数，那么 商 为正数并且必然 小于等于 被除数的最大值 (2^31)-1，范围在 (0, (2^31)-1]不会溢出
//      ③ 如果被除数是正数，除数是负数，或者，被除数是负数，除数是正数，
//                      那么 商 必然为 负数，
//                      又因为 商的绝对值 必然 小于等于 被除数的绝对值，所以 商的绝对值 必然 小于等于 2^31，
//                      综上，|商| <= 2^31 && 商 < 0，那么商的范围即在 [-2^31, 0)，因此不会溢出
//      ④ 如果被除数是负数，除数是负数，那么 商 为正数并且 商的绝对值 小于等于 被除数绝对值的最大值 2^31
//                      也就是说，商 有可能等于 2^31，超过了 int [-2^31, (2^31)-1] 的范围，eg：-2^31 / -1
//      综上 ①②③④，商只有一种可能会超 int 范围，即 被除数是负数，除数是负数，商为 2^31
//                  而产生这种情况只有一个可能，被除数是 -2^31，除数是 -1，商是 2^31
// 算法：
// 首先特判超范围的唯一一种情况，返回 Integer.MAX_VALUE
// 符号相同更方便做比较，由于 负数 的范围比 正数 大 1，所以将 被除数和除数 都转为 负数，并记录下商的正负号状态 flag
// 下面还是用正数分析，因为比较正数直观，大于小于号反一下就可以了
// 从高位到地位，计算出 商 二进制 的每一个 1 的位置，不断地将被除数减去 当前商的最高位二进制位对应的数*除数，
//          这样就能计算下一个商的最高位二进制位。具体地将 除数 不断往上加，每次 *2 的加，直到再加就大于 被除数，
//          那么这个数 *2 的次数就是对应商的当前最高位的 1 的位置，将 商 加上当前最高位的 1 对应的数，被除数 减去这个数
//          直到 被除数 小于 除数，即商的整数部分已得出
// 最后返回 flag == -1 ? -ans : ans
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int flag = 1;
        if (dividend > 0) {
            dividend = -dividend;
        } else {
            flag = -flag;
        }
        if (divisor > 0) {
            divisor = -divisor;
        } else {
            flag = -flag;
        }
        int ans = 0;
//        int minDiv2 = Integer.MIN_VALUE/2; // 失误 2. 次：不能用除法
        int minDiv2 = 0xc0000000; // 失误 2. 次：不能用除法 -2^30 = 1010 0000, 0000 0000, 0000 0000, 0000 0000
        while (dividend <= divisor) { // 失误 1. 次：因为都是 负数，所以 < 表示绝对值更大
            int value = divisor;
            int ops = 1;
            while (value >= minDiv2 && value+value >= dividend) {
                value += value;
                ops += ops;
            }
            dividend -= value;
            ans += ops;
        }
        return flag == -1 ? -ans : ans;
    }
}
// 通过   0 ms	38.8 MB