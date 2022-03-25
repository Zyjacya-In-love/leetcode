package lcof55.t2;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * @author xzq
 * @create 2022-03-25-9:03
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
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        if (flag == false) {
            return -1;
        }
        int rightDepth = dfs(root.right);
        if (flag == false) {
            return -1;
        }
        if (Math.abs(leftDepth-rightDepth) > 1) {
            flag = false;
            return -1;
        }
        return Math.max(leftDepth, rightDepth)+1;
    }
}