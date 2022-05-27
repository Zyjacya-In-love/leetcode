package t654;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/
 * @author xzq
 * @create 2022-05-27-23:10
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int maxValueIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        root.left = constructMaximumBinaryTree(nums, start, maxValueIndex-1);
        root.right = constructMaximumBinaryTree(nums, maxValueIndex+1, end);
        return root;
    }
}
// 通过   1 ms	41.6 MB