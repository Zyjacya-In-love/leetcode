package t367;

/**
 * 367. 有效的完全平方数
 * https://leetcode.cn/problems/valid-perfect-square/
 * @author xzq
 * @create 2022-05-14-10:13
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        int s = 1, t = num;
        int ans = 0;
        while (s <= t) {
            int m = s + ((t-s)>>1);
            if ((long)m*m <= num) {
                ans = m;
                s = m+1;
            } else {
                t = m-1;
            }
        }
        return (long) ans * ans == num;
    }
}
// 通过   0 ms	38.3 MB
