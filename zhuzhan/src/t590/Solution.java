package t590;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * @author xzq
 * @create 2022-03-12-11:07
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
    private List<Integer> ans;
    private void dfs(Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            dfs(child);
        }
        ans.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
}
