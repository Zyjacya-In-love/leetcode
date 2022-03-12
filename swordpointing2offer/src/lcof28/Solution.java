package lcof28;

/**
 * 剑指 Offer 28. 对称的二叉树
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * @author xzq
 * @create 2022-03-12-10:10
 * 36min 才写出来，效率还低，这题也不行呀
 */

import java.util.Deque;
import java.util.LinkedList;

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        LinkedList<TreeNode> levelNodes = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int levelNum = deque.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode now = deque.poll();
                if (now != null) {
                    deque.offer(now.left);
                    deque.offer(now.right);
                }
                levelNodes.add(now);
            }
            while (levelNodes.size() > 1) {
                TreeNode first = levelNodes.pollFirst();
                TreeNode last = levelNodes.pollLast();
                if (!((first == null && last == null) || ((first != null && last != null) && (first.val == last.val)))) {
                    return false;
                }
            }
            levelNodes.clear();
        }
        return true;
    }
}
