package t77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * @author xzq
 * @create 2022-05-04-15:12
 */
class Solution {
    private LinkedList<Integer> track;
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        track = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i+1, n, k-1);
            track.removeLast();
        }
    }
}
// 通过   14 ms	42.5 MB
