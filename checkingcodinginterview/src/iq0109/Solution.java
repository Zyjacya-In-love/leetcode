package iq0109;

/**
 * 面试题 01.09. 字符串轮转
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 * @author xzq
 * @create 2022-04-14-10:34
 */
class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        StringBuilder sb = new StringBuilder();
        sb.append(s2);
        sb.append(s2);
        return sb.toString().contains(s1);
    }
}
