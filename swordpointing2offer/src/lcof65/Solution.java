package lcof65;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @author xzq
 * @create 2022-03-26-22:02
 */
class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a&b)<<1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
