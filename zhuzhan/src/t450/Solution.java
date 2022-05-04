package t450;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * @author xzq
 * @create 2022-05-02-13:37
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
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) {
//            return null;
//        }
//        if (root.val == key) {
//            if (root.left == null) return root.right;
//            if (root.right == null) return root.left;
//            TreeNode leftMaxNode = delMaxNode(root.left);
//            if (root.left != leftMaxNode) {
//                leftMaxNode.left = root.left;
//            }
//            leftMaxNode.right = root.right;
//            return leftMaxNode;
//        }
//        if (key < root.val) {
//            root.left = deleteNode(root.left, key);
//        }
//        if (key > root.val) {
//            root.right = deleteNode(root.right, key);
//        }
//        return root;
//    }
//
//    private TreeNode delMaxNode(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode parent = null;
//        while (root.right != null) {
//            parent = root;
//            root = root.right;
//        }
//        // 需要把要替换上去的最大节点的父节点的右孩子指空（或者当前节点的最子节点），否则会出现环
//        if (parent != null) {
//            parent.right = root.left;
//        }
//        return root;
//    }
//}
// 通过   0 ms	41.4 MB

// 只有一个删除方法
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode leftMaxNode = getMaxNode(root.left);
            leftMaxNode.left = deleteNode(root.left, leftMaxNode.val);
            leftMaxNode.right = root.right;
            return leftMaxNode;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMaxNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
// 通过   0 ms	41.5 MB