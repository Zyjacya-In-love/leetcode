package t78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * @author xzq
 * @create 2022-05-04-14:14
 */
class Solution {
    private LinkedList<Integer> track;
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        track = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.removeLast();
        }
    }
}
// 通过   1 ms	41.5 MB