package lcof64;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @author xzq
 * @create 2022-03-25-22:46
 */
class Solution {
    public int sumNums(int n) {
        boolean flag = (n == 0) || ((n += sumNums(n-1)) > 0);
        return n;
    }
}