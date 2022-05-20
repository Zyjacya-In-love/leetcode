package t459;

import java.util.Arrays;

/**
 * 459. 重复的子字符串
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * @author xzq
 * @create 2022-05-20-16:48
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] next = new int[n];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));
        return next[n - 1] != 0 && n % (n - next[n - 1]) == 0;
    }
}
// 通过   40 ms	41.5 MB