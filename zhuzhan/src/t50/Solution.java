package t50;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 50. Pow(x, n)
 * https://leetcode.cn/problems/powx-n/
 * @author xzq
 * @create 2022-07-13-21:08
 */
// 快速幂：根据指数运算行性质，x^n = (x^a*x^b*x^c) n=(a+b+c)，
//        并且按照 n 的二进制位，n = (n0*1+n0*2+4+) n0,n1,...,nm 是 n 的二进制第 m 位的数字
//        综上：x^n = (x^(n0*1))*(x^(n1*2))*(x^(n2*4))* ... *(x^(nm*2^m))
// 可以得到每一个二进制位 x 次幂的值，然后判断 n 的这个二进制位是否为 1，是 1 则将 x^(2^m) 乘入结果
// x^(2^m) 可以由 每一次的 x 乘自己得到 x^(2^m) = x^(2^(m-1)) * x^(2^(m-1))，
class Solution {
    public double myPow(double x, int n) {
        long b = n;
        if (n < 0) {
            b = -b;
        }
        double res = 1;
        while (b != 0) {
            if ((b&1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1; // 错 1.2.3. 次：n 最小值是 -2^31，把 n 变成正数会超范围，官方题解把 n int->long，不纠结 int 了，也用 long
        }
        return n < 0 ? 1/res : res;
    }
}
// 通过   0 ms	40.5 MB