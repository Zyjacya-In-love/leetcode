package t39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 * @author xzq
 * @create 2022-05-04-15:53
 */
class Solution {
    private LinkedList<Integer> track;
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        track = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(candidates, 0, target);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            backtrack(candidates, i, target-candidates[i]);
            track.removeLast();
        }
    }
}
// 通过   3 ms	42.1 MB