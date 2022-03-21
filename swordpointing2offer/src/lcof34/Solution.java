package lcof34;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @author xzq
 * @create 2022-03-20-22:56
 */

import java.util.ArrayList;
import java.util.List;

/**
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
    private List<List<Integer>> res;
    private List<Integer> path;
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        res = new ArrayList<>();
        if (root == null) return res;
        path = new ArrayList<>();
        path.add(root.val);
        dfs(root, root.val);
        return res;
    }
    private void dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (root.left != null) {
            path.add(root.left.val);
            dfs(root.left, sum+root.left.val);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, sum+root.right.val);
            path.remove(path.size()-1);
        }
    }
}
