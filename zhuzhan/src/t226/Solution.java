package t226;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/
 * @author xzq
 * @create 2022-05-24-21:59
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
// 递归 前序 后序 都可以，中序 会出现 root.left 访问两次的情况
//      递归 前序遍历
//class Solution {
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
//    }
//}
// 通过   0 ms	39.1 MB

//      迭代 前序遍历
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return root;
    }
}
// 通过   0 ms	38.8 MB