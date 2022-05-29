package t39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 * @author xzq
 * @create 2022-05-04-15:53
 */
//class Solution {
//    private LinkedList<Integer> track;
//    private List<List<Integer>> res;
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        track = new LinkedList<>();
//        res = new ArrayList<>();
//        backtrack(candidates, 0, target);
//        return res;
//    }
//
//    private void backtrack(int[] candidates, int start, int target) {
//        if (target == 0) {
//            res.add(new ArrayList<>(track));
//            return;
//        }
//        if (target < 0) {
//            return;
//        }
//        for (int i = start; i < candidates.length; i++) {
//            track.add(candidates[i]);
//            backtrack(candidates, i, target-candidates[i]);
//            track.removeLast();
//        }
//    }
//}
// 通过   3 ms	42.1 MB


/*
 * @create 2022-05-29-18:40
 */
//      排序 剪枝，剪去必然比 target 大的剩下的元素
class Solution {

    private LinkedList<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target);
        return res;
    }

    private void backtrack(int startIndex, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (target-candidates[i] < 0) { // 剪枝，剪去必然比 target 大的剩下的元素
                break;
            }
            path.addLast(candidates[i]);
            backtrack(i, candidates, target-candidates[i]);
            path.removeLast();
        }
    }
}
// 通过   2 ms	42 MB