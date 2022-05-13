package t5;


/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * @author xzq
 * @create 2022-05-13-9:27
 */
class Solution {
    public String longestPalindrome(String s) {
        String ans = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            String odd = getPalindrome(s, i, i);
            String even = getPalindrome(s, i, i+1);
            if (odd.length() > ans.length()) {
                ans = odd;
            }
            if (even.length() > ans.length()) {
                ans = even;
            }
        }
        return ans;
    }

    private String getPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
// 通过   30 ms	41.8 MB