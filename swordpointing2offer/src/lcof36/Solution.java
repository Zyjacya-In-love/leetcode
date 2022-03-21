package lcof36;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @author xzq
 * @create 2022-03-20-23:34
 */
/*
// Definition for a Node.
*/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        List<Node> res = new ArrayList<>();
        dfs(root, res);
        int n = res.size();
        for (int i = 0; i < n; i++) {
            res.get(i).left = res.get((i-1+n)%n);
            res.get(i).right = res.get((i+1)%n);
        }
        return res.get(0);
    }
    public void dfs(Node root, List<Node> res) {
        if (root == null) return;
        dfs(root.left, res);
        res.add(root);
        dfs(root.right, res);
    }
}
