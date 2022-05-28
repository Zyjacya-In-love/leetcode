package t669;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode.cn/problems/trim-a-binary-search-tree/
 * @author xzq
 * @create 2022-05-28-22:47
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
//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if (root == null) {
//            return null;
//        }
//        if (root.val < low) {
//            return trimBST(root.right, low, high);
//        } else if (root.val > high) {
//            return trimBST(root.left, low, high);
//        }
//        root.left = trimBST(root.left, low, high);
//        root.right = trimBST(root.right, low, high);
//        return root;
//    }
//}
// 通过   0 ms	40.8 MB

//      迭代
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root != null && (root.val > high || root.val < low)) {
            if (root.val > high) {
                root = root.left;
            } else if (root.val < low){
                root = root.right;
            }
        }
        TreeNode curr = root;
        while (curr != null) {
            while (curr.left != null && curr.left.val < low) {
                curr.left = curr.left.right;
            }
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            while (curr.right != null && curr.right.val > high) {
                curr.right = curr.right.left;
            }
            curr = curr.right;
        }
        return root;
    }
}
// 通过   0 ms	41.4 MB