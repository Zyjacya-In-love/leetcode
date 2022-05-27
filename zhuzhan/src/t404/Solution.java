package t404;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 404. 左叶子之和
 * https://leetcode.cn/problems/sum-of-left-leaves/
 * @author xzq
 * @create 2022-05-27-18:02
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
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left != null && (root.left.left == null && root.left.right == null)) {
//            return root.left.val + sumOfLeftLeaves(root.right);
//        }
//        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
//    }
//}
// 通过   0 ms	39.1 MB

//      迭代
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left != null && (curr.left.left == null && curr.left.right == null)) {
                sum += curr.left.val;
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        return sum;
    }
}
// 通过   1 ms	39.2 MB