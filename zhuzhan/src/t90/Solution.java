package t90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 * @author xzq
 * @create 2022-05-04-15:29
 */
class Solution {
    private LinkedList<Integer> track;
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        track = new LinkedList<>();
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
// 通过   1 ms	41.7 MB