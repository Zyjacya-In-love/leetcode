package t22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 *  https://leetcode-cn.com/problems/generate-parentheses/
 * @author xzq
 * @create 2022-05-06-9:11
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder track = new StringBuilder();
        List<String> res = new ArrayList<>();
        generateParenthesis(n, n, track, res);
        return res;
    }

    private void generateParenthesis(int left, int right, StringBuilder track, List<String> res) {
        if (left < 0 || right < 0) {
            return;
        }
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        track.append('(');
        generateParenthesis(left-1, right, track, res);
        track.delete(track.length()-1, track.length());
        track.append(')');
        generateParenthesis(left, right-1, track, res);
        track.delete(track.length()-1, track.length());
    }
}
// 通过   0 ms	41.4 MB