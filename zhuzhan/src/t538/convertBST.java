package t538;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * @author xzq
 * @create 2022-05-28-23:17
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
//    private int sum = 0;
//    public TreeNode convertBST(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        convertBST(root.right);
//        root.val += sum;
//        sum = root.val;
//        convertBST(root.left);
//        return root;
//    }
//}
// 通过   0 ms	41.6 MB

//      迭代
class Solution {
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            curr.val += sum;
            sum = curr.val;
            curr = curr.left;
        }
        return root;
    }
}
// 通过   1 ms	41.3 MB