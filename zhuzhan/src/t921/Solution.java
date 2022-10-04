package t921;

/**
 * 921. 使括号有效的最少添加
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 * @author xzq
 * @create 2022-05-13-15:27
 */
//class Solution {
//    public int minAddToMakeValid(String s) {
//        int leftNeed = 0;
//        int rightNeed = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                rightNeed++;
//            } else {
//                rightNeed--;
//                if (rightNeed == -1) {
//                    leftNeed++;
//                    rightNeed = 0;
//                }
//            }
//        }
//        return leftNeed+rightNeed;
//    }
//}
// 通过   0 ms	39.5 MB


/*
 * @create 2022-10-04-15:05
 */
// 遍历字符串的同时计数 左括号 left 的数量，如果当前是右括号，则抵消一个左括号，如果之前没有左括号，则将左括号需求值+1，
// 遍历结束后当前左括号的数量即是所需右括号的数量，最后返回 左右括号的需求值的和
class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int leftNeed = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                if (left == 0) {
                    leftNeed++;
                } else {
                    left--;
                }
            }
        }
        return left+leftNeed;
    }
}