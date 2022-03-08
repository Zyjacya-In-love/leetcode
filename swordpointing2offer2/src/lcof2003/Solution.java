package lcof2003;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * https://leetcode-cn.com/problems/w3tCBm/
 * @author xzq
 * @create 2022-03-08-9:18
 */
public class Solution {
    public int[] countBits(int n) {
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i>>1] + (i&1);
        }
        return f;
    }
}
