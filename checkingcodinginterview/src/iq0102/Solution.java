package iq0102;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 * @author xzq
 * @create 2022-04-06-8:56
 */
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        char[] charArr = s1.toCharArray();
        Arrays.sort(charArr);
        String s1Sort = new String(charArr);
        charArr = s2.toCharArray();
        Arrays.sort(charArr);
        String s2Sort = new String(charArr);
        return s1Sort.equals(s2Sort);
    }
}