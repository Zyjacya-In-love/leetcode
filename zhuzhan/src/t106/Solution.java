package t106;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author xzq
 * @create 2022-05-27-22:35
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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }
        int rootValue = postorder[postEnd];
        int inRootPos = inEnd;
        for (int i = inEnd; i >= inStart; i--) {
            if (inorder[i] == rootValue) {
                inRootPos = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        int leftTreeLen = inRootPos-inStart;
        root.left = buildTree(inorder, inStart, inRootPos-1, postorder, postStart, postStart+leftTreeLen-1);
        root.right = buildTree(inorder, inRootPos+1, inEnd, postorder, postStart+leftTreeLen, postEnd-1);
        return root;
    }
}
