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
//class Solution {
//    private LinkedList<Integer> track;
//    private List<List<Integer>> res;
//
//    public List<List<Integer>> combine(int n, int k) {
//        track = new LinkedList<>();
//        res = new ArrayList<>();
//        backtrack(1, n, k);
//        return res;
//    }
//
//    private void backtrack(int start, int n, int k) {
//        if (k == 0) {
//            res.add(new ArrayList<>(track));
//            return;
//        }
//        for (int i = start; i <= n; i++) {
//            track.add(i);
//            backtrack(i+1, n, k-1);
//            track.removeLast();
//        }
//    }
//}
// 通过   14 ms	42.5 MB


/*
 * @create 2022-05-29-11:44
 */
class Solution {

    private LinkedList<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int startIndex, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        int endIndex = n-k+1; // 剪枝，剪掉凑不够 k 个的
        for (int i = startIndex; i <= endIndex; i++) {
            path.addLast(i);
            backtrack(i+1, n, k-1);
            path.removeLast();
        }
    }
}
// 通过   1 ms	42.5 MB