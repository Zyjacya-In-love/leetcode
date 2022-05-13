package t921;

/**
 * 921. 使括号有效的最少添加
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 * @author xzq
 * @create 2022-05-13-15:27
 */
class Solution {
    public int minAddToMakeValid(String s) {
        int leftNeed = 0;
        int rightNeed = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rightNeed++;
            } else {
                rightNeed--;
                if (rightNeed == -1) {
                    leftNeed++;
                    rightNeed = 0;
                }
            }
        }
        return leftNeed+rightNeed;
    }
}
// 通过   0 ms	39.5 MB
