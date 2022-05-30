package t491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 491. 递增子序列
 * https://leetcode.cn/problems/increasing-subsequences/
 * @author xzq
 * @create 2022-05-30-18:20
 */
class Solution {

    private LinkedList<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> findSubsequences(int[] nums) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        if (path.size() >= 2) { // 错一次，元素个数大于 2 才算一个递增序列
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> vis = new HashSet<>(); // 错一次，去重复，在这一个树层上不能出现重复元素
        for (int i = startIndex; i < nums.length; i++) {
            if (vis.contains(nums[i])) {
                continue;
            }
            if (path.isEmpty() || nums[i] >= path.getLast()) { // 错一次，忘记 path 为空的情况
                vis.add(nums[i]);
                path.addLast(nums[i]);
                backtrack(nums, i+1);
                path.removeLast();
            }
        }
    }
}
// 通过   4 ms	47 MB