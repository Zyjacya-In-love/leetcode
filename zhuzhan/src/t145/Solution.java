package t145;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @author xzq
 * @create 2022-05-22-20:37
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
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        return res;
//    }
//
//    private void dfs(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left, res);
//        dfs(root.right, res);
//        res.add(root.val);
//    }
//}
// 通过   0 ms	39.8 MB

//      迭代，先序遍历 中左右，后序遍历 左右中，先序遍历的写法改成 中右左，最后再反转结果即是后序遍历
//class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//        if (root != null) {
//            stack.push(root);
//        }
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.pop();
//            res.add(curr.val);
//            if (curr.left != null) {
//                stack.push(curr.left);
//            }
//            if (curr.right != null) {
//                stack.push(curr.right);
//            }
//        }
//        Collections.reverse(res);
//        return res;
//    }
//}
// 通过   0 ms	39.4 MB

//    迭代2，标记法：把访问过的中间节点加一个标记 null，遇到 null 就把栈顶加入结果
//class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//        if (root != null) {
//            stack.push(root);
//        }
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.pop();
//            if (curr != null) {
//                stack.push(curr);
//                stack.push(null);
//                if (curr.right != null) {
//                    stack.push(curr.right);
//                }
//                if (curr.left != null) {
//                    stack.push(curr.left);
//                }
//            } else {
//                curr = stack.pop();
//                res.add(curr.val);
//            }
//        }
//        return res;
//    }
//}
// 通过   0 ms	39.6 MB

//      迭代3，记录上一次的输出：一直循环向左直到为null，取栈顶，如果栈顶右孩子为null，或者栈顶右孩子是上一次的输出，添加栈顶，否则向右孩子继续
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.right == null || curr.right == pre) {
                res.add(curr.val);
                pre = curr;
                curr = null;
            } else {
                stack.push(curr);
                curr = curr.right;
            }
        }
        return res;
    }
}
// 通过   0 ms	39.8 MB