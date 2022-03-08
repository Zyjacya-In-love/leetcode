package lcof2045;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 * https://leetcode-cn.com/problems/LwUNpT/
 * @author xzq
 * @create 2022-03-08-9:43
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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = -1;
        while (!q.isEmpty()) {
            int n = q.size();
            ans = q.peek().val;
            for (int i = 0; i < n; i++) {
                TreeNode now = q.poll();
                if (now.left != null) {
                    q.offer(now.left);
                }
                if (now.right != null) {
                    q.offer(now.right);
                }
            }
        }
        return ans;
    }
}
