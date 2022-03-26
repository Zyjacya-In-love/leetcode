package lcof07;

/**
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * @author xzq
 * @create 2022-03-26-15:31
 */
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        return dfs(0, preorder.length, 0, inorder.length);
    }
    private TreeNode dfs(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart >= preEnd) {
            return null;
        }
        TreeNode now = new TreeNode(preorder[preStart]);
        int pos = inStart;
        for (int i = inStart; i < inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                pos = i;
                break;
            }
        }
        int leftLen = pos-inStart;
        int rightLen = inEnd-pos-1;
        now.left = dfs(preStart+1, preStart+1+leftLen, inStart, pos);
        now.right = dfs(preStart+1+leftLen, preEnd, pos+1, inEnd);
        return now;
    }
}