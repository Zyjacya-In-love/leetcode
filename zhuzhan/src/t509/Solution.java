package t509;

/**
 * 509. 斐波那契数
 * https://leetcode.cn/problems/fibonacci-number/
 * @author xzq
 * @create 2022-06-06-23:30
 */
class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
// 通过   0 ms	37.9 MB