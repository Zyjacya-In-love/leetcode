package t46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * @author xzq
 * @create 2022-05-04-15:21
 */
//class Solution {
//    private LinkedList<Integer> track;
//    private List<List<Integer>> res;
//    private boolean[] vis;
//
//    public List<List<Integer>> permute(int[] nums) {
//        track = new LinkedList<>();
//        res = new ArrayList<>();
//        vis = new boolean[nums.length];
//        backtrack(nums);
//        return res;
//    }
//
//    private void backtrack(int[] nums) {
//        if (track.size() == nums.length) {
//            res.add(new ArrayList<>(track));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (vis[i]) {
//                continue;
//            }
//            track.add(nums[i]);
//            vis[i] = true;
//            backtrack(nums);
//            track.removeLast();
//            vis[i] = false;
//        }
//    }
//}
// 通过   1 ms	41.4 MB


/*
 * @create 2022-05-30-21:55
 */
class Solution {

    private LinkedList<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backtrack(nums, vis);
        return res;
    }

    private void backtrack(int[] nums, boolean[] vis) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            path.addLast(nums[i]);
            backtrack(nums, vis);
            path.removeLast();
            vis[i] = false;
        }
    }
}
// 通过   1 ms	41.2 MB