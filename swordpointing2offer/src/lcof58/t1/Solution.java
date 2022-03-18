package lcof58.t1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * @author xzq
 * @create 2022-03-18-9:14
 */
class Solution {
    public String reverseWords(String s) {
        List<String> res = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(res);
        return String.join(" ", res);
    }
}
