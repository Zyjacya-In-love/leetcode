package t111;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * @author xzq
 * @create 2022-05-23-10:41
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
// 迭代 层序遍历
//class Solution {
//    public int minDepth(TreeNode root) {
//        Deque<TreeNode> queue = new LinkedList<>();
//        if (root != null) {
//            queue.offer(root);
//        }
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            depth++;
//            for (int i = 0; i < size; i++) {
//                TreeNode curr = queue.poll();
//                if (curr.left == null && curr.right == null) {
//                    return depth;
//                }
//                if (curr.left != null) {
//                    queue.offer(curr.left);
//                }
//                if (curr.right != null) {
//                    queue.offer(curr.right);
//                }
//            }
//        }
//        return depth;
//    }
//}
// 通过   1 ms	59.8 MB

/*
 * @create 2022-05-25-9:05
 */
//      递归，后序遍历，当有一侧孩子为空的情况时，特判一下，
//      因为这时如果继续走null的孩子就会得到0，但是要求是根到叶子节点的数量。所以这时只能走另一枝路
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
// 通过   8 ms	61.3 MB