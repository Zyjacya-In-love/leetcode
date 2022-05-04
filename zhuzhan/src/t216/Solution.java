package t216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * @author xzq
 * @create 2022-05-04-16:04
 */
class Solution {
    private LinkedList<Integer> track;
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        track = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(k, n, 1);
        return res;
    }

    private void backtrack(int k, int target, int start) {
        if (track.size() == k && target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (track.size() >= k || target < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            track.add(i);
            backtrack(k, target-i, i+1);
            track.removeLast();
        }
    }
}
// 通过   0 ms	39.2 MB
