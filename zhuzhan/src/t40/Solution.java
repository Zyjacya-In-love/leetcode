package t40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @author xzq
 * @create 2022-05-04-15:37
 */
//class Solution {
//    private LinkedList<Integer> track;
//    private List<List<Integer>> res;
//
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        track = new LinkedList<>();
//        res = new ArrayList<>();
//        Arrays.sort(candidates);
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
//            if (i > start && candidates[i] == candidates[i-1]) {
//                continue;
//            }
//            track.add(candidates[i]);
//            backtrack(candidates, i+1, target-candidates[i]);
//            track.removeLast();
//        }
//    }
//}
// 通过   4 ms	42.4 MB


/*
 * @create 2022-05-29-19:10
 */
class Solution {

    private LinkedList<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i != startIndex && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target-candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            backtrack(i+1, candidates, target-candidates[i]);
            path.removeLast();
        }
    }
}
// 通过   2 ms	42 MB