package t98;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author xzq
 * @create 2022-05-02-13:14
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return true;
        }
        if ((minNode != null && root.val <= minNode.val)
                || (maxNode != null && root.val >= maxNode.val)) {
            return false;
        }
        return isValidBST(root.left, minNode, root)
                && isValidBST(root.right, root, maxNode);
    }
}
// 通过   0 ms	41.3 MB
