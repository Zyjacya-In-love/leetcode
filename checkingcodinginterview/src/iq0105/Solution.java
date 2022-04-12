package iq0105;

/**
 * 面试题 01.05. 一次编辑
 * https://leetcode-cn.com/problems/one-away-lcci/
 * @author xzq
 * @create 2022-04-12-8:35
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) return true;
        int fLen = first.length();
        int sLen = second.length();
        if (fLen > sLen) return oneEditAway(second, first);
        if (sLen - fLen > 1) return false;

        for (int i = 0; i < fLen; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(i).equals(second.substring(i+1))
                        || first.substring(i+1).equals(second.substring(i+1));
            }
        }
        return true;
    }
}