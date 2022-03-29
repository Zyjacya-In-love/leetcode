package lcof62;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @author xzq
 * @create 2022-03-29-15:06
 */
class Solution {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x+m)%i;
        }
        return x;
    }
}
