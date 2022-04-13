package iq0101;

import java.util.BitSet;

/**
 * 面试题 01.01. 判定字符是否唯一
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * @author xzq
 * @create 2022-04-13-14:47
 */
class Solution {
    public boolean isUnique(String astr) {
        BitSet flag = new BitSet();
        for (int i = 0; i < astr.length(); i++) {
            if (flag.get(astr.charAt(i))) {
                return false;
            }
            flag.set(astr.charAt(i));
        }
        return true;
    }
}