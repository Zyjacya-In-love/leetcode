package t108;


/**
 * 108. 将有序数组转换为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * @author xzq
 * @create 2022-05-28-23:01
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int middle = ((start+end)>>1);
        TreeNode curr = new TreeNode(nums[middle]);
        curr.left = sortedArrayToBST(nums, start, middle);
        curr.right = sortedArrayToBST(nums, middle+1, end);
        return curr;
    }
}
// 通过   0 ms	41.2 MB