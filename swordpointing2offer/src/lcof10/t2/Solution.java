package lcof10.t2;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author xzq
 * @create 2022-03-13-9:36
 */
// 方法一、迭代 O(n)
//class Solution {
//    public int numWays(int n) {
//        final int MOD = (int) (1e9+7);
//        if (n < 2) return 1;
//        int prev = 1;
//        int now = 1;
//        int next = 2;
//        for (int i = 3; i <= n; i++) {
//            prev = now;
//            now = next;
//            next = (prev+now)%MOD;
//        }
//        return next;
//    }
//}
// 方法二、矩阵快速幂 O(logn)
class Solution {
    private final int MOD = (int) (1e9+7);
    public int numWays(int n) {
        if (n < 2) return 1;
        int[][] M = {{1, 1}, {1, 0}};
        int[][] res = matPow(M, n-1);
        return (res[0][0]+res[0][1])%MOD;
    }
    private int[][] matPow(int[][] x, int n) {
        int[][] res = {{1,0}, {0,1}};
        while (n > 0) {
            if ((n&1)==1) res = matMul(res, x);
            n >>= 1;
            x = matMul(x, x);
        }
        return res;
    }
    private int[][] matMul(int[][] a, int[][] b) {
        int[][] res = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = (int)((((long)a[i][0]*b[0][j]) + ((long)a[i][1]*b[1][j]))%MOD);
            }
        }
        return res;
    }
}