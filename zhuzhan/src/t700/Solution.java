package t700;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @author xzq
 * @create 2022-05-02-13:28
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
//    public TreeNode searchBST(TreeNode root, int val) {
//        if (root == null || root.val == val) {
//            return root;
//        }
//        if (val < root.val) {
//            return searchBST(root.left, val);
//        }
//        return searchBST(root.right, val);
//    }
//}
// 通过   0 ms	41.6 MB

/*
 * @create 2022-05-28-13:05
 */
//      迭代
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (val < root.val){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
// 通过   0 ms	41.6 MB