package iq0104;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.04. 回文排列
 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 * @author xzq
 * @create 2022-04-11-9:24
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        BitSet bmap = new BitSet(128);
        for (int i = 0; i < s.length(); i++) {
            bmap.set(s.charAt(i), !bmap.get(s.charAt(i)));
        }
        return bmap.cardinality() <= 1;
    }
}