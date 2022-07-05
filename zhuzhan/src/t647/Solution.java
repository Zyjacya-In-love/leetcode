package t647;

/**
 * 647. 回文子串
 * https://leetcode.cn/problems/palindromic-substrings/
 * @author xzq
 * @create 2022-07-05-13:46
 */
// 回文
// 定义：dp[i][j] s[i:j] 是否是 回文子串
// 状态转移：if(s[i]==s[j])
//                  if(i==j || j==i+1) dp[i][j] = true
//                  else                 dp[i][j] = dp[i+1][j-1]
//          else           dp[i][j] = false
// 初始化：dp[i][j] = false
// 遍历顺序：更新依赖 左下角 所以 先逆序 s 再正序 s
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if ((s.charAt(i) == s.charAt(j)) && (j-i <= 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
// 通过   9 ms	41.5 MB