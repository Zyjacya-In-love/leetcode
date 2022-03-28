package lcof66;

/**
 * 剑指 Offer 66. 构建乘积数组
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * @author xzq
 * @create 2022-03-28-10:32
 */
class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] mulALeft = new int[n+1];
        int[] mulARight = new int[n+2];
        mulALeft[0] = 1;
        for (int i = 1; i <= n; i++) {
            mulALeft[i] = mulALeft[i-1]*a[i-1];
        }
        mulARight[n+1] = 1;
        for (int i = n; i >= 1; i--) {
            mulARight[i] = mulARight[i+1]*a[i-1];
        }
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            ans[i-1] = mulALeft[i-1] * mulARight[i+1];
        }
        return ans;
    }
}