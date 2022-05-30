package t47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * @author xzq
 * @create 2022-05-04-15:45
 */
//class Solution {
//    private LinkedList<Integer> track;
//    private List<List<Integer>> res;
//    boolean[] vis;
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        track = new LinkedList<>();
//        res = new ArrayList<>();
//        vis = new boolean[nums.length];
//        Arrays.sort(nums);
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
//            if (i > 0 && nums[i] == nums[i-1] && !vis[i-1]) {
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
// 通过   1 ms	42 MB


/*
 * @create 2022-05-30-22:16
 */
class Solution {

    private LinkedList<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        Arrays.sort(nums);
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
            if ((i > 0 && nums[i-1] == nums[i]) && vis[i-1] == false) {
                continue;
            }
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
// 通过   1 ms	42.2 MB