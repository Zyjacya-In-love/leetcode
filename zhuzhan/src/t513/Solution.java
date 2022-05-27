package t513;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 513. 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @author xzq
 * @create 2022-05-27-21:15
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
//
//    private int maxDepth = -1;
//    private int leftValue;
//
//    public int findBottomLeftValue(TreeNode root) {
//        dfs(root, 0);
//        return leftValue;
//    }
//
//    private void dfs(TreeNode root, int depth) {
//        if (root.left == null && root.right == null) {
//            if (depth > maxDepth) {
//                maxDepth = depth;
//                leftValue = root.val;
//            }
//            return;
//        }
//        if (root.left != null) {
//            dfs(root.left, depth+1);
//        }
//        if (root.right != null) {
//            dfs(root.right, depth+1);
//        }
//    }
//}
// 通过   0 ms	41.1 MB

// 迭代 层序遍历 每次记录队头第一个，最后得到的就是最左边的节点值
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        int leftValue = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            leftValue = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return leftValue;
    }
}
// 通过   1 ms	41.2 MB