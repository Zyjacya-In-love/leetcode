package t96;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode.cn/problems/unique-binary-search-trees/
 * @author xzq
 * @create 2022-06-06-23:50
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
// 通过   0 ms	38.5 MB