package t144;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @author xzq
 * @create 2022-05-22-20:33
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
//    递归
//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        return res;
//    }
//
//    private void dfs(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        res.add(root.val);
//        dfs(root.left, res);
//        dfs(root.right, res);
//    }
//}
// 通过   0 ms	39 MB

//    迭代
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return res;
    }
}
// 通过   0 ms	39.6 MB

//    迭代2，标记法：把访问过的中间节点加一个标记 null，遇到 null 就把栈顶加入结果
//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//        if (root != null) {
//            stack.push(root);
//        }
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.pop();
//            if (curr != null) {
//                if (curr.right != null) {
//                    stack.push(curr.right);
//                }
//                if (curr.left != null) {
//                    stack.push(curr.left);
//                }
//                stack.push(curr);
//                stack.push(null);
//            } else {
//                curr = stack.pop();
//                res.add(curr.val);
//            }
//        }
//        return res;
//    }
//}
// 通过   0 ms	39.4 MB