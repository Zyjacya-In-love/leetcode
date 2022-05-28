package t701;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * @author xzq
 * @create 2022-05-02-13:32
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
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null) {
//            return new TreeNode(val);
//        }
//        if (val < root.val) {
//            root.left = insertIntoBST(root.left, val);
//        } else if (val > root.val) {
//            root.right = insertIntoBST(root.right, val);
//        }
//        return root;
//    }
//}
// 通过   0 ms	42.4 MB


/*
 * @create 2022-05-28-22:07
 */
//class Solution {
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null) {
//            return new TreeNode(val);
//        }
//        if (val < root.val) {
//            root.left = insertIntoBST(root.left, val);
//        } else if (val > root.val) {
//            root.right = insertIntoBST(root.right, val);
//        }
//        return root;
//    }
//}
// 通过   0 ms	41.9 MB

//      迭代
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insertNode = new TreeNode(val);
        if (root == null) {
            return insertNode;
        }
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > val) {
                if (curr.left == null) {
                    curr.left = insertNode;
                    break;
                }
                curr = curr.left;
            } else if (curr.val < val) {
                if (curr.right == null) {
                    curr.right = insertNode;
                    break;
                }
                curr = curr.right;
            }
        }
        return root;
    }
}
// 通过   0 ms	41.9 MB