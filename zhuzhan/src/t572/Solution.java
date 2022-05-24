package t572;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 572. 另一棵树的子树
 * https://leetcode.cn/problems/subtree-of-another-tree/
 * @author xzq
 * @create 2022-05-24-23:14
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
//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//        if (root == null && subRoot == null) {
//            return true;
//        }
//        Deque<TreeNode> stack = new LinkedList<>();
//        if (root != null) {
//            stack.push(root);
//        }
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.pop();
//            if (compare(curr, subRoot)) {
//                return true;
//            }
//            if (curr.left != null) {
//                stack.push(curr.left);
//            }
//            if (curr.right != null) {
//                stack.push(curr.right);
//            }
//        }
//        return false;
//    }
//
//    private boolean compare(TreeNode curr, TreeNode subRoot) {
//        if (curr == null && subRoot == null) {
//            return true;
//        }
//        if (curr == null || subRoot == null) {
//            return false;
//        }
//        if (curr.val != subRoot.val) {
//            return false;
//        }
//        return compare(curr.left, subRoot.left) && compare(curr.right, subRoot.right);
//    }
//}
// 通过   4 ms	41.2 MB

// 将树序列化，然后子串匹配KMP
class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<Integer> rootList = getTreeSequence(root);
        List<Integer> subRootList = getTreeSequence(subRoot);
        return kmp(rootList, subRootList);
    }

    private boolean kmp(List<Integer> s, List<Integer> p) {
        int[] next = new int[p.size()];
        for (int j = 0, i = 1; i < p.size(); i++) {
            while (j > 0 && !p.get(j).equals(p.get(i))) {
                j = next[j-1];
            }
            if (p.get(j).equals(p.get(i))) {
                j++;
            }
            next[i] = j;
        }
        for (int i = 0, j = 0; i < s.size(); i++) {
            while (j > 0 && !s.get(i).equals(p.get(j))) {
                j = next[j-1];
            }
            if (s.get(i).equals(p.get(j))) {
                j++;
            }
            if (j == p.size()) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> getTreeSequence(TreeNode root) {
        int leftNull = (int) (1e5 + 1);
        int rightNull = (int) (1e5 + 2);
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.left == null) {
                res.add(leftNull);
            }
            if (curr.right == null) {
                res.add(rightNull);
            }
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
// 通过   5 ms	41.7 MB