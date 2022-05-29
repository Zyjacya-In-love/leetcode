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
//class Solution {
//    private LinkedList<Integer> track;
//    private List<List<Integer>> res;
//
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        track = new LinkedList<>();
//        res = new ArrayList<>();
//        backtrack(k, n, 1);
//        return res;
//    }
//
//    private void backtrack(int k, int target, int start) {
//        if (track.size() == k && target == 0) {
//            res.add(new ArrayList<>(track));
//            return;
//        }
//        if (track.size() >= k || target < 0) {
//            return;
//        }
//        for (int i = start; i <= 9; i++) {
//            track.add(i);
//            backtrack(k, target-i, i+1);
//            track.removeLast();
//        }
//    }
//}
// 通过   0 ms	39.2 MB


/*
 * @create 2022-05-29-12:01
 */
class Solution {

    private LinkedList<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(1, k, n);
        return res;
    }

    private void backtrack(int startIndex, int cnt, int sum) {
        if (cnt == 0) {
            if (sum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        int endIndex = 9-cnt+1;
        for (int i = startIndex; i <= endIndex; i++) {
            if (sum-i < 0) {
                break;
            }
            path.addLast(i);
            backtrack(i+1, cnt-1, sum-i);
            path.removeLast();
        }
    }
}
// 通过   0 ms	39 MB