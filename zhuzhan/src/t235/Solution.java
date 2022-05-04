package t235;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author xzq
 * @create 2022-05-03-18:26
 */
/*
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = p.val;
        int val2 = q.val;
        if (val1 > val2) {
            int tmp = val1;
            val1 = val2;
            val2 = tmp;
        }
        return lowestCommonAncestor(root, val1, val2);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        if (root.val < val1) {
            return lowestCommonAncestor(root.right, val1, val2);
        }
        if (root.val > val2) {
            return lowestCommonAncestor(root.left, val1, val2);
        }
        return root;
    }
}
// 通过   5 ms	42.3 MB