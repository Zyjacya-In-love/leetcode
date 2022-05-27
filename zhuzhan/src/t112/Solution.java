package t112;

/**
 * 112. 路径总和
 * https://leetcode.cn/problems/path-sum/
 * @author xzq
 * @create 2022-05-27-21:40
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum-root.val) ||
                hasPathSum(root.right, targetSum-root.val);
    }
}
// 通过   0 ms	41.3 MB