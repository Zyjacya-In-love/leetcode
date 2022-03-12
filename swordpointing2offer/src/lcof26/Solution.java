package lcof26;

/**
 * 剑指 Offer 26. 树的子结构
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * @author xzq
 * @create 2022-03-12-8:48
 * 9.35 才写完，速度不太妙啊！！！
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
    private boolean ans = false;
    private boolean dfs(TreeNode A, TreeNode B) {
        if (A == null) return false;
        if (A.val == B.val) {
            boolean isSubLeft = (B.left == null) || dfs(A.left, B.left);
            boolean isSubRight = (B.right == null) || dfs(A.right, B.right);
            return isSubLeft && isSubRight;
        }
        return false;
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (!ans) ans = dfs(A, B);
        if (!ans) ans = isSubStructure(A.left, B);
        if (!ans) ans = isSubStructure(A.right, B);
        return ans;
    }
}
