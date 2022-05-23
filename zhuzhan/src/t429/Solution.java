package t429;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N 叉树的层序遍历
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
 * @author xzq
 * @create 2022-05-23-9:33
 */
/*
// Definition for a Node.
*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                tmp.add(curr.val);
                for (Node child : curr.children) {
                    queue.offer(child);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
// 通过   3 ms	41.9 MB