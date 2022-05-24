package t101;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 * @author xzq
 * @create 2022-05-24-23:01
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
//      递归
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return compare(root.left, root.right);
//    }
//
//    private boolean compare(TreeNode left, TreeNode right) {
//        if (left == null && right == null) {
//            return true;
//        }
//        if (left == null || right == null) {
//            return false;
//        }
//        if (left.val != right.val) {
//            return false;
//        }
//        return compare(left.left, right.right) && compare(left.right, right.left);
//    }
//}
// 通过   0 ms	39.7 MB

//      迭代
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root.left);
            queue.offer(root.right);
        }
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
// 通过   1 ms	39.9 MB