package t98;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author xzq
 * @create 2022-05-02-13:14
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
//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, null, null);
//    }
//
//    private boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
//        if (root == null) {
//            return true;
//        }
//        if ((minNode != null && root.val <= minNode.val)
//                || (maxNode != null && root.val >= maxNode.val)) {
//            return false;
//        }
//        return isValidBST(root.left, minNode, root)
//                && isValidBST(root.right, root, maxNode);
//    }
//}
// 通过   0 ms	41.3 MB


/*
 * @create 2022-05-02-13:17
 */
//      递归 利用 搜索树的中序遍历是有序的特性
//class Solution {
//
//    private TreeNode lastNode = null;
//
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        boolean isLeft = isValidBST(root.left);
//        if (!isLeft) {
//            return false;
//        }
//        if (lastNode != null && lastNode.val >= root.val) {
//            return false;
//        }
//        lastNode = root;
//        return isValidBST(root.right);
//    }
//}
// 通过   0 ms	40.9 MB

//      迭代
class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode lastNode = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (lastNode != null && lastNode.val >= curr.val) {
                return false;
            }
            lastNode = curr;
            curr = curr.right;
        }
        return true;
    }
}
// 通过   1 ms	41.2 MB