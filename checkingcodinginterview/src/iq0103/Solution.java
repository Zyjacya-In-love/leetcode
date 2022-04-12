package iq0103;

/**
 * 面试题 01.03. URL化
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 * @author xzq
 * @create 2022-04-06-9:10
 */
class Solution {
    public String replaceSpaces(String S, int length) {
        char[] charArr = S.toCharArray();
        int pos = S.length()-1;
        for (int i = length-1; i >= 0; i--) {
            if (charArr[i] == ' ') {
                charArr[pos--] = '0';
                charArr[pos--] = '2';
                charArr[pos--] = '%';
            } else {
                charArr[pos--] = charArr[i];
            }
        }
        return new String(charArr, pos+1, S.length()-pos-1);
    }
}
