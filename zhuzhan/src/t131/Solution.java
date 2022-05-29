package t131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode.cn/problems/palindrome-partitioning/
 * @author xzq
 * @create 2022-05-29-19:42
 */
class Solution {

    private LinkedList<String> path;
    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex+1; i <= s.length(); i++) {
            String tmp = s.substring(startIndex, i);
            if (check(tmp)) {
                path.addLast(tmp);
                backtrack(s, i);
                path.removeLast();
            }
        }
    }

    private boolean check(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// 通过   8 ms	54.4 MB