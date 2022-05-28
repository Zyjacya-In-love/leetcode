package t530;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 * @author xzq
 * @create 2022-05-28-13:38
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
//      递归 利用中序遍历有序的性质
class Solution {

    private TreeNode lastNode = null;
    private int minSub = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minSub;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (lastNode != null) {
            minSub = Math.min(minSub, root.val-lastNode.val);
        }
        lastNode = root;
        dfs(root.right);
    }
}
// 通过   0 ms	41.2 MB
