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
//class Solution {
//    private LinkedList<Integer> track;
//    private List<List<Integer>> res;
//
//    public List<List<Integer>> subsets(int[] nums) {
//        track = new LinkedList<>();
//        res = new ArrayList<>();
//        backtrack(nums, 0);
//        return res;
//    }
//
//    private void backtrack(int[] nums, int start) {
//        res.add(new ArrayList<>(track));
//        for (int i = start; i < nums.length; i++) {
//            track.add(nums[i]);
//            backtrack(nums, i+1);
//            track.removeLast();
//        }
//    }
//}
// 通过   1 ms	41.5 MB


/*
 * @create 2022-05-30-16:47
 */
//        遍历回溯的树中的每一个节点，认为每个节点都是 一个子集
//class Solution {
//
//    private LinkedList<Integer> path;
//    private List<List<Integer>> res;
//
//    public List<List<Integer>> subsets(int[] nums) {
//        path = new LinkedList<>();
//        res = new ArrayList<>();
//        backtrack(nums, 0);
//        return res;
//    }
//
//    private void backtrack(int[] nums, int startIndex) {
//        res.add(new ArrayList<>(path));
//        for (int i = startIndex; i < nums.length; i++) {
//            path.addLast(nums[i]);
//            backtrack(nums, i+1);
//            path.removeLast();
//        }
//    }
//}
// 通过   0 ms	41.4 MB

//      2进制的思路，每个元素 拿或者不拿，每次都是两个选择，选到最后就是一个子集
//      也就是说这个回溯树是一个二叉树，每个节点的两个向下的枝都是拿当前元素或者不拿，那么走到叶节点才最终选完，得到一个子集
class Solution {

    private LinkedList<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        path = new LinkedList<>();
        res = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.addLast(nums[startIndex]);
        backtrack(nums, startIndex+1);
        path.removeLast();
        backtrack(nums, startIndex+1);
    }
}
// 通过   0 ms	41.3 MB