package t5;


/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * @author xzq
 * @create 2022-05-13-9:27
 */
//class Solution {
//    public String longestPalindrome(String s) {
//        String ans = String.valueOf(s.charAt(0));
//        for (int i = 0; i < s.length(); i++) {
//            String odd = getPalindrome(s, i, i);
//            String even = getPalindrome(s, i, i+1);
//            if (odd.length() > ans.length()) {
//                ans = odd;
//            }
//            if (even.length() > ans.length()) {
//                ans = even;
//            }
//        }
//        return ans;
//    }
//
//    private String getPalindrome(String s, int left, int right) {
//        while (left >= 0 && right < s.length()) {
//            if (s.charAt(left) != s.charAt(right)) {
//                break;
//            }
//            left--;
//            right++;
//        }
//        return s.substring(left+1, right);
//    }
//}
// 通过   30 ms	41.8 MB


/*
 * @create 2022-07-05-16:41
 */
// 动态规划：判断 每个范围 s[i:j] 是否是回文子串，记录长度最大的子串
// 定义：dp[i][j] s[i:j] 是否是 回文子串
// 状态转移：if(s[i]==s[j])
//                  if(i==j || j=i+1) dp[i][j] = true
//                  else              dp[i][j] = dp[i+1][j-1]
//          else                      dp[i][j] = false
// 初始化：dp[i][j] = false
// 遍历顺序：更新依赖于 左下角，因此 先逆序 s 再正序 s
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if ((s.charAt(i) == s.charAt(j)) && (j-i <= 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j-i > end-start) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
// 通过   167 ms	45.8 MB