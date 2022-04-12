package iq0106;

/**
 * 面试题 01.06. 字符串压缩
 * https://leetcode-cn.com/problems/compress-string-lcci/
 * @author xzq
 * @create 2022-04-12-8:59
 */
class Solution {
    public String compressString(String S) {
        if (S == null || S.isEmpty()) return S;
        StringBuilder comStr = new StringBuilder();
        comStr.append(S.charAt(0));
        char lastChar = S.charAt(0);
        int cnt = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != lastChar) {
                comStr.append(cnt);
                comStr.append(S.charAt(i));
                cnt = 1;
                lastChar = S.charAt(i);
            } else {
                cnt++;
            }
        }
        comStr.append(cnt);
        return comStr.length() < S.length() ? comStr.toString() : S;
    }
}