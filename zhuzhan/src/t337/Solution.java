package t337;

import java.util.HashMap;

/**
 * 337. 打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 * @author xzq
 * @create 2022-05-01-19:58
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
//class Solution {
//    private final HashMap<TreeNode, Integer> memo = new HashMap<>();
//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (memo.containsKey(root)) {
//            return memo.get(root);
//        }
//        int robIt = root.val
//                + (root.left != null ? rob(root.left.left)+rob(root.left.right) : 0)
//                + (root.right != null ? rob(root.right.left)+rob(root.right.right) : 0);
//        int notRobIt = rob(root.left) + rob(root.right);
//        int res = Math.max(robIt, notRobIt);
//        memo.put(root, res);
//        return res;
//    }
//}
// 通过   2 ms	41 MB

// 后序遍历
class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int robIt = root.val + l[1] + r[1];
        int notRobIt = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{robIt, notRobIt};
    }
}
// 通过   0 ms	40.9 MB