package t222;

import sun.misc.ObjectInputFilter;

/**
 * 222. 完全二叉树的节点个数
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @author xzq
 * @create 2022-05-02-15:47
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
//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        TreeNode leftNode = root.left;
//        TreeNode rightNode = root.right;
//        int leftHeight = 0, rightHeight = 0;
//        while (leftNode != null) {
//            leftHeight++;
//            leftNode = leftNode.left;
//        }
//        while (rightNode != null) {
//            rightHeight++;
//            rightNode = rightNode.right;
//        }
//        if (leftHeight == rightHeight) {
//            return (int) (Math.pow(2, leftHeight+1)-1);
//        }
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }
//}
// 通过   0 ms	43.8 MB

// leetcode 官解 二分+位运算
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // 找到第一个不存在的节点标号（标号从1开始，到 2^(h+1)-1 结束，h是层数，从0开始）
        int low = 1 << level, high = (1 << (level + 1));
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low-1;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
