package lcof68.t1;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @author xzq
 * @create 2022-03-26-14:04
 */
/**
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
        if (root == null) {
            return null;
        }
        TreeNode leftRet = lowestCommonAncestor(root.left, p, q);
        if (leftRet != null && leftRet != p && leftRet != q) {
            return leftRet;
        }
        TreeNode rightRet = lowestCommonAncestor(root.right, p, q);
        if (rightRet != null && rightRet != p && rightRet != q) {
            return rightRet;
        }
        if (leftRet == null && rightRet == null) {
            if (root == p) {
                return p;
            } else if (root == q) {
                return q;
            } else {
                return null;
            }
        }
        if ((root == p && (leftRet == q || rightRet == q))
                || (root == q && (rightRet == p || leftRet == p))
                || (leftRet == p && rightRet == q)
                || (leftRet == q && rightRet == p)) {
            return root;
        }
        return leftRet == null ? rightRet : leftRet;
    }
}