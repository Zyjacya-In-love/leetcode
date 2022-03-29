package lcof14.t1;

/**
 * 剑指 Offer 14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @author xzq
 * @create 2022-03-29-9:02
 */
class Solution {
    public int cuttingRope(int n) {
        int ans = 0;
        for (int m = 2; m <= n; m++) {
            int base = n/m;
            int addNum = n%m;
            int tmp = (int) (Math.pow(base, m-addNum) * Math.pow(base+1, addNum));
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}