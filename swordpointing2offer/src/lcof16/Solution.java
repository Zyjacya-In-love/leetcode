package lcof16;

/**
 * 剑指 Offer 16. 数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * @author xzq
 * @create 2022-03-26-17:11
 */
class Solution {
    public double myPow(double x, int n) {
        boolean flag = false;
        long newN = n;
        if (newN < 0) {
            flag = true;
            newN = -newN;
        }
        double res = 1;
        while (newN > 0) {
            if ((newN&1) == 1) {
                res *= x;
            }
            x *= x;
            newN >>= 1;
        }
        return flag ? 1/res : res;
    }
}