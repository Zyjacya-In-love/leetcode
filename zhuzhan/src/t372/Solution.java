package t372;

/**
 * 372. 超级次方
 * https://leetcode.cn/problems/super-pow/
 * @author xzq
 * @create 2022-05-12-21:43
 */
class Solution {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }

    private int superPow(int a, int[] b, int end, int MOD) {
        if (end == 0) {
            return 1;
        }
        int first = power(superPow(a, b, end - 1, MOD), 10, MOD);
        int second = power(a, b[end - 1], MOD);
        return (first * second) % MOD;
    }

    private int power(int x, int n, int MOD) {
        int res = 1;
        x = x % MOD;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }
}
// 通过   2 ms	41.3 MB
