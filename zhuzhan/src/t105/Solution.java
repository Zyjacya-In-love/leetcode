package t105;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author xzq
 * @create 2022-05-27-22:56
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootValue = preorder[preStart];
        int inRootIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                inRootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        int leftTreeLen = inRootIndex-inStart;

        int leftPreStart = preStart+1;
        int leftPreEnd = leftPreStart+leftTreeLen-1;
        int leftInStart = inStart;
        int leftInEnd = inRootIndex-1;
        root.left = buildTree(preorder, leftPreStart, leftPreEnd, inorder, leftInStart, leftInEnd);

        int rightPreStart = leftPreStart+leftTreeLen;
        int rightPreEnd = preEnd;
        int rightInStart = inRootIndex+1;
        int rightInEnd = inEnd;
        root.right = buildTree(preorder, rightPreStart, rightPreEnd, inorder, rightInStart, rightInEnd);
        return root;
    }
}
// 通过   3 ms	41.4 MB