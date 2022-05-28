package t501;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * @author xzq
 * @create 2022-05-28-13:56
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

    private TreeNode lastNode = null;
    private List<Integer> res = new ArrayList<>();
    private int count = 0;
    private int maxCount = 1;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (lastNode != null && lastNode.val == root.val) {
            count++;
        } else {
            count = 1;
        }
        lastNode = root;
        if (count == maxCount) {
            res.add(root.val);
        } else if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(root.val);
        }
        dfs(root.right);
    }
}
// 通过   0 ms	41.9 MB