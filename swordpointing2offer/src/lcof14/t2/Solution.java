package lcof14.t2;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * @author xzq
 * @create 2022-04-05-8:47
 */
class Solution {
    static final long MOD = (int) (1e9+7);
    public int cuttingRope(int n) {
        if (n < 4) return n-1;
        long ans = 0;
        int div = n/3;
        int mod = n%3;
        if (mod == 0) {
            ans = powerMod(3, div);
        } else if (mod == 1) {
            ans = (powerMod(3, div-1) * 4L) % MOD;
        } else {
            ans = (powerMod(3, div) * 2L) % MOD;
        }
        return (int) ans;
    }

    private int powerMod(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n&1) == 1) {
                res = (res * x)%MOD;
            }
            x = (x*x)%MOD;
            n >>= 1;
        }
        return (int) res;
    }
}