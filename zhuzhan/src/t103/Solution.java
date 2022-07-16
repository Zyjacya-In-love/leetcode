package t103;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * @author xzq
 * @create 2022-07-16-18:30
 */

import java.util.*;

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
// 层序遍历，每隔一层反转 list，再加入答案
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        boolean flip = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                tmp.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            if (flip) {
                Collections.reverse(tmp);
            }
            flip = !flip;
            ans.add(tmp);
        }
        return ans;
    }
}
// 通过   1 ms	40.3 MB