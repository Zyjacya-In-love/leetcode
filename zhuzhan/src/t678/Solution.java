package t678;

/**
 * 678. 有效的括号字符串
 * https://leetcode.cn/problems/valid-parenthesis-string/
 * @from nio7.16 提前批笔试 2
 * @author xzq
 * @create 2022-07-16-20:37
 */
// 难点在于 * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
// 计数 s[0:i] 子串中，可用 '(' 的数量范围，数量在 [l, r] 之间
// 结束条件：一旦计数过程中，最大数量 r 小于 0，返回 false
// 计数分种情况：
//          ① '('：[l,r] -> [l+1, r+1]
//          ② ')'：[l,r] -> [l-1, r-1]
//          ③ '*'：[l,r] -> [l-1, r+1]
//          需要注意的是：l 不会出现 负数，因为是可能的数量范围，只要 最大数量 r 没小于 0，最小数量 l 是不会小于 0 的
// 最后判断 '(' 的最小数量 l 是不是等于 0
// （最小数量是 0，说明一定有一种匹配方式使 s 有效，反之如果 l>0，说明 '(' 多了，而如果 ')' 多了，遍历过程中就返回 false 了）
//class Solution {
//    public boolean checkValidString(String s) {
//        int l = 0, r = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char curr = s.charAt(i);
//            if (curr == '(') {
//                l++;
//                r++;
//            } else if (curr == ')') {
//                l = Math.max(l-1, 0);
//                r--;
//                if (r < 0) {
//                    return false;
//                }
//            } else {
//                l = Math.max(l-1, 0);
//                r++;
//            }
//        }
//        return l == 0;
//    }
//}


/*
 * @from my unity exam 1006 3t
 * @create 2022-10-06-19:00
 */
class Solution {
    public boolean checkValidString (String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                l++;
                r++;
            } else if (ch == ')') {
                l = Math.max(0, l-1);
                r--;
                if (r < 0) {
                    return false;
                }
            } else {
                l = Math.max(0, l-1);
                r++;
            }
        }
        return l == 0;
    }
}
// 通过   0 ms	39.5 MB