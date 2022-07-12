package t14;

/**
 * 14. 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/
 * @author xzq
 * @create 2022-07-12-21:16
 */
// 用第一个字符串当作基本串，和后面的所有字符串比较，维护最长公共前缀结束位置
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int end = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            end = Math.min(end, strs[i].length()); // 失误 1. 次：后面的字符串可能比 当前结束位置要小，就可能超字符串范围，eg："flower","flow"
            for (; j < end; j++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    end = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, end);
    }
}
// 通过   1 ms	39.1 MB