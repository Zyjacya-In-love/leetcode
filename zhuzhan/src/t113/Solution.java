package t113;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode.cn/problems/path-sum-ii/
 * @author xzq
 * @create 2022-05-27-22:10
 */
/*
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    private List<Integer> path;
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        path.add(root.val);
        backtrack(root, targetSum-root.val);
        return res;
    }

    private void backtrack(TreeNode root, int rest) {
        if (root.left == null && root.right == null) {
            if (rest == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            backtrack(root.left, rest-root.left.val);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            backtrack(root.right, rest-root.right.val);
            path.remove(path.size()-1);
        }
    }
}
// 通过   1 ms	41.5 MB