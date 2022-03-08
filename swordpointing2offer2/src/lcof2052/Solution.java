package lcof2052;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 * https://leetcode-cn.com/problems/NYBBNL/
 * @author xzq
 * @create 2022-03-08-9:45
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
    private Deque<TreeNode> st;
    TreeNode parent;
    public void dfs(TreeNode root) {
        if (root == null) return;
        st.push(root);
        dfs(root.left);
        parent.right = st.pop();
        parent = parent.right;
        parent.left = null;
        dfs(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        parent = new TreeNode(-1);
        TreeNode ans = parent;
        st = new LinkedList<>();
        dfs(root);
        return ans.right;
    }
}

