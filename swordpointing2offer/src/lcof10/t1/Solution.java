package lcof10.t1;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @author xzq
 * @create 2022-03-13-8:52
 */
// 方法一：迭代 O(n)
//class Solution {
//    public int fib(int n) {
//        int MOD = (int) (1e9+7);
//        int prev = 0;
//        int next = 1;
//        for (int i = 0; i < n; i++) {
//            prev = (prev+next)%MOD;
//            int tmp = prev;
//            prev = next;
//            next = tmp;
//        }
//        return prev;
//    }
//}
// 方法二：矩阵快速幂 O(logn)
class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        int[][] M = {{1,1},{1,0}};
        int[][] res = matPow(M, n-1);
        return res[0][0];
    }
    private int[][] matPow(int[][] x, int n) {
        int[][] res = {{1,0},{0,1}};
        while (n > 0) {
            if ((n&1)==1) res = matMul(res, x);
            n >>= 1;
            x = matMul(x, x);
        }
        return res;
    }
    private int[][] matMul(int[][] a, int[][] b) {
        int MOD = (int) (1e9 + 7);
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                res[i][j] = (int)((((long)a[i][0]*b[0][j]) + ((long)a[i][1]*b[1][j]))% MOD);
            }
        }
        return res;
    }
}
