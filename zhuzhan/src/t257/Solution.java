package t257;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/
 * @author xzq
 * @create 2022-05-27-14:48
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
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        backtrack(root, "", res);
//        return res;
//    }
//
//    private void backtrack(TreeNode root, String path, List<String> res) {
//        if (root.left == null && root.right == null) {
//            res.add(path + root.val);
//            return;
//        }
//        if (root.left != null) {
//            backtrack(root.left, path+root.val+"->", res);
//        }
//        if (root.right != null) {
//            backtrack(root.right, path+root.val+"->", res);
//        }
//    }
//}
// 通过   8 ms	41.5 MB


// 看 lc 官解 下面评论 改成 StringBuilder
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder path, List<String> res) {
        int curLen = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(path.toString());
            path.setLength(curLen);
            return;
        }
        path.append("->");
        if (root.left != null) {
            dfs(root.left, path, res);
        }
        if (root.right != null) {
            dfs(root.right, path, res);
        }
        path.setLength(curLen); // setLength 可以说是非常直接的删除了
    }
}
// 通过   1 ms	40.2 MB